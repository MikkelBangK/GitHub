using System;
using System.Text;
using System.Xml;
using RabbitMQ.Client;
using RabbitMQ.Client.Events;

namespace Lektion16Opgaver
{
    class Program
    {
        static void Main(string[] args)
        {
            int sekvens = 1;
            int position = 1;
            
            var factory = new ConnectionFactory() { HostName = "localhost" };
            using (var connection = factory.CreateConnection())
            using (var channel = connection.CreateModel())
            {
                // Enable Publisher Confirms
                channel.ConfirmSelect();
                
                string queueName = "MiniProjektQueue";
                string passengerQ = "PassengerQueue";
                string luggageQ = "LuggageQueue";

                // Declare queues
                channel.QueueDeclare(queue: queueName, durable: false, exclusive: false, autoDelete: false, arguments: null);
                channel.QueueDeclare(queue: passengerQ, durable: false, exclusive: false, autoDelete: false, arguments: null);
                channel.QueueDeclare(queue: luggageQ, durable: false, exclusive: false, autoDelete: false, arguments: null);

                string xmlBesked = @"
                    <FlightDetailsInfoResponse>
                        <Flight number='SK937' Flightdate='20220225'>
                            <Origin>ARLANDA</Origin>
                            <Destination>LONDON</Destination>
                        </Flight>
                        <Passenger>
                            <ReservationNumber>CA937200305251</ReservationNumber>
                            <FirstName>Anders</FirstName>
                            <LastName>And</LastName>
                        </Passenger>
                        <Luggage>
                            <Id>CA937200305251</Id>
                            <Identification>1</Identification>
                            <Category>Normal</Category>
                            <Weight>17.3</Weight>
                        </Luggage>
                        <Luggage>
                            <Id>CA937200305251</Id>
                            <Identification>2</Identification>
                            <Category>Large</Category>
                            <Weight>22.7</Weight>
                        </Luggage>
                    </FlightDetailsInfoResponse>";

                // Encode message and set properties
                var message = Encoding.UTF8.GetBytes(xmlBesked);
                var properties = channel.CreateBasicProperties();
                properties.Persistent = true;

                // Publish to main queue
                try
                {
                    channel.BasicPublish(exchange: "", routingKey: queueName, basicProperties: properties, body: message);
                    Console.WriteLine("Sent message to main queue");

                    // Wait for confirm, simulating a "transactional" commit point
                    if (!channel.WaitForConfirms())
                    {
                        throw new Exception("Main message confirmation failed.");
                    }
                    
                    ProcessPassenger(channel, xmlBesked, sekvens, ref position);
                    ProcessLuggage(channel, xmlBesked, sekvens, ref position);

                    Console.WriteLine("All messages sent and confirmed.");
                }
                catch (Exception ex)
                {
                    Console.WriteLine($"Error occurred: {ex.Message}. Rolling back...");
                    // Optionally implement rollback logic here
                }

                Console.WriteLine("Lytter efter beskeder. Tryk på [Enter] for at afslutte.");
                Console.ReadLine();
            }
        }

        static void ProcessPassenger(IModel channel, string xmlBesked, int sekvens, ref int position)
        {
            XmlDocument xml = new XmlDocument();
            xml.LoadXml(xmlBesked);

            XmlNode itemNode = xml.SelectSingleNode("/FlightDetailsInfoResponse/Passenger");
            if (itemNode != null)
            {
                // Append IDs
                XmlElement sekvensIdNode = xml.CreateElement("sekvens");
                sekvensIdNode.InnerText = sekvens.ToString();
                XmlElement positionIdNode = xml.CreateElement("position");
                positionIdNode.InnerText = position.ToString();
                itemNode.AppendChild(sekvensIdNode);
                itemNode.AppendChild(positionIdNode);

                // Publish passenger message
                var passengerMessage = Encoding.UTF8.GetBytes(itemNode.OuterXml);
                var passengerProperties = channel.CreateBasicProperties();
                passengerProperties.Persistent = true;

                channel.BasicPublish(exchange: "", routingKey: "PassengerQueue", basicProperties: passengerProperties, body: passengerMessage);
                Console.WriteLine($"Sent Passenger message: Sequence ID {sekvens}, Position ID {position}");

                // Confirm
                if (!channel.WaitForConfirms())
                {
                    throw new Exception("Passenger message confirmation failed.");
                }
            }
        }

        static void ProcessLuggage(IModel channel, string xmlBesked, int sekvens, ref int position)
        {
            XmlDocument xml = new XmlDocument();
            xml.LoadXml(xmlBesked);

            XmlNodeList itemNodeList = xml.SelectNodes("/FlightDetailsInfoResponse/Luggage");
            if (itemNodeList != null)
            {
                foreach (XmlNode luggage in itemNodeList)
                {
                    position++;
                    
                    // Append IDs
                    XmlElement sekvensIdNode = xml.CreateElement("sekvens");
                    sekvensIdNode.InnerText = sekvens.ToString();
                    XmlElement positionIdNode = xml.CreateElement("position");
                    positionIdNode.InnerText = position.ToString();
                    luggage.AppendChild(sekvensIdNode);
                    luggage.AppendChild(positionIdNode);
                    
                    //Simuler error
                    //throw new InvalidOperationException("Test exception");

                    //Publish luggage message
                    var luggageMessage = Encoding.UTF8.GetBytes(luggage.OuterXml);
                    var luggageProperties = channel.CreateBasicProperties();
                    luggageProperties.Persistent = true;
                    
                    channel.BasicPublish(exchange: "", routingKey: "LuggageQueue", basicProperties: luggageProperties, body: luggageMessage);
                    Console.WriteLine($"Sent Luggage message: Sequence ID {sekvens}, Position ID {position}");
                    
                    // Confirm
                    if (!channel.WaitForConfirms())
                    {
                        throw new Exception("Luggage message confirmation failed.");
                    }
                }
            }
        }
    }
}

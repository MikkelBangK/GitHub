using System;
using System.Text;
using System.Linq;
using System.Xml;
using System.Xml.Linq;
using RabbitMQ.Client;
using RabbitMQ.Client.Events;

namespace MiniProjekt
{
    class Program
    {
        
        static void Main(string[] args)
        {
            int sekvens = 1;
            int position = 1;
            var Resequencer = new Resequencer();
            // Opretter forbindelse til RabbitMQ-serveren
            var factory = new ConnectionFactory() { HostName = "localhost" };
            using (var connection = factory.CreateConnection())
            using (var channel = connection.CreateModel())
            {
                // Opretter en kø, hvis den ikke allerede findes
                string queueName = "MiniProjektQueue";
                channel.QueueDeclare(queue: queueName,
                    durable: false,
                    exclusive: false,
                    autoDelete: false,
                    arguments: null);
                
                                
                //Luggage og passenger q
                string passengerQ = "PassengerQueue";
                channel.QueueDeclare(queue: passengerQ,
                    durable: false,
                    exclusive: false,
                    autoDelete: false,
                    arguments: null);
                string luggageQ = "LuggageQueue";
                channel.QueueDeclare(queue: luggageQ,
                    durable: false,
                    exclusive: false,
                    autoDelete: false,
                    arguments: null);

                // XElement flightDetailsInfoResponse = new XElement("FlightInfo",
                //     new XElement("Flight", 
                //         new XAttribute("number", "SK937"),
                //         new XAttribute("Flightdate", "20220225"),
                //         new XElement("Origin", "ARLANDA"),
                //         new XElement("Destination", "LONDON")
                //     ),
                //     new XElement("Passenger",
                //         new XElement("ReservationNumber", "CA937200305251"),
                //         new XElement("FirstName", "Anders"),
                //         new XElement("LastName", "And")
                //     ),
                //     new XElement("Luggage",
                //         new XElement("Id", "CA937200305252"),
                //         new XElement("Identification", "1"),
                //         new XElement("Category", "Normal"),
                //         new XElement("Weight", "17.3")
                //     ),
                //     new XElement("Luggage",
                //         new XElement("Id", "CA937200305252"),
                //         new XElement("Identification", "2"),
                //         new XElement("Category", "Large"),
                //         new XElement("Weight", "22.7")
                //     )
                // );

                string xmlBesked = @"
<FlightDetailsInfoResponse>
  <Flight number=""SK937"" Flightdate=""20220225"">
    <Origin>ARLANDA</Origin>
    <Destination>LONDON</Destination>
    <Gate No=""G12"" />
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

                var message = Encoding.UTF8.GetBytes(xmlBesked);
                var properties = channel.CreateBasicProperties();
                properties.Persistent = true;

                channel.BasicPublish(exchange: "",
                    routingKey: queueName,
                    basicProperties: properties,
                    body: message);

                Console.WriteLine(" [x] Sent message to {0}", queueName);


                // Læs beskedens indhold som XML
                XmlDocument xml = new XmlDocument();
                xml.LoadXml(xmlBesked);
                
                var consumer = new EventingBasicConsumer(channel);
                consumer.Received += (model, ea) =>
                {
                    var body = ea.Body.ToArray();
                    var receivedMessage = Encoding.UTF8.GetString(body);

                    XmlDocument xml = new XmlDocument();
                    xml.LoadXml(receivedMessage);

                    int sekvens = 1;
                    int position = 0;
                    // Udfør XPath-forespørgsel
                    XmlNode itemNode = xml.SelectSingleNode("/FlightDetailsInfoResponse/Passenger");
                    if (itemNode != null)
                    {
                        XmlNode reservationNumberNode = itemNode.SelectSingleNode("ReservationNumber");
                        XmlNode firstNameNode = itemNode.SelectSingleNode("FirstName");
                        XmlNode lastNameNode = itemNode.SelectSingleNode("LastName");
                        XmlElement sekvensIdNode = xml.CreateElement("sekvens");
                        XmlElement positionIdNode = xml.CreateElement("position");
                        sekvensIdNode.InnerText = sekvens.ToString();
                        positionIdNode.InnerText = position.ToString();
                        itemNode.AppendChild(sekvensIdNode);
                        itemNode.AppendChild(positionIdNode);
                        var passengerMessage = Encoding.UTF8.GetBytes(itemNode.OuterXml);
                        var passengerProperties = channel.CreateBasicProperties();
                        passengerProperties.Persistent = true;
                        
                        Console.WriteLine($"Sekvens: {sekvens}, position: {position}");
                        Console.WriteLine($"Reservation Number: {reservationNumberNode?.InnerText}");
                        Console.WriteLine($"First Name: {firstNameNode?.InnerText}");
                        Console.WriteLine($"Last Name: {lastNameNode?.InnerText}");
                        Console.WriteLine("-----------------------");
                        
                        channel.BasicPublish(exchange: "", routingKey: "PassengerQueue", basicProperties: passengerProperties, body: passengerMessage);
                        Console.WriteLine($"Sent passenger with Sequence ID: {sekvens}");
                    }
                    XmlNodeList itemNodeList = xml.SelectNodes("/FlightDetailsInfoResponse/Luggage");
                    if (itemNodeList != null)
                    {
                        foreach (XmlNode luggage in itemNodeList)
                        {
                            XmlNode idNode = luggage.SelectSingleNode("Id");
                            XmlNode identificationNode = luggage.SelectSingleNode("Identification");
                            XmlNode categoryNode = luggage.SelectSingleNode("Category");
                            XmlNode weightNode = luggage.SelectSingleNode("Weight");
                            
                            position++;
                            XmlElement sekvensIdNode = xml.CreateElement("sekvens");
                            sekvensIdNode.InnerText = sekvens.ToString();
                            XmlElement positionIdNode = xml.CreateElement("position");
                            positionIdNode.InnerText = position.ToString();
                            
                            luggage.AppendChild(sekvensIdNode);
                            luggage.AppendChild(positionIdNode);
                            
                            var luggageMessage = Encoding.UTF8.GetBytes(luggage.OuterXml);
                            var luggageProperties = channel.CreateBasicProperties();
                            luggageProperties.Persistent = true;
                            
                            Console.WriteLine($"Sekvens: {sekvens}, Position: {position}");
                            Console.WriteLine($"Id: {idNode?.InnerText}");
                            Console.WriteLine($"Identification: {identificationNode?.InnerText}");
                            Console.WriteLine($"Category: {categoryNode?.InnerText}");
                            Console.WriteLine($"Weight: {weightNode?.InnerText}");
                            Console.WriteLine("-----------------------");
                            
                            channel.BasicPublish(exchange: "", routingKey: "LuggageQueue", basicProperties: luggageProperties, body: luggageMessage);
                            Console.WriteLine($"Sent Luggage with Sequence ID: {sekvens}, Position ID: {position}");
                        }
                    }
                };
                
                //Husk aggregator besked
                string aggregatedMessage = xml.OuterXml;

                var aggregatedMessageBytes = Encoding.UTF8.GetBytes(aggregatedMessage);

                channel.BasicPublish(exchange: "",
                    routingKey: "MiniProjektQueue",
                    basicProperties: properties,
                    body: aggregatedMessageBytes);

                Console.WriteLine("Sent aggregated message to MiniProjektQueue.");

                // Extract Passenger information
                // if (passengerNode != null)
                // {
                //     // Convert to byte array
                //     var passengerMessage = Encoding.UTF8.GetBytes(passengerNode.OuterXml);
                //     var passengerProperties = channel.CreateBasicProperties();
                //     passengerProperties.Persistent = true;
                //
                //     // Publish to passenger queue
                //     channel.BasicPublish(exchange: "",
                //         routingKey: passengerQ,
                //         basicProperties: passengerProperties,
                //         body: passengerMessage);
                // }

                // foreach (XmlNode luggageNode in luggageNodes)
                // {
                //     // Convert to byte array
                //     var luggageMessage = Encoding.UTF8.GetBytes(luggageNode.OuterXml);
                //     var luggageProperties = channel.CreateBasicProperties();
                //     luggageProperties.Persistent = true;
                //
                //     // Publish to luggage queue
                //     channel.BasicPublish(exchange: "",
                //         routingKey: luggageQ,
                //         basicProperties: luggageProperties,
                //         body: luggageMessage);
                // }
                
                
                
                // Start consumer
                channel.BasicConsume(queue: queueName,
                    autoAck: true,
                    consumer: consumer);
                //Luggage og passenger q consumer
                channel.BasicConsume(queue: passengerQ,
                    autoAck: true,
                    consumer: consumer);
                channel.BasicConsume(queue: luggageQ,
                    autoAck: true,
                    consumer: consumer);

                Console.WriteLine("Lytter efter beskeder. Tryk på [Enter] for at afslutte.");
                Console.ReadLine();


                // Læser XML-filen
                XElement checkInFile = XElement.Load(@"FlightInfo.xml");
                Console.WriteLine(checkInFile);

                // Sender beskeden til køen med "AirlineCompany" som routing key
                
                string airlineCompany = "SAS";
                
                channel.BasicPublish(exchange: "",
                    routingKey: queueName,
                    basicProperties: properties,
                    body: message);

                Console.WriteLine(" [x] Sent '{0}' to {1}", airlineCompany, queueName);
                // Indlæser og sender den første XML-fil
                //SendMessage(channel, @"AirportInforGateNoSAS.xml", "SAS", queueName);

                // Indlæser og sender den anden XML-fil
                //SendMessage(channel, @"AirportInforGateNoKLM.xml", "KLM", queueName);

                // Indlæser og sender den tredje XML-fil
                //SendMessage(channel, @"AirportInforGateNoSW.xml", "SW", queueName);
                
                
                
                
            }

                // Hjælpefunktion til at sende beskeder til køen
            static void SendMessage(IModel channel, string xmlFilePath, string airlineCompany, string queueName)
            {
                XElement booksFromFile = XElement.Load(xmlFilePath);
                Console.WriteLine(booksFromFile);

                var messageBody = Encoding.UTF8.GetBytes(booksFromFile.ToString());
                var properties = channel.CreateBasicProperties();
                properties.Persistent = true;

                // Sender beskeden til køen
                channel.BasicPublish(exchange: "",
                    routingKey: queueName,
                    basicProperties: properties,
                    body: messageBody);

                Console.WriteLine(" [x] Sent '{0}' to {1}", airlineCompany, queueName);
            }

        }
    }
}
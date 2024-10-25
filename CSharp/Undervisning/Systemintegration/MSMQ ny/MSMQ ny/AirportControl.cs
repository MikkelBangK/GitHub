using System.Text;
using System.Xml.Linq;
using System.Xml.Serialization;
using RabbitMQ.Client;
using RabbitMQ.Client.Events;

namespace MSMQ_ny;

public class AirportControl
{
    public void AirportControlMain()
    {
        var factory = new ConnectionFactory() { HostName = "localhost" };
        
        using (var connection = factory.CreateConnection())
        using (var channel = connection.CreateModel())
        {
            // Definer exchange
            channel.ExchangeDeclare(exchange: "flight_info", type: ExchangeType.Direct);

            // Opret køer for SAS og SWA
            var sasQueue = channel.QueueDeclare(queue: "SAS_queue", durable: false, exclusive: false, autoDelete: false, arguments: null).QueueName;
            var swaQueue = channel.QueueDeclare(queue: "SWA_queue", durable: false, exclusive: false, autoDelete: false, arguments: null).QueueName;

            // Bind køer til exchange med routing keys
            channel.QueueBind(queue: sasQueue, exchange: "flight_info", routingKey: "SAS");
            channel.QueueBind(queue: swaQueue, exchange: "flight_info", routingKey: "SWA");

            Console.WriteLine(" [*] Waiting for messages. To exit press CTRL+C");

            // Opret en fælles consumer til begge køer
            var consumer = new EventingBasicConsumer(channel);

            consumer.Received += (model, ea) =>
            {
                var body = ea.Body.ToArray();
                var xmlContent = Encoding.UTF8.GetString(body);

                // Parse XML-indholdet
                XDocument doc = XDocument.Parse(xmlContent);

                // Udtræk nødvendig information
                var flight = doc.Root.Element("Body").Element("Flight");

                string airline = flight.Element("Airline").Value;
                string flightNo = flight.Element("FlightNo").Value;
                string destination = flight.Element("Destination").Value;
                string scheduledTime = flight.Element("ScheduledTime").Value;
                string checkIn = flight.Element("CheckIn").Value;
                string flightType = flight.Element("FlightType").Value;

                Console.WriteLine("=======================================");
                Console.WriteLine($" [x] Received flight information:");
                Console.WriteLine($"     Airline: {airline}");
                Console.WriteLine($"     Flight Number: {flightNo}");
                Console.WriteLine($"     Destination: {destination}");
                Console.WriteLine($"     Scheduled Time: {scheduledTime}");
                Console.WriteLine($"     Check-In Status: {checkIn}");
                Console.WriteLine($"     Flight Type: {flightType}");
                Console.WriteLine("=======================================\n");
            };

            // Start consuming fra begge køer
            channel.BasicConsume(queue: sasQueue, autoAck: true, consumer: consumer);
            channel.BasicConsume(queue: swaQueue, autoAck: true, consumer: consumer);

            // Hold konsollen kørende
            Console.ReadLine();
        }
    }
    }
    
using System.Xml.Linq;
using System.Xml.Serialization;

namespace MSMQ_ny;
using RabbitMQ.Client;
using System;
using System.Text;


public class Airline
{
    public void start()
    {
        // Opret forbindelse til RabbitMQ
        var factory = new ConnectionFactory() { HostName = "localhost" };
        
        using (var connection = factory.CreateConnection())
        using (var channel = connection.CreateModel())
        {
            // Definer en exchange
            channel.ExchangeDeclare(exchange: "flight_info", type: ExchangeType.Direct);

            // Liste over XML-filer
            string[] xmlFiles = { "SAS.xml", "SWA.xml" };

            foreach (var xmlFile in xmlFiles)
            {
                // Læs XML-filen
                string xmlContent = File.ReadAllText(xmlFile);

                // Parse XML-indholdet for at få routingKey (Airline navn)
                XDocument doc = XDocument.Parse(xmlContent);
                string airline = doc.Root.Element("Body").Element("Flight").Element("Airline").Value;

                // Konverter XML-indholdet til byte array
                var body = Encoding.UTF8.GetBytes(xmlContent);

                // Send beskeden til exchange med routingKey = airline
                channel.BasicPublish(
                    exchange: "flight_info",
                    routingKey: airline,
                    basicProperties: null,
                    body: body
                );

                Console.WriteLine($" [x] Sent flight info message for {airline}");
            }
        }

        Console.WriteLine(" Press [enter] to exit.");
        Console.ReadLine();
    }
    }

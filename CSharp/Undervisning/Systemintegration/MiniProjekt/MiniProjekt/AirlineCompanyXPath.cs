using System;
using System.IO;
using System.Text;
using System.Threading.Tasks;
using System.Xml;
using RabbitMQ.Client;
using RabbitMQ.Client.Events;

class AirlineCompanyXPath
{
    private readonly IModel _channel;
    private readonly string _queueName;

    public AirlineCompanyXPath(IModel channel, string queueName)
    {
        _channel = channel;
        _queueName = queueName;

        var consumer = new EventingBasicConsumer(_channel);
        consumer.Received += OnMessageReceived;
        _channel.BasicConsume(queue: _queueName, autoAck: true, consumer: consumer);
    }

    private void OnMessageReceived(object model, BasicDeliverEventArgs ea)
    {
        var body = ea.Body.ToArray();
        var message = Encoding.UTF8.GetString(body);

        // Læs beskedens indhold som XML
        XmlDocument xml = new XmlDocument();
        xml.LoadXml(message);

        // Udfør XPath-forespørgsel
        XmlNode itemNode = xml.SelectSingleNode("/AirportInfoGate/airline/Flight");
        if (itemNode != null)
        {
            XmlNode value = itemNode.SelectSingleNode("Gate");
            if (value != null)
            {
                string valueString = value.Attributes["No"].Value;
                Console.WriteLine("Længde: " + valueString.Length);
                if (!string.IsNullOrEmpty(valueString))
                {
                    Console.WriteLine("GateNo: " + valueString);
                }
            }
        }
        Console.WriteLine("Besked behandlet.");
    }
}

class Program
{
    static async Task Main(string[] args)
    {
        var factory = new ConnectionFactory() { HostName = "localhost" }; // Juster til din RabbitMQ-server
        using (var connection = factory.CreateConnection())
        using (var channel = connection.CreateModel())
        {
            // Opret køen, hvis den ikke allerede findes
            string queueName = "AirportInfoGateNo";
            channel.QueueDeclare(queue: queueName,
                                 durable: false,
                                 exclusive: false,
                                 autoDelete: false,
                                 arguments: null);

            // Start forbruger, som lytter til beskeder fra køen
            var airlineCompanyXPath = new AirlineCompanyXPath(channel, queueName);

            Console.WriteLine("Tryk på [Enter] for at afslutte.");
            Console.ReadLine(); // Holder programmet kørende
        }
    }
}
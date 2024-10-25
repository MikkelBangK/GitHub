using RabbitMQ.Client;
using System;
using System.Diagnostics;
using System.Text;

class Program
{
    static void Main(string[] args)
    {
        var factory = new ConnectionFactory() { HostName = "localhost" };
        using (var connection = factory.CreateConnection())
        using (var channel = connection.CreateModel())
        {
            //ttl er i millisekunder, så 10000 er 10 sekunder
            var ttl = new Dictionary<string, object>
            {
                { "x-message-ttl", 10000 }
            };

            channel.QueueDeclare(queue: "my_ttl_queue",
                durable: false,
                exclusive: false,
                autoDelete: false,
                arguments: ttl);

            string message = "Test!";
            var body = Encoding.UTF8.GetBytes(message);

            channel.BasicPublish(exchange: "",
                routingKey: "my_ttl_queue",
                basicProperties: null,
                body: body);

            Console.WriteLine(" [x] Sent '{0}'", message);
        }

        Console.WriteLine(" Press [enter] to exit.");
        Console.ReadLine();
    }
}
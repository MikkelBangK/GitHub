namespace MSMQ;
using System;
using System.Text;
using RabbitMQ.Client;

    class Publisher
    {
        static void Main(string[] args)
        {
            // Connection factory
            var factory = new ConnectionFactory() { HostName = "localhost" };
        
            // Establish a connection to RabbitMQ server
            using (var connection = factory.CreateConnection())
            using (var channel = connection.CreateModel())
            {
                // Declare a queue named "hello"
                channel.QueueDeclare(queue: "hello",
                    durable: false,
                    exclusive: false,
                    autoDelete: false,
                    arguments: null);

                string message = "Hello World!";
                var body = Encoding.UTF8.GetBytes(message);

                // Publish the message to the "hello" queue
                channel.BasicPublish(exchange: "",
                    routingKey: "hello",
                    basicProperties: null,
                    body: body);
            
                Console.WriteLine($" [x] Sent {message}");
            }
        
            Console.WriteLine(" Press [enter] to exit.");
            Console.ReadLine();
        }
    }

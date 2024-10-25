namespace MSMQ;
using RabbitMQ.Client;
using RabbitMQ.Client.Events;
using System;
using System.Text;

class Consumer
{
    static void Main(string[] args)
    {
        // Connection factory
        var factory = new ConnectionFactory() { HostName = "localhost" };
        
        // Establish a connection to RabbitMQ server
        using (var connection = factory.CreateConnection())
        using (var channel = connection.CreateModel())
        {
            // Declare the same queue that the publisher sent the message to
            channel.QueueDeclare(queue: "hello",
                durable: false,
                exclusive: false,
                autoDelete: false,
                arguments: null);

            Console.WriteLine(" [*] Waiting for messages.");

            // Create a consumer and link it to the queue
            var consumer = new EventingBasicConsumer(channel);
            consumer.Received += (model, ea) =>
            {
                var body = ea.Body.ToArray();
                var message = Encoding.UTF8.GetString(body);
                Console.WriteLine($" [x] Received {message}");
            };
            
            channel.BasicConsume(queue: "hello",
                autoAck: true,
                consumer: consumer);

            Console.WriteLine(" Press [enter] to exit.");
            Console.ReadLine();
        }
    }
}
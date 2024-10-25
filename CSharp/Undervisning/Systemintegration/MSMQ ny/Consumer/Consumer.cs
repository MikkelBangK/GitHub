namespace Consumer;
using System.Text;
using RabbitMQ.Client;
using RabbitMQ.Client.Events;

class Consumer
{
    static void Main(string[] args)
    {
        // Create a ConnectionFactory and set the host name
        var factory = new ConnectionFactory() { HostName = "localhost" };
        
        // Establish connection and create a channel
        using (var connection = factory.CreateConnection())
        using (var channel = connection.CreateModel())
        {
            // Declare the same queue as the publisher
            string queueName = "hello_queue";
            channel.QueueDeclare(queue: queueName,
                durable: false,
                exclusive: false,
                autoDelete: false,
                arguments: null);

            Console.WriteLine("[Consumer] Waiting for messages...");

            // Create a consumer to receive messages
            var consumer = new EventingBasicConsumer(channel);
            consumer.Received += (model, ea) =>
            {
                var body = ea.Body.ToArray();
                var message = Encoding.UTF8.GetString(body);
                Console.WriteLine($"[Consumer] Received: {message}");
            };

            // Start consuming messages
            channel.BasicConsume(queue: queueName,
                autoAck: true,
                consumer: consumer);

            Console.WriteLine("[Consumer] Press [enter] to exit.");
            Console.ReadLine();
        }
    }
}
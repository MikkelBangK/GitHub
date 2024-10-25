namespace Publisher;
using System.Text;
using RabbitMQ.Client;

class Publisher
{
    static void Main(string[] args)
    {
        // Create a ConnectionFactory and set the host name
        var factory = new ConnectionFactory() { HostName = "localhost" };
        
        // Establish connection and create a channel
        using (var connection = factory.CreateConnection())
        using (var channel = connection.CreateModel())
        {
            // Declare a queue named "hello_queue"
            string queueName = "hello_queue";
            channel.QueueDeclare(queue: queueName,
                durable: false,
                exclusive: false,
                autoDelete: false,
                arguments: null);

            // Create the message
            string message = "Hello World!";
            var body = Encoding.UTF8.GetBytes(message);

            // Publish the message to the queue
            channel.BasicPublish(exchange: "",
                routingKey: queueName,
                basicProperties: null,
                body: body);

            Console.WriteLine($"[Publisher] Sent: {message}");
        }

        Console.WriteLine("[Publisher] Press [enter] to exit.");
        Console.ReadLine();
    }
}
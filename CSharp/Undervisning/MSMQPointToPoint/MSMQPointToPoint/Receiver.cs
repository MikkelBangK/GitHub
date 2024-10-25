namespace MSMQPointToPoint;
using RabbitMQ.Client;
using RabbitMQ.Client.Events;
using System;
using System.Text;

public class Receiver
{
    public static void Lyt()
    {
        // Opret forbindelse til RabbitMQ-serveren
        var factory = new ConnectionFactory() { HostName = "localhost" };
        using var connection = factory.CreateConnection();
        using var channel = connection.CreateModel();

        // Definer køen
        channel.QueueDeclare(queue: "ETAQ",
            durable: false,
            exclusive: false,
            autoDelete: false,
            arguments: null);

        // Opret en event handler for at modtage meddelelser
        var consumer = new EventingBasicConsumer(channel);
        consumer.Received += (model, ea) =>
        {
            var body = ea.Body.ToArray();
            var message = Encoding.UTF8.GetString(body);
            Console.WriteLine("Message received: \n");
            Console.WriteLine($"[x] Received {message}");
        };

        // Start med at modtage meddelelser
        channel.BasicConsume(queue: "ETAQ",
            autoAck: true,
            consumer: consumer);

        Console.WriteLine(" Press [enter] to exit.");
        Console.ReadLine();
    }
}

namespace MSMQPointToPoint;

using RabbitMQ.Client;
using RabbitMQ.Client.Events;
using System;
using System.Text;


class Sender
{
    public static void Send()
    {
        var factory = new ConnectionFactory() { HostName = "localhost" };
        using var connection = factory.CreateConnection();
        using var channel = connection.CreateModel();

        channel.QueueDeclare(queue: "ETAQ",
            durable: false,
            exclusive: false,
            autoDelete: false,
            arguments: null);

        string xmlMessage = "<SAS>\n" +
                            "    <FlightNumber>100300</FlightNumber>\n" +
                            "    <AnkomstTider>\n" +
                            "        <dato>14-12-2024</dato>\n" +
                            "        <tidspunkt>14:30</tidspunkt>\n" +
                            "        <destination>København</destination>\n" +
                            "    </AnkomstTider>\n" +
                            "</SAS>";
        var body = Encoding.UTF8.GetBytes(xmlMessage);

        channel.BasicPublish(exchange: "",
            routingKey: "ETAQ",
            basicProperties: null,
            body: body);

        //Console.WriteLine($"[x] Sent {xmlMessage}");
    }
}
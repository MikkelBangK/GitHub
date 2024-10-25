using RabbitMQ.Client;
using RabbitMQ.Client.Events;
using System;
using System.Text;

public class Requestor
{
    private readonly IConnection connection;
    private readonly IModel requestChannel;
    private readonly IModel replyChannel;
    private readonly string requestQueueName;
    private readonly string replyQueueName;
    private readonly string airline;

    public Requestor(string requestQueueName, string replyQueueName, string airline, ConnectionFactory factory)
    {
        this.requestQueueName = requestQueueName;
        this.replyQueueName = replyQueueName;
        this.airline = airline;

        // RabbitMQ setup
        connection = factory.CreateConnection();
        requestChannel = connection.CreateModel();
        replyChannel = connection.CreateModel();

        // Erklære svar q
        replyChannel.QueueDeclare(queue: replyQueueName, durable: false, exclusive: false, autoDelete: false, arguments: null);
    }

    public void Send()
    {
        var body = Encoding.UTF8.GetBytes(airline);
        var props = requestChannel.CreateBasicProperties();
        props.ReplyTo = replyQueueName;
        props.CorrelationId = Guid.NewGuid().ToString();
        props.Type = airline.Substring(0, 2);

        requestChannel.BasicPublish(exchange: "", routingKey: requestQueueName, basicProperties: props, body: body);

        Console.WriteLine($"Sent request: {airline}");
        Console.WriteLine($"\tCorrelation ID: {props.CorrelationId}");
        Console.WriteLine($"\tReply to Queue: {props.ReplyTo}");
    }

    public void ReceiveSync()
    {
        var consumer = new EventingBasicConsumer(replyChannel);
        consumer.Received += (model, ea) =>
        {
            var body = ea.Body.ToArray();
            var message = Encoding.UTF8.GetString(body);
            var correlationId = ea.BasicProperties.CorrelationId;

            Console.WriteLine("Received reply");
            Console.WriteLine($"\tTime:       {DateTime.Now:HH:mm:ss.ffffff}");
            Console.WriteLine($"\tCorrel. ID: {correlationId}");
            Console.WriteLine($"\tContents:   {message}");
        };

        // Æder beskeder fra svar q 
        replyChannel.BasicConsume(queue: replyQueueName, autoAck: true, consumer: consumer);
    }

    public void Close()
    {
        replyChannel.Close();
        requestChannel.Close();
        connection.Close();
    }
}
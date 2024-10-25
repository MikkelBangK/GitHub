using RabbitMQ.Client;
using RequestReply;

static class Program
{
    public static void Main(string[] args)
    {
        var factory = new ConnectionFactory() { HostName = "localhost" };

        using var connection = factory.CreateConnection();
        using var request = connection.CreateModel();
        using var replySAS = connection.CreateModel();
        using var replySW = connection.CreateModel();
        using var replyKLM = connection.CreateModel();
        using var invalid = connection.CreateModel();

        request.QueueDeclare(queue: "RequestQ", durable: false, exclusive: false, autoDelete: false, arguments: null);
        replySAS.QueueDeclare(queue: "ReplyQSAS", durable: false, exclusive: false, autoDelete: false, arguments: null);
        replySW.QueueDeclare(queue: "ReplyQSW", durable: false, exclusive: false, autoDelete: false, arguments: null);
        replyKLM.QueueDeclare(queue: "ReplyQKLM", durable: false, exclusive: false, autoDelete: false, arguments: null);
        invalid.QueueDeclare(queue: "InvalidQ", durable: false, exclusive: false, autoDelete: false, arguments: null);

        Replier AIC = new Replier("RequestQ", "InvalidQ");
        Requestor SAS = new Requestor("RequestQ", "ReplyQSAS", "SAS123", factory);
        Requestor SW = new Requestor("RequestQ", "ReplyQSW", "SW456", factory);
        Requestor KLM = new Requestor("RequestQ", "ReplyQKLM", "KLM789", factory);

        SAS.Send();
        //SAS.ReceiveSync();

        KLM.Send();
        //KLM.ReceiveSync();

        SW.Send();
        //SW.ReceiveSync();

        Console.WriteLine("Press [enter] to exit.");
        Console.ReadLine();

        SAS.Close();
        SW.Close();
        KLM.Close();
        AIC.Close();
    }
}
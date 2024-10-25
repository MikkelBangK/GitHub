using RabbitMQ.Client;
using System.Text;
using RabbitMQ.Client.Events;

public class Program
{
    public static void Main(string[] args)
    {
        /*
        SendMessageToQueue();
        
        ReceiveMessageFromQueue();
        */
        
        string flightInfoMessage = CreateFlightInfoMessage();
        
        
        SendMessageToAirlines(flightInfoMessage, "RYR");
        
        RouteMessage("RYR", flightInfoMessage);
        
        Console.WriteLine("Press any key to exit...");
        Console.ReadLine();
    }
    
    public static void SendMessageToQueue()
    {
        var factory = new ConnectionFactory() { HostName = "localhost" };
        using (var connection = factory.CreateConnection())
        using (var channel = connection.CreateModel())
        {
            channel.QueueDeclare(
                queue: "TestQueue",
                durable: false,
                exclusive: false,
                autoDelete: false,
                arguments: null);

            string msg = "Hello";
            var body = Encoding.UTF8.GetBytes(msg);
            
            channel.BasicPublish(
                exchange: "",
                routingKey: "TestQueue",
                basicProperties: null,
                body: body);
            Console.WriteLine(" [x] Sent {0}", msg);
        }
    }

    public static void ReceiveMessageFromQueue()
    {
        var factory = new ConnectionFactory() { HostName = "localhost" };
        using (var connection = factory.CreateConnection())
        using (var channel = connection.CreateModel())
        {
            channel.QueueDeclare(
                queue: "TestQueue",
                durable: false,
                exclusive: false,
                autoDelete: false,
                arguments: null);

            var consumer = new EventingBasicConsumer(channel);
            consumer.Received += (model, ea) =>
            {
                var body = ea.Body.ToArray();
                var message = Encoding.UTF8.GetString(body);
                Console.WriteLine(" [x] Recieved {0}", message);
            };
            channel.BasicConsume(
                queue: "TestQueue",
                autoAck: true,
                consumer: consumer);
            
            Console.WriteLine(" Press [enter] to exit...");
            Console.ReadLine();
        }
    }

    public static string CreateFlightInfoMessage()
    {
        var message = new
        {
            Header = new
            {
                MessageType = "FlightInfo",
                Timestamp = DateTime.UtcNow.ToString("o")
            },
            Body = new
            {
                Airline = "Ryanair",
                FlightNo = "RYR134",
                ScheduledTime = DateTime.UtcNow.AddHours(2).ToString("o"),
                Destination = "AMS",
                CheckIn = "B12"
            }
        };
        
        string jsonMessage = System.Text.Json.JsonSerializer.Serialize(message);
        Console.WriteLine(jsonMessage);
        return jsonMessage;
    }
    
    public static void SendMessageToAirlines(string message, string routingKey)
    {
        var factory = new ConnectionFactory() { HostName = "localhost" };
        using (var connection = factory.CreateConnection())
        using (var channel = connection.CreateModel())
        {
            channel.ExchangeDeclare(exchange: "AirportExchange", type: ExchangeType.Direct);

            channel.QueueDeclare(queue: "SASQueue", durable: false, exclusive: false, autoDelete: false, arguments: null);
            channel.QueueDeclare(queue: "SWQueue", durable: false, exclusive: false, autoDelete: false, arguments: null);

            channel.QueueBind(queue: "SASQueue", exchange: "AirportExchange", routingKey: "SAS");
            channel.QueueBind(queue: "SWQueue", exchange: "AirportExchange", routingKey: "SW");

            var body = Encoding.UTF8.GetBytes(message);
            channel.BasicPublish(exchange: "AirportExchange", routingKey: routingKey, basicProperties: null, body: body);

            Console.WriteLine(" [x] Sent message to {0} queue", routingKey);
        }
    }

    public static void RouteMessage(string airline, string flightInfoJson)
    {
        var factory = new ConnectionFactory() { HostName = "localhost" };
        using (var connection = factory.CreateConnection())
        using (var channel = connection.CreateModel())
        {
            channel.ExchangeDeclare(exchange: "AirportExchange", type: ExchangeType.Direct);
            
            // Determine routing key based on airline
            string routingKey = airline switch
            {
                "SAS" => "SAS",
                "RYR" => "RYR",
                "KLM" => "KLM",
                _ => throw new ArgumentException("Unknown airline", nameof(airline))
            };
            
            var body = Encoding.UTF8.GetBytes(flightInfoJson);
            channel.BasicPublish(
                exchange: "AirportExchange",
                routingKey: routingKey,
                basicProperties: null,
                body: body);
            
            Console.WriteLine(" [x] Routed message to {0} queue", routingKey);
        }
    }
}
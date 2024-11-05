using System.Text;
using RabbitMQ.Client;

namespace Lektion16Opgave2;

public class EventDriven
{
    public static void Main(string[] args)
    {
        var factory = new ConnectionFactory() { HostName = "localhost" };
        using (var connection = factory.CreateConnection())
        using (var channel = connection.CreateModel())
        {
            // Enable Publisher Confirms
            channel.ConfirmSelect();

            string queueName = "PassengerQueue";
            string KLMQ = "KLMQueue";
            string SASQ = "SasQueue";
            string SWQ = "SWQueue";


            // Declare queues
            channel.QueueDeclare(queue: queueName, durable: false, exclusive: false, autoDelete: false, arguments: null);
            channel.QueueDeclare(queue: KLMQ, durable: false, exclusive: false, autoDelete: false, arguments: null);
            channel.QueueDeclare(queue: SASQ, durable: false, exclusive: false, autoDelete: false, arguments: null);
            channel.QueueDeclare(queue: SWQ, durable: false, exclusive: false, autoDelete: false, arguments: null);

            string xmlBesked = @"
                <FlightDetailsInfoResponse>
                    <Passenger>
                        <TicketNumber>CA937200305251</TicketNumber>
                        <Name>Slikolaj</Name>
                        <PassportNumber>1234567</PassportNumber>
                        <FlightNumber>SK937</FlightNumber>
                    </Passenger>
                </FlightDetailsInfoResponse>";

            // Encode message and set properties
            var message = Encoding.UTF8.GetBytes(xmlBesked);
            var properties = channel.CreateBasicProperties();
            properties.Persistent = true;

            // Publish to main queue
            try
            {
                channel.BasicPublish(exchange: "", routingKey: queueName, basicProperties: properties, body: message);
                Console.WriteLine(" [x] Sent {0}", xmlBesked);
            }
            catch (Exception e)
            {
                Console.WriteLine(" [x] Error: {0}", e.Message);
            }
        }
    }
}

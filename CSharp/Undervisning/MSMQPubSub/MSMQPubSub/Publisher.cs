namespace MSMQPubSub;

public class Publisher
{
    private readonly MessageBroker _broker;

    public Publisher(MessageBroker broker)
    {
        _broker = broker;
    }

    public void PublishXmlMessage()
    {
        string xmlMessage = @"
<SAS>
    <FlightNumber>100300</FlightNumber>
    <AnkomstTider>
        <dato>14-12-2024</dato>
        <tidspunkt>14:30</tidspunkt>
        <destination>København</destination>
    </AnkomstTider>
</SAS>";

        Console.WriteLine($"Publisher sends XML message:\n{xmlMessage}");
        _broker.Publish(xmlMessage);
    }
}
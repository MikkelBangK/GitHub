namespace MSMQPubSub;

public class MessageBroker
{
    private readonly List<Action<string>> _subscribers = new List<Action<string>>();

    public void Subscribe(Action<string> handler)
    {
        _subscribers.Add(handler);
    }

    public void Unsubscribe(Action<string> handler)
    {
        _subscribers.Remove(handler);
    }

    public void Publish(string message)
    {
        foreach (var handler in _subscribers)
        {
            handler(message);
        }
    }

    public void PublishXML()
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
    }
    }

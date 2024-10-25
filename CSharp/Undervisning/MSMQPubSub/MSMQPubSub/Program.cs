using MSMQPubSub;

namespace MSMQPointToPoint;

public class Program
{

    static void Main(string[] args)
    {
        var broker = new MessageBroker();
        
        var publisher = new Publisher(broker);


        var sasSubscriber = new Subscriber("SAS");
        var swSubscriber = new Subscriber("SW");
        var klmSubscriber = new Subscriber("KLM");
        
        broker.Subscribe(sasSubscriber.ReceiveMessage);
        broker.Subscribe(swSubscriber.ReceiveMessage);
        broker.Subscribe(klmSubscriber.ReceiveMessage);
        
        publisher.PublishXmlMessage();
    }
}
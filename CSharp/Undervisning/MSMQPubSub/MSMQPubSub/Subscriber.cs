namespace MSMQPubSub;

public class Subscriber
{
    private readonly string _name;

    public Subscriber(string name)
    {
        _name = name;
    }

    public void ReceiveMessage(string message)
    {
        Console.WriteLine($"{_name} received: \n {message}" + "\n");
    }
}
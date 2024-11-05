namespace MSMQPointToPoint;

public class Program
{

    static void Main(string[] args)
    {
        Sender.Send();
        Receiver.Lyt();
    }
}
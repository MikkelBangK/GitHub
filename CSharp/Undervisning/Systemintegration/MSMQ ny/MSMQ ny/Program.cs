namespace MSMQ_ny;
using System.Text;
using RabbitMQ.Client;
using System.Xml.Serialization;


public class Program
{
    public class Message
    {
        public Header Header { get; set; }
        public Body Body { get; set; }
    }
    public class Header
    {
        public string MessageID { get; set; }
        public DateTime Timestamp { get; set; }
        public string Sender { get; set; }
        public string Receiver { get; set; }
    }

    public class Body
    {
        public Flight Flight { get; set; }
    }
    public class Flight
    {
        public string Airline { get; set; }
        public DateTime ScheduledTime { get; set; }
        public string FlightNo { get; set; }
        public string Destination { get; set; }
        public string CheckIn { get; set; }
    }
    static void Main(string[] args)
    {
        // Filnavne for XML-filerne
        string[] fileNames = { "SAS.xml", "SWA.xml" };

        // Liste til at holde alle meddelelser
        List<Message> allMessages = new List<Message>();

        // Indlæs og deserialiser hver fil
        foreach (var fileName in fileNames)
        {
            XmlSerializer serializer = new XmlSerializer(typeof(Message));
            using (FileStream fileStream = new FileStream(fileName, FileMode.Open))
            {
                Message message = (Message)serializer.Deserialize(fileStream);
                allMessages.Add(message);
            }
        }
    }
    }
    

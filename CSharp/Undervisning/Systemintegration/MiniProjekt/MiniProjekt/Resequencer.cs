using System.Xml;

namespace MiniProjekt;

public class Resequencer
{
    private List<XmlNode> messageBuffer = new List<XmlNode>();
    private int expectedMessages = 3;
    public void AddMessage(XmlNode messageNode)
    {
        var sekvensIdNode = messageNode.SelectSingleNode("SekvensId");
        var positionIdNode = messageNode.SelectSingleNode("PositionId");
        
        int sekvensId = int.Parse(sekvensIdNode.InnerText);
        int positionId = int.Parse(positionIdNode.InnerText);
        
        messageBuffer.Add(messageNode);

        if (AllMessagedReceived(sekvensId))
        {
            var orderedMessages = messageBuffer
                .Where(m => int.Parse(m.SelectSingleNode("SekvensId").InnerText) == sekvensId)
                .OrderBy(m => int.Parse(m.SelectSingleNode("PositionId").InnerText))
                .ToList();
            foreach (var orderedMessage in orderedMessages)
            {
                Console.WriteLine($"Processed message with Position ID: {orderedMessage.SelectSingleNode("PositionId")?.InnerText}");

            }
        }
        messageBuffer.RemoveAll(m => int.Parse(m.SelectSingleNode("SekvensId").InnerText) == sekvensId);
    }
    public bool AllMessagedReceived(int sekvensId)
    {
        return messageBuffer.Count(m => int.Parse(m.SelectSingleNode("SekvensId").InnerText) == sekvensId) == expectedMessages;
    }
}
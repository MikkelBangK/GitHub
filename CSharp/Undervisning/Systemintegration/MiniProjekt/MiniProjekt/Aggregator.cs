using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml;
using RabbitMQ.Client;

namespace MiniProjekt
{
    public class Aggregator
    {
        private readonly Dictionary<int, List<XmlNode>> _messageGroups = new Dictionary<int, List<XmlNode>>();
        private readonly int _expectedMessagesPerGroup = 3;
        private readonly IModel _channel;
        private readonly string _queueName;

        public Aggregator(IModel channel, string queueName)
        {
            _channel = channel;
            _queueName = queueName;
        }

        public void AddMessage(XmlNode message)
        {
            int sekvensId = int.Parse(message.SelectSingleNode("sekvens").InnerText);
            if (!_messageGroups.ContainsKey(sekvensId))
            {
                _messageGroups[sekvensId] = new List<XmlNode>();
            }

            _messageGroups[sekvensId].Add(message);

            //Tjekker om vi har modtaget alle forventede beskeder
            if (_messageGroups[sekvensId].Count == _expectedMessagesPerGroup)
            {
                AggregateMessages(sekvensId);
                _messageGroups.Remove(sekvensId);
            }
        }

        private void AggregateMessages(int sekvensId)
        {
            var messages = _messageGroups[sekvensId].OrderBy(m => int.Parse(m.SelectSingleNode("position").InnerText)).ToList();

            Console.WriteLine($"Aggregating messages for Sequence ID: {sekvensId}");

            XmlDocument aggregatedXml = new XmlDocument();
            XmlElement root = aggregatedXml.CreateElement("AggregatedMessages");
            aggregatedXml.AppendChild(root);

            foreach (var message in messages)
            {
                XmlNode importedNode = aggregatedXml.ImportNode(message, true);
                root.AppendChild(importedNode);
                Console.WriteLine($"Message: {message.OuterXml}");
            }

            SendToQueue(aggregatedXml);
        }

        private void SendToQueue(XmlDocument aggregatedMessage)
        {
            var messageBody = Encoding.UTF8.GetBytes(aggregatedMessage.OuterXml);
            var properties = _channel.CreateBasicProperties();
            properties.Persistent = true;

            _channel.BasicPublish(exchange: "",
                                  routingKey: _queueName,
                                  basicProperties: properties,
                                  body: messageBody);

            Console.WriteLine($"Aggregated message sent to queue: {_queueName}");
        }
    }
}

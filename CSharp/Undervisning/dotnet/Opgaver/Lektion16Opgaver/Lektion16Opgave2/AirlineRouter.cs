namespace Lektion16Opgave2;
using System;
using System.Text;
using RabbitMQ.Client;
using RabbitMQ.Client.Events;
public class AirlineRouter
{
        private readonly IModel channel;
        private readonly string inQueueName;
        private readonly string outQueueSAS;
        private readonly string outQueueKLM;
        private readonly string outQueueSW;

        public AirlineRouter(IConnection connection, string inQueueName, string outQueueSAS, string outQueueKLM, string outQueueSW)
        {
            channel = connection.CreateModel();
            this.inQueueName = inQueueName;
            this.outQueueSAS = outQueueSAS;
            this.outQueueKLM = outQueueKLM;
            this.outQueueSW = outQueueSW;

            var consumer = new EventingBasicConsumer(channel);
            consumer.Received += OnMessage;
            channel.BasicConsume(queue: inQueueName, autoAck: true, consumer: consumer);
        }

        private void OnMessage(object model, BasicDeliverEventArgs ea)
        {
            var body = ea.Body.ToArray();
            var message = Encoding.UTF8.GetString(body);
            var label = ea.BasicProperties.Type; // Assume label is set in the Type property

            switch (label)
            {
                case "SAS":
                    SendToQueue(outQueueSAS, message, label);
                    break;
                case "KLM":
                    SendToQueue(outQueueKLM, message, label);
                    break;
                case "SW":
                    SendToQueue(outQueueSW, message, label);
                    break;
            }
        }

        private void SendToQueue(string queueName, string message, string label)
        {
            var properties = channel.CreateBasicProperties();
            properties.Type = label;
            channel.BasicPublish(exchange: "", routingKey: queueName, basicProperties: properties, body: Encoding.UTF8.GetBytes(message));
        }
    }
    
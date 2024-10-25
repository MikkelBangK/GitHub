using RabbitMQ.Client;
using RabbitMQ.Client.Events;
using System;
using System.Text;

namespace RequestReply
{
    public class Replier
    {
        private readonly IConnection connection;
        private readonly IModel requestChannel;
        private readonly IModel invalidChannel;
        private readonly string requestQueueName;
        private readonly string invalidQueueName;

        public Replier(string requestQueueName, string invalidQueueName)
        {
            // RabbitMQ setup
            var factory = new ConnectionFactory() { HostName = "localhost" };
            connection = factory.CreateConnection();
            requestChannel = connection.CreateModel();
            invalidChannel = connection.CreateModel();

            this.requestQueueName = requestQueueName;
            this.invalidQueueName = invalidQueueName;

            // Erklære q's
            requestChannel.QueueDeclare(queue: requestQueueName, durable: false, exclusive: false, autoDelete: false, arguments: null);
            invalidChannel.QueueDeclare(queue: invalidQueueName, durable: false, exclusive: false, autoDelete: false, arguments: null);

            // Consumer til at lytte på q
            var consumer = new EventingBasicConsumer(requestChannel);
            consumer.Received += OnReceiveCompleted;

            // Æder beskeder fra q
            requestChannel.BasicConsume(queue: requestQueueName, autoAck: false, consumer: consumer);

            Console.WriteLine($"Listening for messages on queue: {requestQueueName}");
        }

        private void OnReceiveCompleted(object sender, BasicDeliverEventArgs ea)
        {
            var body = ea.Body.ToArray();
            var message = Encoding.UTF8.GetString(body);
            var props = ea.BasicProperties;
            var replyProps = requestChannel.CreateBasicProperties();
            replyProps.CorrelationId = props.CorrelationId;

            Console.WriteLine("Received request");
            Console.WriteLine("\tTime:       {0}", DateTime.Now.ToString("HH:mm:ss.ffffff"));
            Console.WriteLine("\tMessage ID: {0}", ea.DeliveryTag);
            Console.WriteLine("\tCorrel. ID: {0}", props.CorrelationId);
            Console.WriteLine("\tContents:   {0}", message);

            try
            {
                string contents = "Invalid label";
                string label = props.Type; // Tager label fra type
                switch (label)
                {
                    case "SAS":
                        contents = "13:45:00";
                        break;
                    case "KLM":
                        contents = "14:25:00";
                        break;
                    case "SW":
                        contents = "15:40:00";
                        break;
                }

                // Sender besked tilbage til den originale requester dds
                if (!string.IsNullOrEmpty(props.ReplyTo))
                {
                    var replyBody = Encoding.UTF8.GetBytes(contents);
                    requestChannel.BasicPublish(exchange: "",
                                                routingKey: props.ReplyTo,
                                                basicProperties: replyProps,
                                                body: replyBody);

                    Console.WriteLine("Sent reply");
                    Console.WriteLine("\tTime:       {0}", DateTime.Now.ToString("HH:mm:ss.ffffff"));
                    Console.WriteLine("\tMessage ID: {0}", ea.DeliveryTag);
                    Console.WriteLine("\tCorrel. ID: {0}", replyProps.CorrelationId);
                    Console.WriteLine("\tContents:   {0}", contents);
                }
                else
                {
                    Console.WriteLine("No ReplyTo queue specified. Skipping reply.");
                }

                // Sætter besked til ack
                requestChannel.BasicAck(deliveryTag: ea.DeliveryTag, multiple: false);
            }
            catch (Exception ex)
            {
                Console.WriteLine("Invalid message detected: " + ex.Message);
                Console.WriteLine("\tTime:       {0}", DateTime.Now.ToString("HH:mm:ss.ffffff"));
                Console.WriteLine("\tMessage ID: {0}", ea.DeliveryTag);
                Console.WriteLine("\tCorrel. ID: {0}", props.CorrelationId);

                // Sender besked til invalid q, idk Søren brugte det så behold det I guess
                var invalidProps = invalidChannel.CreateBasicProperties();
                invalidProps.CorrelationId = props.CorrelationId;

                invalidChannel.BasicPublish(exchange: "",
                                            routingKey: invalidQueueName,
                                            basicProperties: invalidProps,
                                            body: body);

                Console.WriteLine("Sent to invalid message queue");
                Console.WriteLine("\tTime:       {0}", DateTime.Now.ToString("HH:mm:ss.ffffff"));
                Console.WriteLine("\tMessage ID: {0}", ea.DeliveryTag);
                Console.WriteLine("\tCorrel. ID: {0}", props.CorrelationId);

                // Sætter invalid besked til ack
                requestChannel.BasicAck(deliveryTag: ea.DeliveryTag, multiple: false);
            }
        }

        public void Close()
        {
            requestChannel.Close();
            invalidChannel.Close();
            connection.Close();
        }
    }
}
using RabbitMQ.Client;
using RabbitMQ.Client.Events;
using System.Text;

namespace MSMQ_ny
{
    public class SimpleRouter
    {
        protected IModel inChannel;
        protected IModel outChannel1;
        protected IModel outChannel2;
        protected string inQueueName;
        protected string outQueueName1;
        protected string outQueueName2;
        protected bool toggle = false;

        public SimpleRouter(IModel inChannel, IModel outChannel1, IModel outChannel2, string inQueueName, string outQueueName1, string outQueueName2)
        {
            this.inChannel = inChannel;
            this.outChannel1 = outChannel1;
            this.outChannel2 = outChannel2;
            this.inQueueName = inQueueName;
            this.outQueueName1 = outQueueName1;
            this.outQueueName2 = outQueueName2;

            var consumer = new EventingBasicConsumer(inChannel);
            consumer.Received += OnMessage;
            inChannel.BasicConsume(queue: inQueueName, autoAck: true, consumer: consumer);
        }

        private void OnMessage(object sender, BasicDeliverEventArgs e)
        {
            var body = e.Body.ToArray();
            var message = Encoding.UTF8.GetString(body);

            Console.WriteLine($" [x] Received {message}");

            // Vælg kø baseret på IsConditionFulfilled
            var targetChannel = IsConditionFulfilled() ? outChannel1 : outChannel2;
            var targetQueueName = IsConditionFulfilled() ? outQueueName1 : outQueueName2;

            // Send besked til den passende udgående kø
            targetChannel.BasicPublish(exchange: "", routingKey: targetQueueName, basicProperties: null, body: body);

            Console.WriteLine($" [x] Sent to {(IsConditionFulfilled() ? "outQueue1" : "outQueue2")}");
        }

        protected bool IsConditionFulfilled()
        {
            toggle = !toggle;
            return toggle;
        }
    }
}
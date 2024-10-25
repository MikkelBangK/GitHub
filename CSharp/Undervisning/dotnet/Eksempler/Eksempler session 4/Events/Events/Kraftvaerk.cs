using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Events
{
    internal class Kraftvaerk
    {

        //public delegate void KraftvaerkEventHandler(object sender, KraftvaerkEventArgs e);
        //public KraftvaerkEventHandler eventHandlers;

        public event EventHandler<KraftvaerkEventArgs> kraftVaerkOverheated;

        private int temperature = 40;
        private int power = 5;
        private int cooldown = 3;

        public int Power { get => power; set => power = value; }

        protected virtual void onOverheated(KraftvaerkEventArgs e)
        {
            kraftVaerkOverheated.Invoke(this, e);
        }

        public void run()
        {
            while (true)
            {
                temperature += Power;
                Thread.Sleep(500);
                if (temperature > 50)
                {
                    onOverheated(new KraftvaerkEventArgs(temperature));
                }
                temperature -= cooldown;

            }
        }
    }
}

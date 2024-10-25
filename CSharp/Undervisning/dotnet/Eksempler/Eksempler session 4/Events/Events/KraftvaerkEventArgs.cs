using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Events
{
    internal class KraftvaerkEventArgs:EventArgs
    {
        public KraftvaerkEventArgs(int temperature)
        {
            Temperature = temperature;
        }

        public int Temperature { get; }
    }
}

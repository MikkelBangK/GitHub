using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Session3Eksempel
{
    internal abstract class Koeretoej
    {
        public Koeretoej(string farve, double vaegt)
        {
            Farve = farve;
            Vaegt = vaegt;
        }

        public Koeretoej(double vaegt) : this("Hvid", vaegt)
        {
        }

        public String Farve { get; set; }
        public double Vaegt { get; set; }

        public abstract int AntalHjul();

    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Session3Eksempel
{
    internal class Bil:Koeretoej, IHarAlder
    {
        public Bil(string farve, double vaegt, int alder):base(farve, vaegt)
        {
            Alder = alder;
        }

        public int Alder { get; set; }

        public override int AntalHjul()
        {
            return 4;
        }

    }
}

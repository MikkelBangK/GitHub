using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LinqEksempler
{
    internal class Elev
    {
        public Elev(string navn, int klasseId, int alder)
        {
            Navn = navn;
            KlasseId = klasseId;
            Alder = alder;
        }

        public String Navn { get; }
        public int KlasseId { get; }
        public int Alder { get; set; }
    }
}

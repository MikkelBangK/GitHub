using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Session2Eksempel
{
    internal struct Alder
    {
        private int aar;
        private int maaned;

        public Alder(int aar, int maaned)
        {
            this.aar = aar;
            this.maaned = maaned;
        }
        public int Aar{ get =>  aar; set => aar = value; }
        public int Maned
        {
            get
            {
                return maaned;
            }
            set
            {
                maaned = value;
            }
        }
        public void LaegEtAarTil()
        {
            Aar++;
        }

    }
}

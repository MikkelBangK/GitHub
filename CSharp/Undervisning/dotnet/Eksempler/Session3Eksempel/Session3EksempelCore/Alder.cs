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


        public int Aar
        {
            get { return aar; }
            set { aar = value; }

        }
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

    }
}

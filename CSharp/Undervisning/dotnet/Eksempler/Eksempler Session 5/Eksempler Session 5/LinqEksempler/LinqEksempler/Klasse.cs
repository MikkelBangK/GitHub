using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LinqEksempler
{
    internal class Klasse
    {
        public Klasse(int id, string klassenavn, int klassetrin)
        {
            Id = id;
            Klassenavn = klassenavn;
            Klassetrin = klassetrin;
        }

        public int Id { get; set; }
        public String Klassenavn { get; set; }
        public int Klassetrin { get; set; }


    }
}

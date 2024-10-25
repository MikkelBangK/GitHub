using System;
using System.Collections.Generic;

namespace Session3Eksempel
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //List<Koeretoej> k = new List<Koeretoej>();
            //k.Add(new Bil("Sort", 900, 10));
            //k.Add(new Lastvogn("Grå", 3300, true));
            //k.Add(new Lastvogn("Rød", 4300, false));

            //System.Console.WriteLine(SamletAntalHjulPaaLastvogne(k));

            List<Koeretoej> koeretoejer = new List<Koeretoej>();
            //aldersobjekter.Add(new Person(37));
            //aldersobjekter.Add(new Person(48));
            //aldersobjekter.Add(new Person(102));
            koeretoejer.Add(new Bil("Grå", 1000, 20));
            koeretoejer.Add(new Bil("Sort", 1000, 10));
            koeretoejer.Add(new Bil("Rød", 1000, 6));
            //System.Console.WriteLine(koeretoejer[2].Alder);
            koeretoejer[2] = new Bil("Grå", 1000, 12);
            koeretoejer.Add(new Lastvogn("Rød", 10000, false));
            System.Console.WriteLine("samlet antal hjul:" + SamletAntalHjulPaaLastvogne(koeretoejer));


            //Objekter med alder
            List<IHarAlder> AldersObjekter = new List<IHarAlder>();
            AldersObjekter.Add(new Bil("Grå", 1000, 20));
            AldersObjekter.Add(new Bil("Sort", 1000, 10));
            AldersObjekter.Add(new Person(37));
            AldersObjekter.Add(new Person(48));
            Console.WriteLine("Samlet alder:" + SamletAlder(AldersObjekter));

        }

        private static int SamletAntalHjul(List<Koeretoej> koeretoejer)
        {
            int result = 0;
            foreach (Koeretoej item in koeretoejer)
            {
                result += item.AntalHjul();
            }
            return result;
        }
        private static int SamletAntalHjulPaaLastvogne(List<Koeretoej> koeretoejer)
        {
            int result = 0;
            foreach (var item in koeretoejer)
            {
                if (item is Lastvogn)
                {
                    result += item.AntalHjul();
                }
            }
            return result;
        }



        private static int SamletAlder(List<IHarAlder> list)
        {
            int resultat = 0;
            foreach (IHarAlder p in list)
            {
                resultat += p.Alder;
            }
            return resultat;
        }
    }
}

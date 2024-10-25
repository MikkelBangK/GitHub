using System.Collections.Generic;

namespace Session2Eksempel
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var p = new Person(new Alder(20, 2), "Ole");
            //p = new Alder(20,2); ugyldigt, så var betyder ikke 'ingen type'
            //p.MinAlder.Aar = 28;

            List<Person> personer = new List<Person>();
            personer.Add(new Person(new Alder(100, 9), "Kresten"));
            personer.Add(new Person(new Alder(22, 4), "Kim"));
            personer.Add(new Person(new Alder(50, 7), "Per"));
        }
        private static int samletAlderForeach(List<Person> list)
        {
            int resultat = 0;
            foreach (Person p in list)
            {
                resultat += p.MinAlder.Aar;
            }
            return resultat;
        }
        private static int samletAlderFor(List<Person> list)
        {
            int resultat = 0;
            for (int i = 0; i < list.Count; i++)
            {
                resultat += list[i].MinAlder.Aar;
            }
            return resultat;
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LinqEksempler
{
    internal class Program
    {
        private static List<Klasse> klasser = new List<Klasse>();
        private static List<Elev> elever = new List<Elev>();
        static void Main(string[] args)
        {

            //FindXXXPaaListeAfInts();

            //LinQPaaListeAfInts();

            klasser.Add(new Klasse(2, "Første B", 1));
            klasser.Add(new Klasse(1, "Første A", 1));
            klasser.Add(new Klasse(4, "Absolut-klassen", 1));
            klasser.Add(new Klasse(5, "Z-klassen", 1));
            klasser.Add(new Klasse(3, "Anden A", 2));
            klasser.Add(new Klasse(6, "Tredie A", 3));
            klasser.Add(new Klasse(7, "Tredie B", 3));

            elever.Add(new Elev("Ole", 1, 7));
            elever.Add(new Elev("Åse", 1, 7));
            elever.Add(new Elev("Ib", 2, 7));
            elever.Add(new Elev("Oda", 2, 8));
            elever.Add(new Elev("Oda", 6, 8));
            elever.Add(new Elev("Oda", 7, 8));


            //FoersteAarsKlasser();
            //AlleKlasserOgEleverGroupByTrin();
            AlleKlasserOgEleverGroupByTrinMax();
            Console.ReadLine();


        }

        //Non-Linq

        private static void FindXXXPaaListeAfInts()
        {
            List<int> list = new List<int>();
            list.Add(1);
            list.Add(3);
            list.Add(7);
            list.Add(8);
            list.Add(4);
            list.Add(2);

            List<int> result = list.FindAll(i => i >= 7);
            /*            foreach (int i in result)
                        {
                            Console.WriteLine(i);
                        }
            */

            result.ForEach(i => Console.WriteLine(i));
        }

        private static void FoersteAarsKlasser()
        {
            Console.WriteLine("FoersteAarsKlasser");
            List<Klasse> resultat = klasser.FindAll(k => k.Klassetrin == 1);
            // eller:
            //List<Klasse> resultat = klasser.FindAll(FoersteKlassetrin);
            resultat.ForEach(k => Console.WriteLine(k.Klassenavn));
            Console.ReadLine();
        }
        private static bool FoersteKlassetrin(Klasse k)
        {
            return k.Klassetrin == 1;
        }



        //Linq

        private static void LinQPaaListeAfInts()
        {
            List<int> list = new List<int>();
            list.Add(1);
            list.Add(3);
            list.Add(8);
            list.Add(7);
            list.Add(4);
            list.Add(2);

            IEnumerable<int> result = list.Where(i => i >= 7).OrderBy(i => i);
            foreach (int x in result)
            {
                Console.WriteLine(x);
            }

            list[0] = 10;
            foreach (int x in result)
            {
                Console.WriteLine(x);
            }

        }

        private static void FoersteAarsKlasserLinq()
        {
            Console.WriteLine("FoersteAarsKlasserLinq");
            IEnumerable<String> resultat = klasser.Where(k => k.Klassetrin == 1).OrderBy(k => k.Klassenavn).Select(k => "Klasse " + k.Klassenavn + ", klassetrin:" + k.Klassetrin);
            foreach (String k in resultat)
            {
                Console.WriteLine(k);
            }
            Console.ReadLine();
        }

        private static void AlleKlasserOgElever()
        {
            var resultat = elever.Join(klasser, (e) => e.KlasseId, (k) => k.Id,
                (e, k) => 
                new
                {
                    k.Klassenavn,
                    k.Klassetrin,
                    elevnavn = e.Navn,
                    e.Alder
                });
            foreach (var k in resultat)
            {
               System.Console.WriteLine(k.Klassenavn + " " + k.Klassetrin + " " + k.elevnavn);
            }
        }

        private static void AlleKlasserOgEleverGroupByTrin()
        {
            var resultat = elever.Join(klasser, (e) => e.KlasseId, (k) => k.Id,
                (e, k) =>
                new
                {
                    k.Klassenavn,
                    k.Klassetrin,
                    elevnavn = e.Navn,
                    e.Alder
                });
            var grupperetresultat = resultat.GroupBy(ke => ke.Klassetrin);
            foreach (var k in grupperetresultat)
            {
                System.Console.WriteLine(k.Key + " " + k.Count());
                foreach (var klasseElev in k)
                {
                    System.Console.WriteLine(klasseElev.Klassenavn + " " + klasseElev.Klassetrin + " " + klasseElev.elevnavn);
                }
            }
        }

        private static void AlleKlasserOgEleverGroupByTrinMax()
        {
            var resultat = elever.Join(klasser, (e) => e.KlasseId, (k) => k.Id,
                (e, k) =>
                new
                {
                    k.Klassenavn,
                    k.Klassetrin,
                    elevnavn = e.Navn,
                    e.Alder
                });
            var grupperetresultat = resultat.Select(p=> p).GroupBy(ke => ke.Klassetrin);
            foreach (var k in grupperetresultat)
            {
                System.Console.WriteLine(k.Key + " " + k.Sum(ke => ke.Alder));
                foreach (var klasseElev in k)
                {
                    System.Console.WriteLine(klasseElev.Klassenavn + " " + klasseElev.Klassetrin + " " + klasseElev.elevnavn);
                }
            }
        }


    }
}

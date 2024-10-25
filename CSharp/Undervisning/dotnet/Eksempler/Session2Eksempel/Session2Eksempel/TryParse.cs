using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Session2Eksempel
{
    internal class TryParse
    {
        static void Main(string[] args)
        {
            String tekstAtParse = "32";

            //try
            //{
            //    int tal = int.Parse(tekstAtParse);
            //    Console.WriteLine(tal);
            //} catch (Exception e)
            //{
            //    Console.WriteLine("Skriv et tal");
            //}











            int result;
            bool virkedeDet = int.TryParse(tekstAtParse, out result);
            Console.WriteLine("Virkede det?" + virkedeDet);
            if (virkedeDet)
            {
                Console.WriteLine("Resultat:" + result);
            }
            else
            {
                Console.WriteLine("Skriv et tal");
            }
            Console.ReadLine();
        }

    }
}

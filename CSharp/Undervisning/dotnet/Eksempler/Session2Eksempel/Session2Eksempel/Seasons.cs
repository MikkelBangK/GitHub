using System;
using System.Collections.Generic;
using System.Diagnostics.Tracing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Session2Eksempel
{
    [Flags]
    internal enum Seasons
    {
        None = 0,
        Winter = 1,
        Summer = 2,
        Spring = 4,
        Fall = 8
    }

    public class MainClass
    {
        static void Main(string[] args)
        {
            Seasons s = Seasons.Summer;



            //if (s == Seasons.Summer || s== Seasons.Spring)
            //{
            //    Console.WriteLine("Dejligt vejr");
            //}
            //else
            //{
            //    Console.WriteLine("Øv");
            //}



            if ((s & (Seasons.Spring | Seasons.Summer))!=0) {
                Console.WriteLine("Dejligt vejr");
            } else
            {
                Console.WriteLine("Øv");
            }
        }
    }
}

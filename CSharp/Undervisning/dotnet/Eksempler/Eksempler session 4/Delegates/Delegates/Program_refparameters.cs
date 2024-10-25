using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Delegates_ref
{
    internal class Program_refparameters
    {
        private static void Square(ref int x)
        {
            x = x * x;
        }
        private static void AddOne(ref int x)
        {
            x = x + 1;
        }
        static void Main(string[] args)
        {
            int[] values = new int[] { 1, 2, 3 };
            Util_refparameters.Transform(values, Square);      // dynamically hook in Square
            foreach (int i in values)
            {
                Console.Write(i + "  ");           // 1   4   9
            }
            Console.ReadLine();
            Util_refparameters.Transform(values, AddOne);      // dynamically hook in AddOne
            foreach (int i in values)
            {
                Console.Write(i + "  ");           // 1   4   9
            }
            Console.ReadLine();
            Util_refparameters.Transform(values, (ref int x)=>x = x+4);      // dynamically hook in lambda
            foreach (int i in values)
            {
                Console.Write(i + "  ");           // 1   4   9
            }
            Console.ReadLine();


            //Nedenstående fungerer ikke helt efter hensigten
            //Multicast delegate returnerer værdien af sidste metode
            //brug evt. ref-parameter
            int[] values2 = new int[] { 4, 5, 6 };
            Transformer t = Square;
            t += AddOne;
            Util_refparameters.Transform(values2, t);      // dynamically hook in Square
            foreach (int i in values2)
            {
                Console.Write(i + "  ");           // 2   3   4
            }
            Console.ReadLine();
        }
    }

}

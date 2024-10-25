using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Delegates
{
    internal class Program
    {
        private static int Square(int x)
        {
            return x * x;
        }
        private static int AddOne(int x)
        {
            return x + 1;
        }
        static void Main(string[] args)
        {
            int[] values = new int[] { 1, 2, 3 };
            Util.Transform(values, new Transformer(Square));      // dynamically hook in Square
            foreach (int i in values)
            {
                Console.Write(i + "  ");           // 1   4   9
            }
            Console.ReadLine();
            Util.Transform(values, AddOne);      // dynamically hook in AddOne
            foreach (int i in values)
            {
                Console.Write(i + "  ");           // 2   5   10
            }
            Console.ReadLine();
            Util.Transform(values, (int x) => x + 4);      // dynamically hook in lambda
            foreach (int i in values)
            {
                Console.Write(i + "  ");           // 6   9   14
            }
            Console.ReadLine();


            //Nedenstående fungerer ikke helt efter hensigten
            //Multicast delegate returnerer værdien af sidste metode
            //brug evt. ref-parameter
            int[] values2 = new int[] { 3, 4, 5 };
            Transformer t = Square;
            t += AddOne;
            Util.Transform(values2, t);      // dynamically hook in Square
            foreach (int i in values2)
            {
                Console.Write(i + "  ");           // 2   3   4
            }
            Console.ReadLine();
        }
    }

}

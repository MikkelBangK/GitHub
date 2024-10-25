using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Session2Eksempel
{
    internal class TestParameters
    {
        static int a1;
        static void Main(string[] args)
        {
            a1 = 3;
            F(ref a1);
            Console.WriteLine(a1);
            Console.ReadLine();
        }
        private static void F(ref int a)
        {
            a = 37;
            Console.WriteLine(a);
            Console.WriteLine(a1);
            a1 = 15;
            Console.WriteLine(a);
            Console.WriteLine(a1);
        }

    }
}

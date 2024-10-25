using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Session2Eksempel
{
    internal class TestParametersObjects
    {
        static Person a1;
        static void Main(string[] args)
        {
            a1 = new Person(new Alder(),"Ole");
            F(ref a1);
            Console.WriteLine(a1.Navn);
            Console.ReadLine();
        }
        private static void F(ref Person a)
        {
            a.Navn = "Svend Aage";
            Console.WriteLine(a.Navn);
            Console.WriteLine(a1.Navn);
            a = new Person(new Alder(), "Per");
            Console.WriteLine(a.Navn);
            Console.WriteLine(a1.Navn);
            a1 = null;
            Console.WriteLine(a);
            Console.WriteLine(a1);
        }

    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Delegates
{
    public delegate int MyDelegate(string s);
    public delegate int MyDelegate2(int s);

    internal class DelegatesAndLambdas
    {
        static void Main(string[] args)
        {
            //anonymous method
            MyDelegate f1 = delegate (string s) { return s.Length; };
            //lambda
            MyDelegate f2 = (Q) =>  { return Q.Length; };
            //lambda short notation
            MyDelegate f3 = (s) => s.Length;
            //anonymous
            MyDelegate f4 = delegate (string s) { return (s is null) ? -1 : s.Length; };
            //lambda
            MyDelegate f5 = (string s) => { return (s is null) ? -1 : s.Length; };

            int res1 = f1("Hello world");
            int res2 = f2(null);

            Console.WriteLine("f1 returned " + res1);
            Console.WriteLine("f2 returned " + res2);

            Console.ReadLine();
        }


    }
}

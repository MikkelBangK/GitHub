using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Session2Eksempel
{
    internal class TestConvert
    {
        static void Main(string[] args)
        {
            int i1 = 37;
            long l1;
            l1 = i1;
            l1 = (long)int.MaxValue + 1;
            i1 = (int)l1;
            Console.WriteLine(i1);

            System.Boolean b1 = false;
            bool b2 = b1;
            
        }
    }
}

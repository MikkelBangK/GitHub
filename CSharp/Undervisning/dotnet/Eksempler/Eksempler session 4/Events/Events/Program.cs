using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Events
{
    internal class Program
    {
        private static Kraftvaerk k;
        static void Main(string[] args)
        {
            k = new Kraftvaerk();
            k.kraftVaerkOverheated += K_kraftVaerkOverheated;
            //eller vha lambda expression:
            //k.kraftVaerkOverheated += (sender, e) => Console.WriteLine("kraftværk overophedet:" + e.Temperature);
            k.kraftVaerkOverheated += K_kraftVaerkOverheated1;

            k.run();
            //Illegal: 
            //k.kraftVaerkOverheated.Invoke();
        }

        private static void K_kraftVaerkOverheated1(object sender, KraftvaerkEventArgs e)
        {
            Console.WriteLine("kraftværk overophedet:" + e.Temperature);
        }

        private static void K_kraftVaerkOverheated(object sender, KraftvaerkEventArgs e)
        {
            if (e.Temperature > 55)
            {
                k.Power -= 1;
                Console.WriteLine("Reducing power");
            }
        }
    }
}

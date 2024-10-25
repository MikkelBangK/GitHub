using KoeretoejExtensionMethods;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExtensionMethods
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Bil k = new Bil();
            k.Name = "Ford Ka";
            Console.WriteLine(k.GetInfo(true));
            //Svarer til nedenstående
            //Console.WriteLine(Exts.GetInfo(k, false));

            Console.ReadLine();
        }
    }
}

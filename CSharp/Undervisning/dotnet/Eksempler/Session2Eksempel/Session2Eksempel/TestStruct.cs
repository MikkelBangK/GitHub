using System.Drawing;

namespace Session2Eksempel
{
    internal class TestStruct
    {
        static void Main(string[] args)
        {
            Point p1 = new Point(2, 2);
            Point p2 = p1;
            p1.X = 3;
            Console.WriteLine(p2.X);

            Alder alder1 = new Alder();
            alder1.Aar = 27;
            alder1.Maned = 6;
            Alder alder2 = alder1;
            alder2.Maned = 7;
            Console.WriteLine(alder1.Maned);


        }
    }
}

// See https://aka.ms/new-console-template for more information


using Værksted;

List<Medarbejder> workers = new List<Medarbejder>();

CprNr cpr1 = new CprNr("011196", "1234");
Mekaniker m1 = new Mekaniker(cpr1,"Banjomin", "Laksevej", 1998, 500);
workers.Add(m1);

CprNr cpr2 = new CprNr("021296", "2345");
Synsmand s1 = new Synsmand(cpr2, "Slikolaj", "Torskvej", 1996, 290, 2);
workers.Add(s1);

CprNr cpr3 = new CprNr("030196", "3456");
Værkføre v1 = new Værkføre(cpr3, "Loshan", "SkipSkoleVej", 2000, 350, 2020, 75);
workers.Add(v1);

for (int i = 0; i < workers.Count; i++)
{
    Console.WriteLine(workers[i].ToString());
}
Console.WriteLine("Banjomins ugentlige løn er: " + m1.BeregnUgeLøn());
Console.WriteLine("Slikolajs ugentlige løn er: " + s1.BeregnUgeLøn());
Console.WriteLine("Loshans ugentlige løn er: " + v1.BeregnUgeLøn());


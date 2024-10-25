// See https://aka.ms/new-console-template for more information

//Opgave 5.1
//  List<int> talListe = new List<int> { 10, 20, 3, 4, 17, 18, 9, 1, 6, 8, 2 };
//  List<int> ligeTal = talListe.Where(tal => tal % 2 == 0).ToList();
//  ligeTal.ForEach(tal => Console.WriteLine(tal));
//
//  Console.WriteLine("Sidste tal over 15: ");
// int sidsteOver15 = talListe.LastOrDefault(tal => tal > 15);
//  Console.WriteLine(sidsteOver15);
//
// int indeksSidsteOver15 = talListe.FindLastIndex(tal => tal > 15);
// Console.WriteLine("\nIndekset for det sidste tal over 15 er: " + indeksSidsteOver15);

//Opgave 5.2
List<int> talListe2 = new List<int> { 10, 20, 3, 4, 17, 18, 9, 1, 6, 8, 2 };
IEnumerable<int> list = talListe2.Where(tal => tal % 2 == 0);
foreach (int tal in list)
{
    Console.WriteLine(tal);
}
Console.WriteLine("\n");
List<int> talListe3 = new List<int> { 10, 20, 3, 4, 17, 18, 9, 1, 6, 8, 2 };
IEnumerable<int> list2 = talListe3.Where(tal => tal.ToString().Length == 2);
foreach (int tal in list2)
{
    Console.WriteLine(tal);
}
Console.WriteLine("\n");
List<int> talListe4 = new List<int> { 10, 20, 3, 4, 17, 18, 9, 1, 6, 8, 2 };
IEnumerable<int> list3 = talListe4.OrderBy(tal => tal);
foreach (int tal in list3)
{
    Console.WriteLine(tal);
}
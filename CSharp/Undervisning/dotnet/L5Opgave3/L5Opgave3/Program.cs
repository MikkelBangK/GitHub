// See https://aka.ms/new-console-template for more information

using L5Opgave3;

public class Program
{
    public static List<Person> people;
    
    public static void Main(string[] args)
    {
        Exercise1();
        
        List<Person> result = new List<Person>();

        result = people.FindAll(p => p.Score < 2);
        result.ForEach(p => Console.WriteLine(p));
        
        Console.WriteLine("\n");
        
        result = people.FindAll(p => p.Score % 2 == 0);
        result.ForEach(p => Console.WriteLine(p));
        
        Console.WriteLine("\n");
        
        result = people.FindAll(p => p.Score % 2 == 0 && p.Weight > 60);
        result.ForEach(p => Console.WriteLine(p));
        
        Console.WriteLine("\n");
        
        result = people.FindAll(p => p.Weight % 3 == 0);
        result.ForEach(p => Console.WriteLine(p));
        
        //people.ForEach(p => Console.WriteLine(p.Name));
        
        //Opgave 5.4

       Console.WriteLine(people.FindIndex(p => p.Score == 3));
       
       Console.WriteLine(people.FindIndex(p => p.Age < 10 & p.Score == 3));
       
       var count = people.FindAll(p => p.Age < 10 & p.Score == 3).Count();
       Console.WriteLine(count);
       
       Console.WriteLine("\n");

       Console.WriteLine(result.FindIndex(p => p .Age < 8 & p.Score == 3));
    }
    
    public static void Exercise1()
    {
        try
        {
            people = Person.ReadCSVFile(@"/Users/mikkelkristensen/GitHub/CSharp/filer/data1.csv");
        }
        catch (Exception ex)
        {
            Console.WriteLine("EXCEPTION: " + ex.Message);
            Console.WriteLine("You should probably set the filename to the" +
                              "Person.ReadCSVFile method to something on your disk!");
        }
    }
}
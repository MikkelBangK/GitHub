namespace Oevelser;

public class MyList
{
    private List<int> numbers = new List<int>();

    public MyList()
    {
    }

    public void Add(params int[] items)
    {
        foreach (var item in items)
        {
            numbers.Add(item);
        }
    }
    

    public void AddRandom(int antal)
    {
        var rand = new Random();
        for (int i = 0; i < antal; i++)
        {
            int randomNumber = rand.Next(0, 100) + 1;
            numbers.Add(randomNumber);
        }
    }
    public void PrintNumbers()
    {
        foreach (var tal in numbers)
        {
            Console.WriteLine(tal);
        }
    }
}
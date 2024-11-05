namespace Lektion4Opgaver;

public class Opgave41A
{
    public delegate int Operation(int a, int b);

    public static int Add(int a, int b)
    {
        return a + b;
    }

    public static int Multiply(int a, int b)
    {
        return a * b;
    }

    public static void CalculateAndDisplay(int a, int b, Operation operation)
    {
        Console.WriteLine("a: " + a + "\n" + "b: " + b);
        Operation op = operation;
        int value = operation(a, b);
        Console.WriteLine(value);
    }
    // public static void Main(string[] args)
    // {
    //     CalculateAndDisplay(10, 5, Add);
    //     CalculateAndDisplay(5, 10, Multiply);
    // }
    
}
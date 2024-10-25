namespace Lektion2Opgaver;
using System;
public class Oevelse3
{
    public static void Main(string[] args)
    {
        //Opgave 3
        // var input = Console.ReadLine();
        // int inputint = int.Parse(input);
        // Fibonacci(inputint);
        
        //Opgave 4
        // Console.WriteLine("yyyy-mm-dd");
        // string input = Console.ReadLine();
        // DateTime.TryParse(input, out DateTime inputdate);
        // CalculateAge(inputdate, out int age);
        
        //Opgave 5
        MyNormalMethod(0);

    }
    static void Fibonacci(int count)
        {
            int firstNumber = 0;
            int secondNumber = 1;
            Console.WriteLine("Fibonacci sequence:");
            for (int i = 1; i <= count; i++)
            {
                Console.WriteLine(firstNumber);
                if (i < count)
                {
                    Console.WriteLine(",");
                }

                int nextNumber = firstNumber + secondNumber;
                firstNumber = secondNumber;
                secondNumber = nextNumber;
                {

                }
            }
        }
    static void CalculateAge(DateTime birthDateInput, out int age)
    {
        age = DateTime.Now.Year - birthDateInput.Year;
        
        if (DateTime.Now.Date < birthDateInput.AddYears(age))
        {
            age--;
        }
        Console.WriteLine(age);
    }
    static private void MyMothodWithError(int num = 0)
    {
        if (num == 0)
        {
            throw new ArgumentException("Number cannot be 0");
        }
        Console.WriteLine($"Number is: {num}");
    }

    static public void MyNormalMethod(int num = 0)
    {
        try
        {
            MyMothodWithError(num);
        }
        catch (ArgumentException e)
        {
            Console.WriteLine($"Caught an exception: {e.Message}");
        }
        finally
        {
            Console.WriteLine("Finally print");
        }
    }
    }

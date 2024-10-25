namespace Lektion2Opgaver;

public class Oevelse5
{
    private void MyMothodWithError(int num = 0)
    {
        if (num == 0)
        {
            throw new ArgumentException("Number cannot be 0");
        }
        Console.WriteLine($"Number is: {num}");
    }

    public void MyNormalMethod(int num = 0)
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
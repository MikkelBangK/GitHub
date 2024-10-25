namespace FactorialPowerPlant;

public class Factorio
{
    public static int Factorial(int n)
    {
        if (n < 0)
        {
            throw new ArgumentException("n must be positive");
        }

        if (n == 0 || n == 1)
        {
            return 1;
        }
        else
        {
            return n * Factorial(n - 1);
        }
    }
}
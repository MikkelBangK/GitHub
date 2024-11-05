namespace FactorialPowerPlant;
public static class IntExt
{
    public static int FactorialExt(this int number)
    {
        if (number < 0)
            throw new ArgumentException("Factorial is not defined for negative numbers.");
            
        if (number == 0 || number == 1)
            return 1;

        int result = 1;
        for (int i = 2; i <= number; i++)
        {
            result *= i;
        }

        return result;
    }
}
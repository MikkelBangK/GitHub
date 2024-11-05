namespace PowerPlant;

public class NuclearPowerPlant
{
    public delegate void Warning();

    Random random = new Random();
    private Warning _warning;
    private int x = 0;

    public void SetWarning(Warning warning)
    {
        _warning += warning;
    }

    public void HeatUp()
    {
        x = random.Next(1, 101);
        Console.WriteLine("Temperature: " + x);
        if (x > 50)
        {
            _warning.Invoke();
        }
    }
}
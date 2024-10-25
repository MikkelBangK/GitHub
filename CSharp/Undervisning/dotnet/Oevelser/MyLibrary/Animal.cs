namespace MyLibrary;

public class Animal : IAnimal
{
    private string specie;

    public Animal(string specie)
    {
        this.specie = specie;
    }

    public bool IsDog()
    {
        if (specie.Equals("dog", StringComparison.OrdinalIgnoreCase))
        {
            return true;
        } 
        else
        {
            return false;
        }
    }

    public string Specie
    {
        get
        {
            return specie;
        }
        set
        {
            specie = value;
        }
    }
}
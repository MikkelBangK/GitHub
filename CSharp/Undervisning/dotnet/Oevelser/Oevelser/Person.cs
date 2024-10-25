namespace Oevelser;

public class Person
{
    private string fornavn;
    public Person(string navn)
    {
        fornavn = navn;
    }

    public string Fornavn
    {
        get
        {
            return fornavn;
        }
        set
        {
            fornavn = value;
        }
    }

    public override string ToString()
    {
        return Fornavn;
    }
}
namespace Lektion9Webapi;

public class Person
{
    private string name;
    private int age;
    private int id;
    
    public Person (){ }
    
    public Person(string name, int age, int id)
    {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public string Name
    {
        get => name;
        set => name = value ?? throw new ArgumentNullException(nameof(value));
    }

    public int Age
    {
        get => age;
        set => age = value;
    }

    public int Id
    {
        get => id;
        set => id = value;
    }
}
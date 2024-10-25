namespace L5Opgave3;

public class Person
{
    private string name;
    private int age;
    private int weight;
    private int score;

    public bool accepted;

    public Person(string data)
    {
        var L = data.Split(';');
        Name = L[0];
        Age = int.Parse(L[1]);
        Weight = int.Parse(L[2]);
        Score = int.Parse(L[3]);
        Accepted = false;
    }

    public string Name
    {
        get { return name; }
        set { name = value; }
    }

    public int Age
    {
        get { return age; }
        set { age = value; }
    }

    public int Weight
    {
        get { return weight; }
        set { weight = value; }
    }

    public int Score
    {
        get { return score; }
        set { score = value; }
    }

    public bool Accepted
    {
        get { return accepted; }
        set { accepted = value; }
    }

    public override string ToString()
    {
        return "Name: " + name + " Age: " + age + " Weight: " + weight + " Score: " + score + " Accepted: " + accepted;
    }
    
    public static List<Person> ReadCSVFile(string filename) {
        List<Person> list = new List<Person>();
        using (var file = new StreamReader(filename)) {
            string line;
            while ((line = file.ReadLine()) != null) {
                var p = new Person(line);
                list.Add(p);
//Console.WriteLine(p);
            }
        }
        return list;
    }
}
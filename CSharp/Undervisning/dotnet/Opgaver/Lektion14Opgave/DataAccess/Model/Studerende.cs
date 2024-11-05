namespace DataAccess.Model;

public class Studerende
{
    public string Navn { get; set; }

    public int Alder { get; set; }

    public DateTime Studiestart { get; set; }
    
    public int StudentId { get; set; }
    private static int nextId = 1;
    public Studietype Studietype { get; set; }
    
    public Studerende(string navn, int alder, DateTime studiestart, Studietype studietype)
    {
        Navn = navn;
        Alder = alder;
        Studiestart = studiestart;
        StudentId = nextId++;
        Studietype = studietype;
    }
    
}

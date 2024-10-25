namespace DataAccess.Model;

public class Studerende
{
    public enum Studietype
    {
        bachelor,
        kandidat,
        enkeltfag,
        videreuddannelse
    };

    public string Navn { get; set; }

    public int Alder { get; set; }

    public DateTime Studiestart { get; set; }
    
    public int StudentId { get; set; }
    
    public Studietype studietype { get; set; }
    
    public Studerende(string navn, int alder, DateTime studiestart, int studentId, Studietype studietype)
    {
        Navn = navn;
        Alder = alder;
        Studiestart = studiestart;
        StudentId = studentId;
        this.studietype = studietype;
    }
    
}

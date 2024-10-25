namespace DTO.Model;

public class Studerende
{
    public enum studietype
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
    public studietype Studietype { get; set; }
    
    public Studerende(string navn, int alder, DateTime studiestart, int studentId, studietype studietype)
    {
        Navn = navn;
        Alder = alder;
        Studiestart = studiestart;
        StudentId = studentId;
        Studietype = studietype;
    }
    
}
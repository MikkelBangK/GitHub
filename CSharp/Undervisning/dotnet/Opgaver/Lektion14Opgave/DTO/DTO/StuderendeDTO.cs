using DataAccess.Model;

namespace DTO.Model;

public class StuderendeDTO
{
    public string Navn { get; set; }

    public int Alder { get; set; }

    public DateTime Studiestart { get; set; }
    
    public int StudentId { get; set; }
    public static int nextId = 1;
    public Studietype Studietype { get; set; }
    
    public StuderendeDTO(string navn, int alder, DateTime studiestart, Studietype studietype)
    {
        Navn = navn;
        Alder = alder;
        Studiestart = studiestart;
        StudentId = nextId++;
        Studietype = studietype;
    }
    
}
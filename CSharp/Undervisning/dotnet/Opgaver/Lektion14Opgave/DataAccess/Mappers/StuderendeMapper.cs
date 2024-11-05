
using DataAccess.Model;

namespace DataAccess.Mappers;

public class StuderendeMapper
{
    public static DTO.Model.StuderendeDTO Map(Studerende studerende)
    {
        return new DTO.Model.StuderendeDTO(studerende.Navn, studerende.Alder, studerende.Studiestart, studerende.Studietype);
    }
    public static Studerende Map(DTO.Model.StuderendeDTO studerendeDTO)
    {
        return new Studerende(studerendeDTO.Navn, studerendeDTO.Alder, studerendeDTO.Studiestart, studerendeDTO.Studietype);
    }
}
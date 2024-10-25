using DataAccess.Model;
using DTO.Model;
using Studerende = DataAccess.Model.Studerende;

namespace DataAccess.Mappers;

public class StuderendeMapper
{
    public DTO.Model.Studerende Map(Model.Studerende studerende)
    {
        return new DTO.Model.Studerende(studerende.Navn, studerende.Alder, studerende.Studiestart, studerende.StudentId, DTO.Model.Studerende.studietype.kandidat);
    }
    public Model.Studerende Map(DTO.Model.Studerende studerende)
    {
        return new Model.Studerende(studerende.Navn, studerende.Alder, studerende.Studiestart, studerende.StudentId, Studerende.Studietype.kandidat);
    }
}
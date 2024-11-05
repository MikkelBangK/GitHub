using DataAccess.Context;
using DataAccess.Mappers;
using DataAccess.Model;
using DTO.Model;

namespace DataAccess.Repositories;

public class StuderendeRepositories
{
    public static StuderendeDTO GetStuderende(int id)
    {
        using (StuderendeContext db = new StuderendeContext())
        {
            return StuderendeMapper.Map(db.Studerende.Find(id));
        }
    }
}
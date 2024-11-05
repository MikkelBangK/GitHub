using DataAccess.Model;
using DataAccess.Repositories;
using DTO.Model;

namespace BusinessLogic;

public class StuderendeBLL
{
    public StuderendeDTO getStuderende(int id)
    {
        return StuderendeRepositories.GetStuderende(id);
    }
}
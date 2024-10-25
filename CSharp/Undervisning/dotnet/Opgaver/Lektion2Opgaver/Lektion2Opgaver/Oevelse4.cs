namespace Lektion2Opgaver;

public class Oevelse4
{
    void calculateAge(DateTime birthDateInput, out int age)
    {
        age = DateTime.Now.Year - birthDateInput.Year;
    }
}
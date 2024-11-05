namespace Lektion4Opgaver;

public class Opgave4
{
    public static bool Lang(string s)
    {
        ;
        if (s.Length > 5)
        {
            return true;
        }
        else return false;

    }

    public static bool Lang2(string s, int n)
    {
        if (s.Length > n)
        {
            return true;
        }
        else return false;
    }

    // public static void Main(string[] args)
    // {
    //     Console.WriteLine(Lang("Kat"));
    //     Console.WriteLine(Lang2("Havmåge", 6));
    // }
}
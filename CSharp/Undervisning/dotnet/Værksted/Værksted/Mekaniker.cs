namespace Værksted;

public class Mekaniker : Medarbejder
{
    private int svendeprøve;
    private int timeløn;

    public Mekaniker(CprNr cpr, string navn, string adresse, int svendeprøve, int timeløn) : base(cpr, navn, adresse)
    {
        this.svendeprøve = svendeprøve;
        this.timeløn = timeløn;
    }

    public int Svendeprøve
    {
        get { return svendeprøve; }
        set { value = svendeprøve; }
    }

    public int Timeløn
    {
        get { return timeløn; }
        set { value = timeløn; }
    }

    public override int BeregnUgeLøn()
    {
        return timeløn * TimerPerUge;
    }
    public override string ToString()
    {
        return $"{base.ToString()}, Svendeprøve: {svendeprøve}, Timeløn: {timeløn}";
    }
}
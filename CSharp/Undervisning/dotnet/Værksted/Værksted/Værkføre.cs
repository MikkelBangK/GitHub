namespace Værksted;

public class Værkføre : Mekaniker
{
    private int udnævnelsesår;
    private int tillæg;
    public Værkføre(CprNr cpr, string navn, string adresse, int svendeprøve, int timeløn, int udnævnenlsesår, int tillæg) : base(cpr, navn, adresse, svendeprøve, timeløn)
    {
        this.Udnævnenlsesår = udnævnenlsesår;
        this.Tillæg = tillæg;
    }

    public int Udnævnenlsesår
    {
        get { return tillæg;}
        set { udnævnelsesår = value; }
    }
    
    public int Tillæg
    {
        get { return Tillæg;}
        set { tillæg = value; }
    }

    public override int BeregnUgeLøn()
    {
        return Timeløn * TimerPerUge + tillæg;
    }

    public override string ToString()
    {
        return $"{base.ToString()}, Udnævnelses år: {udnævnelsesår}, Tillæg: {tillæg}";
    }
}
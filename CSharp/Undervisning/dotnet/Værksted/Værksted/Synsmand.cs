namespace Værksted;

public class Synsmand : Mekaniker
{
    private int antalSynPerUge;

    public Synsmand(CprNr cpr, string navn, string adresse, int svendeprøve, int timeløn, int antalSynPerUge) : base(cpr, navn, adresse, svendeprøve, timeløn)
    {
        this.antalSynPerUge = antalSynPerUge;
    }

    public int AntalSynPerUge
    {
        get { return antalSynPerUge; }
        set { value = antalSynPerUge; }
    }

    public override int BeregnUgeLøn()
    {
        return AntalSynPerUge * 290;
    }
    public override string ToString()
    {
        return $"{base.ToString()}, Antal syn per uge: {antalSynPerUge}";
    }
}
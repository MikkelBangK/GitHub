namespace Værksted;

public class Medarbejder
{
    private string navn;
    private string adresse;
    private const int timerPerUge = 37;
    private CprNr cpr;

    public Medarbejder(CprNr cpr, string navn, string adresse)
    {
        this.cpr = cpr;
        this.navn = navn;
        this.adresse = adresse;
    }

    public CprNr CpR
    {
        get { return cpr; }
        set { cpr = value; }
    }

    public string Navn
    {
        get { return navn; }
        set { navn = value;}
    }

    public string Adresse
    {
        get { return adresse; }
        set { adresse = value; }
    }

    public int TimerPerUge
    {
        get { return timerPerUge; }
    }

    public virtual int BeregnUgeLøn()
    {
        return 0;
    }
    public override string ToString()
    {
        return $"Medarbejder {navn}, adresse: {adresse}";
    }
  
}
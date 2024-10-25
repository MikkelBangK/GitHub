namespace Værksted;

public class CprNr
{
    private string bDate;
    private string sNumber;

    public CprNr(string bDate, string sNumber)
    {
        this.bDate = bDate;
        this.sNumber = sNumber;
    }

    public string BDate
    {
        get { return bDate; }
        set { bDate = value; }
    }

    public string SNumber
    {
        get { return sNumber; }
        set { sNumber = value; }
    }
}
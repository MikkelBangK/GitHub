namespace Lektion3Opgaver;

public abstract class Shape
{
  
    private double x;
    private double y;

    public Shape(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
        
    public Shape() : this(1, 1) { }

    public double X
    {
        get { return x; }
        set { x = value; }
    }
    public double Y
    {
        get { return y; }
        set { y = value; }
    }
    public override string ToString()
    {
        return $"Shape at Position ({X}, {Y})";
    }

    public double Area()
    {
        return x * y;
    }
    
}

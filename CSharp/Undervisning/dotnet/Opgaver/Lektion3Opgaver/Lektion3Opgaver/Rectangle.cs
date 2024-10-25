namespace Lektion3Opgaver;

public class Rectangle : Shape
{
    private double lenght;
    private double width;

    public double Lenght
    {
        get;
        set;
    }

    public double Width
    {
        get;
        set;
    }

    public Rectangle(double x, double y, double lenght, double width) : base(x, y)
    {
        this.lenght = lenght;
        this.width = width;
    }
    public override string ToString()
    {
        return $"{base.ToString()}, Length: {lenght}, Weight: {width}";
    }

    public new double Area()
    {
        return lenght * width;
    }
}
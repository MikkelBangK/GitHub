namespace Lektion3Opgaver;

public class Circle : Shape
{
    private double radius;

    public Circle(double x, double y,
        double radius): base(x,y) {
        this.radius = radius;
    }

    public double Radius
    {
        get { return radius;}
        set { radius = value; } }
    
    public override string ToString()
    {
        return $"{base.ToString()}, Radius: {Radius}";
    }

    public new double Area()
    {
        return Math.PI * (Radius * Radius);
    }
}
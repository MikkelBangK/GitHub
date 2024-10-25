namespace Lektion3Opgaver;

public class Print
{
    public static void Main(string[] args)
    {
        Circle c1 = new Circle(2, 4, 6);
        Circle c2 = new Circle(4, 8, 12);

        Rectangle r1 = new Rectangle(10, 4, 10, 8);
        Rectangle r2 = new Rectangle(2, 2, 2, 2);
        
        List<Shape> shapes = new List<Shape>();
        
        shapes.Add(c1);
        shapes.Add(c2);
        shapes.Add(r1);
        shapes.Add(r2);

        for (int i = 0; i < shapes.Count; i++)
        {
            Console.WriteLine(shapes[i].ToString());
            Console.WriteLine("Area is " + shapes[i].Area());
        }
    }
}
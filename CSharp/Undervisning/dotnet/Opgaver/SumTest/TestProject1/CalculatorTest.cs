using SumTest;

namespace TestProject1;

[TestFixture]
[TestOf(typeof(Calculator))]
public class CalculatorTest
{

    [Test]
    public void Add()
    {
        Assert.That(Calculator.Add(2, 2), Is.EqualTo(4));
    }
    [Test]
    public void Subtract()
    {
        Assert.That(Calculator.Subtract(2, 2), Is.EqualTo(0));
    }
    [Test]
    public void Multiply()
    {
        Assert.That(Calculator.Multiply(2, 2), Is.EqualTo(4));
    }
    [Test]
    public void Divide()
    {
        Assert.That(Calculator.Divide(2, 2), Is.EqualTo(1));
    }
}
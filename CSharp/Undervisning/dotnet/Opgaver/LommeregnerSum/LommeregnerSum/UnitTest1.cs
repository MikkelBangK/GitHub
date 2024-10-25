namespace LommeregnerSum;
using sandbox1;
public class Tests
{
    [SetUp]
    public void Setup()
    {
        
    }

    [Test]
    public void Test1()
    {
        Assert.AreEqual(Calculator.Add(2, 2), 4);
    }
}
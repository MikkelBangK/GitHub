// See https://aka.ms/new-console-template for more information


using System.Data;
using FactorialPowerPlant;
using PowerPlant;


int Power(int n, int p)
{
    if (p == 0)
    {
        return 1;
    }
    else
    {
        return n * Power(n, p - 1);
    }
}
void WarningToConsole()
{
    Console.WriteLine("WARNING! Temperature is too high!");
}

void AdditionalWarningToConsole()
{
    Console.WriteLine("WARNING! Reactore core must cool down!");
}
NuclearPowerPlant.Warning warning = WarningToConsole;
NuclearPowerPlant chernobyl = new NuclearPowerPlant();
chernobyl.SetWarning(WarningToConsole);
chernobyl.SetWarning(AdditionalWarningToConsole);
chernobyl.HeatUp();
Console.WriteLine(4.FactorialExt());
Console.WriteLine(Power(2, 10));
// See https://aka.ms/new-console-template for more information


using System.Data;
using PowerPlant;


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

// See https://aka.ms/new-console-template for more information

using Oevelser;
using MyLibrary;

Console.WriteLine("Hello, World!");

Person person = new Person("Sliko");
Console.WriteLine(person);
person.Fornavn = "Nikolaj";
Console.WriteLine(person);

var fido = new Animal("Dog");
Console.WriteLine("Is Fido a dog? " + fido.IsDog());


var numbers = new MyList();
numbers.Add(1);
numbers.Add(420);
numbers.Add(69);
numbers.Add(1337);
numbers.Add(99);

numbers.PrintNumbers();

var randomNumber = new MyList();
randomNumber.AddRandom(10);
randomNumber.PrintNumbers();
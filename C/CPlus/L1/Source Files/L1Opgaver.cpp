// my first program in C++
#include <iostream>
using namespace std;
    int input;


    void opgave2(){
        cout << "Hello world!";
        cout << "\n";
        cout << "Nikolaj must be reeducated";
        cin >> input;
        if (input > 3)
        {
            cout << "Du har indtastet et tal højere end 3";
        }
    }
void opgave3a() {
    string food = "Pizza";  // Variable declaration
    string* ptr = &food;    // Pointer declaration

    // Reference: Output the memory address of food with the pointer
    cout << ptr << "\n";

    // Dereference: Output the value of food with the pointer
    cout << *ptr << "\n";
}

void opgave3b() {
    string food = "Pizza";
    string* ptr = &food;
    string s = "and hotdog";

    // Output the value of food
    cout << food << "\n";

    // Output the memory address of food
    cout << &food << "\n";

    // Access the memory address of food and output its value
    cout << *ptr << "\n";

    // Change the value of the pointer
    *ptr = "Hamburger";

    // Output the new value of the pointer
    cout << *ptr << "\n";

    // Output the new value of the food variable
    cout << food << "\n";
}
void swapNums(int& x, int& y) {
    int z = x;
    x = y;
    y = z;
}
void opgave4(char& x, char& y) {
    char z = x;
    x = y;
    y = z;
}

int opgave5(int k) {
    if (k > 0) {
        return k + opgave5(k - 1);
    } else {
        return 0;
    }
}

int opgave5b(int n) {
    int result;
    if (n == 0) {
        result = 1;
    }
    else {
        result = n * opgave5b(n - 1);
    }
    return result;
}

class Car { // The class
public: // Access specifier
    string brand; // Attribute
    string model; // Attribute
    int year; // Attribute
    Car(string x, string y, int z) { // Constructor with parameters
        brand = x;
        model = y;
        year = z;
    }
};


int main(){
       // opgave2();
    //opgave3a();
    //opgave3b();

    int firstNum = 10;
    int secondNum = 20;

    char firstChar = 'a';
    char secondChar = 'b';

    cout << "Before swap: " << "\n";
    cout << firstNum << secondNum << "\n";

    cout << "Before swap: " << "\n";
    cout << firstChar << secondChar << "\n";

    // Call the function, which will change the values of firstNum and secondNum
    swapNums(firstNum, secondNum);
    opgave4(firstChar, secondChar);

    cout << "After swap: " << "\n";
    cout << firstChar << secondChar << "\n";

    cout << "After swap: " << "\n";
    cout << firstNum << secondNum << "\n";

    cout << "Opgave 5: " << "\n";

    int result = opgave5(100);
    cout << result;
    cout << "\n";

    cout << "Opgave 5b: " << "\n";

    int result2 = opgave5b(12);
    cout << result2;
    cout << "\n";

    //Opgave 6;

    Car carObj1("BMW", "X5", 1999);
    Car carObj2("Ford", "Mustang", 1969);
    cout << carObj1.brand << " " << carObj1.model << " " << carObj1.year << "\n";
    cout << carObj2.brand << " " << carObj2.model << " " << carObj2.year << "\n";

return 0;
}

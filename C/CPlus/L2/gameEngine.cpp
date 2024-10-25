//
// Created by Mikkel Bang on 27/02/2024.
//
#include <iostream>
#include <random>
#include "gameEngineH.h"
using namespace std;


void rng() {
    srand(time(nullptr));
    int i = std::rand() % 100;
    int count = 0;
    int x = -1;
    cout << "Welcome to guess the number!\nIf you guess wrong you will be sent to the shadow realm!\nGood luck my g!";
    while (x != i) {
        cin >> x;
        if (x < 0){
            cout << "Please enter a non-negative number.\n";
            continue;
        }
        if (x == i) {
            cout << "You guess was: " << x;
            cout << "\n";
            cout << "and the rng number was: " << i;
            cout << "\n";
            cout << "Congratulations you guess was correct!";
            cout << "\n";
            cout << "Your amount of tries: " << count;
        } else {
            count++;
            cout << "Wrong number! Your amount of tries so far: " << count;
            cout << "\n";
        }
    }
}

string* DMU_ReverseAlphabet(){
    static string abc = "z, y, x, w, v, u, t, s, r, q, p, o, n, m, l, k, j, i, h, g, f, e, d, c, b, a\n";
    return &abc;
}

string* DMU_PrintNumbers(){
    static string def = "0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15\n";
    return &def;
}

void ft_is_negative(int n){
    if (n % 2 == 0){
        cout << "P" << endl;
    } else {
        cout << "N";
    }
}

 string* DMU_split(char const *s, char c){
      string* splits [0];
 }
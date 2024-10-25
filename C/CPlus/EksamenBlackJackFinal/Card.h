//
// Created by Mikkel Bang on 14/05/2024.
//

#ifndef CARD_H
#define CARD_H
#include <string>

enum class Suit { Hearts, Diamonds, Clubs, Spades };
enum class Rank { Two = 2, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace };

class Card {
public:
    Card(Suit suit, Rank rank);
    std::string toString() const;
    int getValue() const;

private:
    Suit suit;
    Rank rank;
};

#endif //CARD_H

//
// Created by Mikkel Bang on 14/05/2024.
//
#include <string>
#include "Card.h"


Card::Card(Suit suit, Rank rank) : suit(suit), rank(rank) {}

std::string Card::toString() const {
    static const std::string suits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };
    static const std::string ranks[] = { "", "", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
    return ranks[static_cast<int>(rank)] + " of " + suits[static_cast<int>(suit)];
}

int Card::getValue() const {
    if (rank >= Rank::Two && rank <= Rank::Ten) return static_cast<int>(rank);
    if (rank >= Rank::Jack && rank <= Rank::King) return 10;
    return 11;
}

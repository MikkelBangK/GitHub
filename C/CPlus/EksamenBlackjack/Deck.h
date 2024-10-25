//
// Created by Mikkel Bang on 14/05/2024.
//
#ifndef DECK_H
#define DECK_H

#include "Card.h"
#include <vector>
#include <algorithm>
#include <random>

class Deck {
public:
    Deck();
    void shuffle();
    Card drawCard();

private:
    std::vector<Card> cards;
    size_t currentCardIndex;
};

#endif // DECK_H


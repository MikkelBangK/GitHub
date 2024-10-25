//
// Created by Mikkel Bang on 14/05/2024.
//
#ifndef PLAYER_H
#define PLAYER_H
#include "Card.h"
#include <vector>

class Player {
public:
    void addCard(const Card& card);
    int getHandValue() const;
    void clearHand();
    void printHand() const;
    int getFirstCardValue() const;
private:
    std::vector<Card> hand;
};


#endif //PLAYER_H

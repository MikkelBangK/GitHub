//
// Created by Mikkel Bang on 02/06/2024.
//
#ifndef GameLogic_H
#define GameLogic_H

#include "Deck.h"
#include "Player.h"

class GameLogic {
public:
    void play();

private:
    Deck deck;
    Player player;
    Player dealer;

    void playerTurn();
    void dealerTurn();
    void showResult();
    bool continueGame();
};

#endif // GameLogic_H

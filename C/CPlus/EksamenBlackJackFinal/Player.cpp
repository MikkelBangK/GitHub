//
// Created by Mikkel Bang on 14/05/2024.
//

#include <iostream>
#include "Player.h"

void Player::addCard(Card* card) {
    hand.push_back(card);
}

int Player::getHandValue() const {
    int total = 0;
    int aceCount = 0;
    for (const auto& cardPtr : hand) {
        total += cardPtr->getValue();
        if (cardPtr->getValue() == 11) aceCount++;
    }
    while (total > 21 && aceCount > 0) {
        total -= 10;
        aceCount--;
    }
    return total;
}

void Player::clearHand() {
    for (auto cardPtr : hand) {
        delete cardPtr;
    }
    hand.clear();
}

void Player::printHand() const {
    for (const auto& cardPtr : hand) {
        std::cout << cardPtr->toString() << " ";
    }
    std::cout << std::endl;
}

int Player::getFirstCardValue() const {
    if (!hand.empty()) {
        return hand.front()->getValue();
    }
    return 0;
}


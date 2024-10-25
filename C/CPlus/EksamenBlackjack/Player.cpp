//
// Created by Mikkel Bang on 14/05/2024.
//

#include <iostream>
#include "Player.h"

void Player::addCard(const Card & card) {
    hand.push_back(card);
}

int Player::getHandValue() const {
    int total = 0;
    int aceCount = 0;
    for (const auto& card : hand) {
        total += card.getValue();
        if (card.getValue() == 11) aceCount++;
    }
    while (total > 21 && aceCount > 0) {
        total -= 10;
        aceCount--;
    }
    return total;
}

void Player::clearHand() {
    hand.clear();
}

void Player::printHand() const {
    for (const auto& card : hand) {
        std::cout << card.toString() << " ";
    }
    std::cout << std::endl;
}
int Player::getFirstCardValue() const {
    if (!hand.empty()) {
        return hand.front().getValue();
    }
    return 0;
}

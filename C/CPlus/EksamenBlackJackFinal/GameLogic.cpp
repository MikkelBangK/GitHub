//
// Created by Mikkel Bang on 02/06/2024.
//

#include "GameLogic.h"
#include <iostream>

void GameLogic::play() {
    while(true)
    {
        player.clearHand();
        dealer.clearHand();
        deck.shuffle();

        player.addCard(deck.drawCard());
        player.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());

        std::cout << "Player's hand: ";
        player.printHand();
        std::cout << "Player's hand value: " << player.getHandValue() << std::endl;

        std::cout << "Dealer's hand: ";
        dealer.printHand();
        std::cout << "Dealer's shown card value: " << dealer.getFirstCardValue() << std::endl;

        playerTurn();
        dealerTurn();
        showResult();
        if (!continueGame()) {
            break;
        }
    }
}

void GameLogic::playerTurn() {
    while (player.getHandValue() < 21) {
        char choice;
        std::cout << "Hit or stand? (h/s): ";
        std::cin >> choice;
        if (choice == 'h') {
            player.addCard(deck.drawCard());
            std::cout << "Player's hand: ";
            player.printHand();
            std::cout << "Player's hand value: " << player.getHandValue() << std::endl;
        } else {
            break;
        }
    }
}

void GameLogic::dealerTurn() {
    while (dealer.getHandValue() < 17) {
        dealer.addCard(deck.drawCard());
    }
    std::cout << "Dealer's hand: ";
    dealer.printHand();
    std::cout << "Dealer's hand value: " << dealer.getHandValue() << std::endl;
}

void GameLogic::showResult() {
    int playerValue = player.getHandValue();
    int dealerValue = dealer.getHandValue();
    std::cout << "Player's hand value: " << playerValue << std::endl;
    std::cout << "Dealer's hand value: " << dealerValue << std::endl;

    if (playerValue > 21) {
        std::cout << "Player busts! Dealer wins." << std::endl;
    } else if (dealerValue > 21) {
        std::cout << "Dealer busts! Player wins." << std::endl;
    } else if (playerValue > dealerValue) {
        std::cout << "Player wins!" << std::endl;
    } else if (playerValue < dealerValue) {
        std::cout << "Dealer wins!" << std::endl;
    } else {
        std::cout << "It's a tie!" << std::endl;
    }
}

bool GameLogic::continueGame() {
    char choice;
    std::cout << "Play again? (y/n): ";
    std::cin >> choice;
    return choice == 'y';
}

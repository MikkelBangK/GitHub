//
// Created by Mikkel Bang on 14/05/2024.
//

#include "Deck.h"

Deck::Deck() : currentCardIndex(0) {
    for (int suit = static_cast<int>(Suit::Hearts); suit <= static_cast<int>(Suit::Spades); ++suit) {
        for (int rank = static_cast<int>(Rank::Two); rank <= static_cast<int>(Rank::Ace); ++rank) {
            cards.emplace_back(static_cast<Suit>(suit), static_cast<Rank>(rank));
        }
    }
    shuffle();
}

void Deck::shuffle() {
    std::random_device rd;
    std::mt19937 g(rd());
    std::shuffle(cards.begin(), cards.end(), g);
    currentCardIndex = 0;
}

Card Deck::drawCard() {
    if (currentCardIndex < cards.size()) {
        return cards[currentCardIndex++];
    }
    throw std::out_of_range("No more cards in the deck");
}

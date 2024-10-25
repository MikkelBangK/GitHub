cmake_minimum_required(VERSION 3.28)
project(EksamenBlackjack)

set(CMAKE_CXX_STANDARD 17)

add_executable(EksamenBlackjack main.cpp
        Card.cpp
        Card.h
        Deck.cpp
        Deck.h
        Player.cpp
        Player.h
        GameLogic.cpp
        GameLogic.h
)

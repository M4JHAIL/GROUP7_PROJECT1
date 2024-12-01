package controller;

import view.UNOGame;

/**
 * Main class to start the UNO game.
 */
public class Main {

    public static void main(String[] args) {
        UNOGame game = new UNOGame("UNO");
        game.addPlayers(); // Add players
        game.startGame();  // Start the game
    }
}

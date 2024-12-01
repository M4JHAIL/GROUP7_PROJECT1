package model;

import java.util.ArrayList;

/**
 * Represents a player in the UNO game.
 */
public class Player {

    private String name; // Player's name
    private ArrayList<String> hand; // Player's hand of cards

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getHand() {
        return hand;
    }

    public void addCard(String card) {
        hand.add(card); // Add a card to the hand
    }

    public void playCard(String card) {
        hand.remove(card); // Remove a card from the hand
    }

    public boolean hasWon() {
        return hand.isEmpty(); // Check if the hand is empty
    }
}

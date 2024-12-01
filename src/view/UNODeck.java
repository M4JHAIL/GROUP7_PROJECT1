package view;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents the UNO deck and handles card drawing and shuffling.
 */
public class UNODeck {

    private ArrayList<String> deck; // List of cards

    public UNODeck() {
        deck = new ArrayList<>();
        String[] colors = {"Red", "Green", "Blue", "Yellow"};
        String[] values = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "Skip", "Reverse", "Draw Two"};

        // Add colored cards
        for (String color : colors) {
            for (String value : values) {
                deck.add(color + " " + value);
                if (!value.equals("0")) { // Two of each except for 0
                    deck.add(color + " " + value);
                }
            }
        }

        // Add Wild cards
        for (int i = 0; i < 4; i++) {
            deck.add("Wild");
            deck.add("Wild Draw Four");
        }

        shuffle(); // Shuffle the deck
    }

    // Shuffle the deck
    public void shuffle() {
        Collections.shuffle(deck);
    }

    // Draw a card from the deck
    public String drawCard() {
        if (deck.isEmpty()) {
            System.out.println("Deck is empty! Cannot draw a card.");
            return null;
        }
        return deck.remove(0);
    }

    // Check if the deck is empty
    public boolean isEmpty() {
        return deck.isEmpty();
    }
}

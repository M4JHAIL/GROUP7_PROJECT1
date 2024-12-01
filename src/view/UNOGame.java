package view;

import view.UNODeck;
import model.Player;
import java.util.ArrayList;

/**
 * Models the UNO game with players, a deck, and gameplay logic.
 */
public class UNOGame {

    private final String name; // Game name
    private ArrayList<Player> players; // List of players
    private UNODeck deck; // UNO deck
    private String currentCard; // Current card in play

    public UNOGame(String name) {
        this.name = name;
        players = new ArrayList<>();
        deck = new UNODeck();
    }

    // Add 4 players to the game
    public void addPlayers() {
        players.add(new Player("MANJOT SINGH"));
        players.add(new Player("GURKAMAL SINGH"));
        players.add(new Player("SEHAJDEEP KAUR"));
        players.add(new Player("GURKARAN SINGH"));
    }

    // Start the game
    public void startGame() {
        // Deal 7 cards to each player
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                player.addCard(deck.drawCard());
            }
        }

        // Draw the first card from the deck
        currentCard = deck.drawCard();
        System.out.println("Starting card: " + currentCard);

        // Handle initial "Wild" card
        if (currentCard.startsWith("Wild")) {
            currentCard = setDefaultColor(currentCard);
            System.out.println("Wild card selected. Setting current card to: " + currentCard);
        }

        // Begin gameplay
        play();
    }

    // Main game logic
    public void play() {
        boolean gameWon = false;
        int currentPlayerIndex = 0;

        while (!gameWon) {
            Player currentPlayer = players.get(currentPlayerIndex);

            System.out.println("\n" + currentPlayer.getName() + "'s turn.");
            System.out.println("Hand: " + currentPlayer.getHand());
            System.out.println("Current card: " + currentCard);

            // Try to play a matching card
            String playedCard = playMatchingCard(currentPlayer);

            if (playedCard != null) {
                currentCard = playedCard; // Update the current card
                System.out.println(currentPlayer.getName() + " played " + playedCard);

                // Handle "Wild" cards again
                if (playedCard.startsWith("Wild")) {
                    currentCard = setDefaultColor(playedCard);
                    System.out.println(currentPlayer.getName() + " set the color to: " + currentCard.split(" ")[0]);
                }
            } else {
                // Draw a card if no match is found
                String drawnCard = deck.drawCard();
                if (drawnCard != null) {
                    currentPlayer.addCard(drawnCard);
                    System.out.println(currentPlayer.getName() + " drew a card: " + drawnCard);
                }
            }

            // Check if the player has won
            if (currentPlayer.hasWon()) {
                gameWon = true;
                declareWinner(currentPlayer);
                break;
            }

            // Move to the next player
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }

    // Find a matching card to play
    private String playMatchingCard(Player player) {
        for (String card : player.getHand()) {
            // Match by color or value, or play a Wild card
            if (card.startsWith(currentCard.split(" ")[0])
                    || card.endsWith(currentCard.split(" ")[1])
                    || card.startsWith("Wild")) {
                player.playCard(card);
                return card;
            }
        }
        return null; // No match found
    }

    // Handle "Wild" cards by setting a default color
    private String setDefaultColor(String wildCard) {
        return "Red " + wildCard; // Set "Red" as the default color
    }

    // Announce the winner
    public void declareWinner(Player winner) {
        System.out.println("\n" + winner.getName() + " has won the game!");
    }
}

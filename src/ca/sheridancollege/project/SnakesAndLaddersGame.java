package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * A class that models the Snakes and Ladders game.
 * This game has 4 players and a board.
 *
 * @author Gurkaran,Manjot,Gurkamal,Sehajdeep
 * @date October 2024
 */
public class SnakesAndLaddersGame {

    private final String name; 
    private ArrayList<Player> players; 
    private SnakesAndLaddersBoard board; 

    public SnakesAndLaddersGame(String name) {
        this.name = name;
        players = new ArrayList<>();
        board = new SnakesAndLaddersBoard();
    }

 
    public void addPlayers() {
        players.add(new Player("MANJOT SINGH"));
        players.add(new Player("GURKAMAL SINGH"));
        players.add(new Player("SEHAJDEEP KAUR"));
        players.add(new Player("GURKARAN SINGH"));
    }

   
    public void play() {
        boolean gameWon = false;
        while (!gameWon) {
            for (Player player : players) {
                player.play(); 
                int newPosition = board.checkPosition(player.getPosition()); 
                player.setPosition(newPosition);
                System.out.println(player.getName() + " is now at position " + player.getPosition());

                if (player.getPosition() >= 100) {
                    gameWon = true;
                    declareWinner(player);
                    break;
                }
            }
        }
    }

    public void declareWinner(Player winner) {
        System.out.println(winner.getName() + " has won the game!");
    }
}

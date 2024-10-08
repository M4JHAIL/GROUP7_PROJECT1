package ca.sheridancollege.project;

public class SnakeGame {
    public static void main(String[] args) {
        SnakesAndLaddersGame game = new SnakesAndLaddersGame("Snakes and Ladders");
        game.addPlayers();
        game.play();
    }
}

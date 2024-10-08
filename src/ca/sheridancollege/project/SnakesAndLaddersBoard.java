package ca.sheridancollege.project;

import java.util.HashMap;

/**
 * A class that models the Snakes and Ladders board.
 * Contains the snakes and ladders positions.
 *
 * @author Gurkaran,Gurkamal,Manjot,Sehajdeep
 * @date October 2024
 */
public class SnakesAndLaddersBoard {

    private HashMap<Integer, Integer> snakesAndLadders; 
    public SnakesAndLaddersBoard() {
        snakesAndLadders = new HashMap<>();
       
        snakesAndLadders.put(3, 22);
        snakesAndLadders.put(5, 8);
        snakesAndLadders.put(11, 26);
        snakesAndLadders.put(20, 29);

       
        snakesAndLadders.put(27, 1);
        snakesAndLadders.put(21, 9);
        snakesAndLadders.put(17, 4);
    }

   
    public int checkPosition(int position) {
        if (snakesAndLadders.containsKey(position)) {
            System.out.println("Hit a snake or ladder! Moving to " + snakesAndLadders.get(position));
            return snakesAndLadders.get(position);
        }
        return position;
    }
}

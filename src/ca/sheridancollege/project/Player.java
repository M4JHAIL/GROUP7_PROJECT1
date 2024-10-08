package ca.sheridancollege.project;

/**
 * A class that models each Player in the Snakes and Ladders game. Players have a name and a position on the board.
 *
 * @author Gurkaran,Manjot,Gurkamal,Sehajdeep
 * @date October 2024
 */
public class Player {

    private String name; 
    private int position; 
   
    public Player(String name) {
        this.name = name;
        this.position = 0; 
    }

    
    public String getName() {
        return name;
    }

    
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void play() {
        
        int dieRoll = (int)(Math.random() * 6) + 1;
        System.out.println(name + " rolled a " + dieRoll);
        position += dieRoll;
    }
}

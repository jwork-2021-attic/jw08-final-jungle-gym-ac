package game;

import java.awt.Color;

import asciiPanel.AsciiPanel;

public class Player extends Creature{

    private static int playerHP= 1000;
    private static int playerDamage=100;
    private static int attackInterval= 500;//in milliseconds

    public Player(Color color,  World world) {
        super(color, AsciiPanel.playerIndex, world,playerHP,playerDamage,attackInterval);
    }
    
    public void attack(){
        
    }

    @Override 
    public void run(){
        //while()
    }
}

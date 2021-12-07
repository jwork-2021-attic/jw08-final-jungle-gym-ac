package game;
import java.awt.Color;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import asciiPanel.AsciiPanel;

public class Monster extends Creature{
    private static int monsterHP= 200;
    private static int monsterDamage=50;
    private static int attackInterval= 500;//in milliseconds
    private static int range = 5;
    Random rand=new Random();
    
    public Monster(Color color,  World world) {
        super(color, AsciiPanel.monsterIndex, world,monsterHP,monsterDamage,attackInterval);
    }
    
    @Override
    public void run() {
        try{
            while(hp>=0){
                TimeUnit.MILLISECONDS.sleep(500);
                randomWalk();
            }
        }
        catch (InterruptedException e) { System.err.println("Interrupted");  }
    }
    protected void randomWalk(){
        switch(rand.nextInt(4)){
            case 0:
                moveDown();
                break; 
            case 1:
                moveRight();
                break;
            case 2:
                moveLeft();
                break;
            case 3:
                moveRight();
                break;
        }
    }
}

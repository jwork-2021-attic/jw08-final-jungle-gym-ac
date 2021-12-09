package game;

import java.awt.Color;

import asciiPanel.AsciiPanel;
import game.item.Bow;
import game.item.Wand;
import game.item.Weapon;

public class Player extends Creature{

    public Weapon weapon;
    private static int playerHP= 1000;
    private static int playerDamage=100;
    private static int playerRange=8;
    private static int attackInterval= 500;//in milliseconds    

    public static final int ARCHER=(int)AsciiPanel.archerIndex;
    public static final int WIZARD=(int)AsciiPanel.wizardIndex;

    public Player(World world,int playerType) {
        super((char)playerType, world,playerHP,playerDamage,attackInterval);
        world.put(this,world.map.getStartX(),world.map.getStartY());

        switch(playerType){
            case ARCHER:
                weapon=new Bow(world,this,playerDamage,playerRange);
                break;
            case WIZARD:
                weapon=new Wand(world,this,playerDamage,playerRange);
                break;
        }
    }
    
    public void attack(){

    }

    @Override
    public void moveUp(){
        super.moveUp();
        weapon.directionUp();
    }

    @Override
    public void moveDown(){
        super.moveDown();
        weapon.directionDown();
    }

    @Override
    public void moveLeft() {
        super.moveLeft();
        weapon.directionLeft();
    }

    @Override
    public void moveRight() {
        super.moveRight();
        weapon.directionRight();
    }

    @Override 
    public void run(){
        //while(hp>0);
    }
}

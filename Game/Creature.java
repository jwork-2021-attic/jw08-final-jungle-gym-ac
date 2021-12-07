package game;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

public class Creature extends Thing implements Runnable{

    protected int hp,damage;
    private boolean cooling=false;
    private int attackInterval;//in milliseconds

    Creature(Color color, char glyph, World world,int hp,int damage,int attackInterval) {
        super(color, glyph, world);
        this.hp=hp;
        this.damage=damage;
        attackInterval=attackInterval;
    }

    public void moveUp() {
        if(getY()>0 && ( world.get(getX(),getY()-1) instanceof Nothing )){
            if(world.put(this,getX(),getY()-1)){
                world.empty(getX(),getY()+1);
            }
        }
    }
    public void moveDown(){
        if(getY()<World.HEIGHT-1 && ( world.get(getX(),getY()+1) instanceof Nothing )){
            if(world.put(this,getX(),getY()+1)){
                world.empty(getX(),getY()-1);
            }
        }
    }
    public void moveLeft(){
        if(getX()>0 && ( world.get(getX()-1,getY()) instanceof Nothing )){
            if(world.put(this,getX()-1,getY())){
                world.empty(getX()+1,getY());
            }
        }
    }
    public void moveRight(){
        if(getX()<World.WIDTH-1 && ( world.get(getX()+1,getY()) instanceof Nothing )){
            if(world.put(this,getX()+1,getY())){
                world.empty(getX()-1,getY());
            }
        }
    }
    
    @Override
    public void run() {        
    }

    public int getDamage() {
        return damage;
    }

    public int getHp() {
        return hp;
    }

    public void gethurt(int damage){
        hp-=damage;
    }

    public void attackCooling(){
        cooling=true;
        TimerTask task = new TimerTask() {
            public void run() {
                cooling=false;
            }
        };
        new Timer().schedule(task, attackInterval);;
    }
}

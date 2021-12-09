package game.bullet;

import game.Thing;
import game.World;

public class Bullet extends Thing{
    protected int damage,direction;
    Bullet(char glyph, World world, int damage,int direction){
        super(glyph,world);
        this.damage=damage;
        this.direction=direction;
    }
}

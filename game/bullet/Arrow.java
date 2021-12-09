package game.bullet;

import game.World;

public class Arrow extends Bullet{
    public Arrow(char glyph, World world, int damage,int direction){
        super(glyph, world, damage, direction);
    }
}

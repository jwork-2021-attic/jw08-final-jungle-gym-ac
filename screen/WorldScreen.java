package screen;

import java.awt.Color;
import java.awt.event.KeyEvent;

import Game.Calabash;
import Game.Floor;
import Game.WalkedFloor;
import Game.World;
import asciiPanel.AsciiPanel;

public class WorldScreen extends Screen {

    private World world;
    private Calabash bro;

    /**
     * @param terminal
     */
    public WorldScreen(AsciiPanel terminal) {
        super(terminal);

        world = new World();
        bro = new Calabash(Color.green,world);
        world.put(bro, world.maze.getStartX(), world.maze.getStartY());
        
        //displayOutput();
        //terminal.repaint();
    }

    @Override
    public void displayOutput() {
        for (int x = 0; x < World.WIDTH; x++) {
            for (int y = 0; y < World.HEIGHT; y++) {
                terminal.write(world.get(x, y).getGlyph(), x, y, world.get(x, y).getColor());
            }
        }
    }

    int i = 0;

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if(bro.getX()>0 && ( world.get(bro.getX()-1, bro.getY()) instanceof Floor) ){
                    world.put(new WalkedFloor(world),bro.getX(),bro.getY());
                    bro.moveTo(bro.getX()-1, bro.getY());
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(bro.getX()<World.WIDTH-1 && ( world.get(bro.getX()+1, bro.getY()) instanceof Floor) ){
                    world.put(new WalkedFloor(world),bro.getX(),bro.getY());
                    bro.moveTo(bro.getX()+1, bro.getY());
                }
                break;
            case KeyEvent.VK_UP:
                if(bro.getY()>0 && ( world.get(bro.getX(), bro.getY()-1) instanceof Floor)){
                    world.put(new WalkedFloor(world),bro.getX(),bro.getY());
                    bro.moveTo(bro.getX(), bro.getY()-1);
                }
                break;
            case KeyEvent.VK_DOWN:
                if(bro.getY()<World.HEIGHT+1 && ( world.get(bro.getX(), bro.getY()+1) instanceof Floor)){
                    world.put(new WalkedFloor(world),bro.getX(),bro.getY());
                    bro.moveTo(bro.getX(), bro.getY()+1);
                }
                break;
        }
    
        if(world.maze.getEndX()==bro.getX()&& world.maze.getEndY()==bro.getY()){
            return new RestartScreen(terminal);
        }
        return this;
    }
}
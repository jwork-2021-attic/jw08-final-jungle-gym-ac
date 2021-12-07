package screen;

import java.awt.Color;
import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;
import game.Nothing;
import game.Player;
import game.World;

public class WorldScreen extends Screen {

    private World world;
    private Player player;
    //private Color worldBackgroundColor=;

    /**
     * @param terminal
     */
    public WorldScreen(AsciiPanel terminal) {
        super(terminal);
        world = new World();
        player=world.player;
        //player = new Player(Color.green,world);
        //world.put(player, world.map.getStartX(), world.map.getStartY());
        
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
        //System.out.println("a");
        switch (key.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                player.moveLeft();;
                break;
            case KeyEvent.VK_RIGHT:
                player.moveRight();
                break;
            case KeyEvent.VK_UP:
                player.moveUp();
                break;
            case KeyEvent.VK_DOWN:
                player.moveDown();
                break;
            default:
                break;
        }
        
        if(world.map.getEndX()==player.getX()&& world.map.getEndY()==player.getY())
            return new RestartScreen(terminal);
        else return this;
    
    }
}
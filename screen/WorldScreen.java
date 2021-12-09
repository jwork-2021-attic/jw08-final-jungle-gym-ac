package screen;

import java.awt.Color;
import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;
import game.Nothing;
import game.Player;
import game.World;
import mainWindow.MainWindow;

public class WorldScreen extends Screen {

    private World world;
    private Player player;
    //private Color worldBackgroundColor=;

    /**
     * @param terminal
     */
    public WorldScreen(AsciiPanel terminal,int playerType) {
        super(terminal,AsciiPanel.floorIndex);

        world = new World(playerType);
        player=world.player;
        //player = new Player(Color.green,world);
        //world.put(player, world.map.getStartX(), world.map.getStartY());
        
        //displayOutput();
        //terminal.repaint();
    }

    @Override
    public void displayOutput() {
        //The GAME area
        for (int x = 0; x < world.WIDTH; x++) {
            for (int y = 0; y < world.HEIGHT; y++) {
                terminal.write(world.get(x, y).getGlyph(), x, y, AsciiPanel.white);  //color unnecessary
            }
        }
        if(world.monsterNumberLeft==0)
            terminal.write(AsciiPanel.endPointOpenIndex,world.map.getEndX(),world.map.getEndY());
        else{ //终点出现了就不显示武器了
            if(player.weapon.isVisible()){
                terminal.write(player.weapon.getGlyph(),player.weapon.getX(),player.weapon.getY(),AsciiPanel.white);
            }  
        }
        //the STAT area
        for(int x=world.WIDTH;x<MainWindow.width;x++)
            for(int y=0;y<MainWindow.height;y++){
                terminal.write((char)0,x,y,AsciiPanel.white);
            }
        terminal.write("Your HP: "+Integer.toString(world.player.getHp()),world.WIDTH+2,1);
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
        if(player.getHp()==0)
            return new RestartScreen(terminal,RestartScreen.lose);
        else if(world.map.getEndX()==player.getX()&& world.map.getEndY()==player.getY() && world.monsterNumberLeft==0)
            return new RestartScreen(terminal,RestartScreen.win);
        else return this;
    }
}
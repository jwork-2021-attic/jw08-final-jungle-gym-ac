package MainWindow;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

import javax.swing.JFrame;

import Game.World;
import UI.UIPainter;
import asciiPanel.AsciiFont;
import asciiPanel.AsciiPanel;
import screen.Screen;
import screen.StartScreen;

/**
 * The Main Window class of the game 
 */
public class MainWindow extends JFrame implements KeyListener {  

    private AsciiPanel terminal;
    private Screen screen;
    private UIPainter uiPainter;
    private Timer uiTimer;

    public MainWindow() {
        super();
    //create AsciiPanel,add as a component
        terminal = new AsciiPanel(World.WIDTH, World.HEIGHT, AsciiFont.TALRYTH_15_15);   //defaultBackgroundColor = black;defaultForegroundColor = white;
        add(terminal);
        pack();

    //Screen
        screen = new StartScreen(terminal);  //开始屏幕
        //uiPainter.refresh();

    //keyListener
        addKeyListener(this);
        //TODO:implement a KeyListener's SubClass instead of mixing KeyListner and Main Function Together 
        //change addKeyListener(this) to addKeyListener(.....)

    //UIPainter
        uiPainter=new UIPainter(this);
        uiTimer=new Timer();
        uiTimer.scheduleAtFixedRate(uiPainter, 0,100);    
    }

    
    @Override
    public void repaint() {
        //terminal.clear();
        screen.displayOutput();
        super.repaint();
    }


    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        screen = screen.respondToUserInput(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        MainWindow app = new MainWindow();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

}

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import com.anish.calabashbros.World;
import com.anish.screen.Screen;
import com.anish.screen.StartScreen;

import asciiPanel.AsciiFont;
import asciiPanel.AsciiPanel;

public class Main extends JFrame implements KeyListener {  //继承KeyListener

    private AsciiPanel terminal;
    private Screen screen;

    public Main() {
        super();
        terminal = new AsciiPanel(World.WIDTH, World.HEIGHT, AsciiFont.TALRYTH_15_15);   //字体大小设置
        add(terminal);
        pack();
        screen = new StartScreen();  //开始屏幕
        addKeyListener(this);
        repaint();

    }

    @Override
    public void repaint() {           //刷新UI,合时调用减少刷新率？
        terminal.clear();
        screen.displayOutput(terminal);    //画图
        super.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        screen = screen.respondToUserInput(e);
        repaint();                                 //这里repaint！！
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        Main app = new Main();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

}

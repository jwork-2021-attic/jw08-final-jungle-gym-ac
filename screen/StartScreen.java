package screen;

import asciiPanel.AsciiPanel;
import game.World;

public class StartScreen extends RestartScreen {

    public StartScreen(AsciiPanel terminal){
        super(terminal);
    }
    @Override
    public void displayOutput() {
        //TODO:画大的游戏标题
        //规则说明：图标+文字，不同颜色
        //for(int i=0;i<10;i++)        //可以有一排图形，更好看
            //terminal.write((char)i,10,10+i);
        
        //terminal.write("This is the start screen.", World.WIDTH/2-15, World.HEIGHT/2-1);
        //terminal.write("Press ENTER to continue...",World.WIDTH/2-15, World.HEIGHT/2+1);
    }

}

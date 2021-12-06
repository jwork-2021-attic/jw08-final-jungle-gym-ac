package com.anish.screen;

import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;
import java.util.HashMap;
//import java.util.ArrayList;

import com.anish.calabashbros.World;

public class RestartScreen implements Screen{
    
    private int num_of_lines=3;
    private HashMap<String,String> MessageList=new HashMap<String,String>();
      
    
    
    @Override
    public void displayOutput(AsciiPanel terminal){
        terminal.clear(' ',AsciiPanel.white,AsciiPanel.white);
        int i=0;
        for(String Message:MessageList.values()){
            terminal.writeCenter(Message,(World.HEIGHT-num_of_lines)/2+i*2,AsciiPanel.green,AsciiPanel.white);
            i+=1;
        }
    }
        

        //terminal.write(win_message,(World.WIDTH-win_message.length())/2, (World.HEIGHT-num_of_lines)/2);
        //terminal.write(continue_message,(World.WIDTH-continue_message.length())/2, (World.HEIGHT-num_of_lines)/2+1);
        //terminal.write(exit_message,(World.WIDTH-exit_message.length())/2, (World.HEIGHT-num_of_lines)/2+2);
    public RestartScreen(){
        MessageList.put("win_message", "You WIN!!! Congratulations!");
        MessageList.put("lose_message", "You LOSE!!! Don't give up!");
        MessageList.put("continue_message", "Press ENTER to challenge new RANDOM Maze...");
        MessageList.put("exit_message", "CLOSE the terminal to EXIT...");
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                return new WorldScreen();
            default:
                return this;
        }
    }
}

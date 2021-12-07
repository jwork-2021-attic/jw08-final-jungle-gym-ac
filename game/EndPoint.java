package game;

import java.awt.Color;

import asciiPanel.AsciiPanel;

public class EndPoint extends Thing{
    EndPoint(World world){
        super(Color.red,AsciiPanel.endPointOpenIndex,world);
    }
}
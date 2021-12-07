package game;


import asciiPanel.AsciiPanel;

public class Wall extends Thing {

    Wall(World world) {
        super(AsciiPanel.green, (char) (AsciiPanel.wallIndex), world);
    }

}

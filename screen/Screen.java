package screen;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

/**
 *
 * Abstract Class
 * 
 */
public abstract class Screen{
    AsciiPanel terminal;

    /**
     * @param terminal
     */
    public Screen(AsciiPanel terminal,char backgroundImageIndex) {
        this.terminal=terminal;
        terminal.backgroundImageIndex=backgroundImageIndex;
    }

    /**
     * Modify 2D arrays in AsciiPanel
     */
    abstract public void displayOutput();

    abstract public Screen respondToUserInput(KeyEvent key);
}

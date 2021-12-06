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
    public Screen(AsciiPanel terminal) {
        this.terminal=terminal;
    }

    /**
     * Modify 2D arrays in AsciiPanel
     */
    abstract public void displayOutput();

    abstract public Screen respondToUserInput(KeyEvent key);
}

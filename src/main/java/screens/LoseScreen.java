package screens;

import java.awt.Color;
import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class LoseScreen implements Screen {

    public void displayOutPut(AsciiPanel terminal) {
        terminal.write("You lost.", 35,10,Color.RED);
        terminal.writeCenter("-- press [enter] to restart --", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
    	if(key.getKeyCode()== KeyEvent.VK_ENTER)
    	{
    		return new StartScreen();
    	}
    	else return this;
    }

}
package screens;

import java.awt.Color;
import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class WinScreen implements Screen {

    public void displayOutPut(AsciiPanel terminal) {
        terminal.write("You won.", 35, 10,Color.GREEN);
        terminal.writeCenter("-- press [enter] to restart --", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
        return new PlayScreen();
    }
}
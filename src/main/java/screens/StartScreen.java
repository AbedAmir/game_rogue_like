package screens;

import java.awt.Color;
import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class StartScreen implements Screen {

	public void displayOutPut(AsciiPanel terminal) {
		terminal.write("Bienvenu jeune aventurier !",25,7);
		terminal.writeCenter("Appuyer sur [entree] pour commencer", 23, Color.blue);
	}

	public Screen respondToUserInput(KeyEvent key) {
		if(key.getKeyCode() == KeyEvent.VK_ENTER)
		{
			return new ChoiceChampion();
		}
		else 
		{
			return this;
		}
	}
}

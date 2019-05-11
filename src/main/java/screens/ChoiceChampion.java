package screens;

import java.awt.Color;
import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class ChoiceChampion implements Screen{

	public static int code;
	@Override
	public void displayOutPut(AsciiPanel terminal) {
		terminal.writeCenter("Choisir un personnage !",4,Color.blue);
		terminal.write("Humain", 22, 7);
		terminal.write("100 Vie", 21, 9);
		terminal.write("50 Attaque", 20, 10);
		for(int i = 7; i < 16; i++)
		{
			terminal.write("|", 31, i);
			terminal.write("|", 44, i);
			terminal.write("|", 18, i);
			terminal.write("|", 57, i);
		}
		for(int i = 18; i < 58;i++)
		{
			terminal.write("-", i, 8);
			terminal.write("-", i, 6);
			terminal.write("-", i, 13);
			terminal.write("-", i, 15);
		}
		terminal.write("Zombie", 35, 7);
		terminal.write("250 Vie", 34, 9);
		terminal.write("15 Attaque", 33, 10);
		terminal.write("Alien", 49, 7);
		terminal.write("50 Vie",48 , 9);
		terminal.write("90 Attaque", 46, 10);
		terminal.write("H", 25, 14);
		terminal.write("Z",38 , 14);
		terminal.write("A", 51, 14);
		terminal.writeCenter("Appuyer sur [H] ou [Z] ou [A]", 22,Color.blue);
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		switch (key.getKeyCode()) {

		case KeyEvent.VK_H:
			code=1;
			return new PlayScreen();
		case KeyEvent.VK_Z:
			code=2;
			return new PlayScreen();
		case KeyEvent.VK_A:
			code=3;
			return new PlayScreen();
		default:
			break;
		}
		return this;
	}

}

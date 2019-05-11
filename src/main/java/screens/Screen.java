package screens;
import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;
public interface Screen {
	public void displayOutPut(AsciiPanel terminal);
	public Screen respondToUserInput(KeyEvent key);
}

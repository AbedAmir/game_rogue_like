package uvsq.projet;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import screens.*;
import asciiPanel.AsciiPanel;

public class ApplicationMain extends JFrame {
	private static final long serialVersionUID = 1060623638149583738L;

	private AsciiPanel terminal;
	private Screen screen;
	public ApplicationMain(){
		super();
		terminal = new AsciiPanel();
		add(terminal);
		pack();
		screen = new StartScreen();
		addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent e) {
				
			}
			
			public void keyReleased(KeyEvent e) {
				
			}
			
			public void keyPressed(KeyEvent e) {
				screen=screen.respondToUserInput(e);
				repaint();
			}
		});
		repaint();
	}
	public void repaint(){
		terminal.clear();
		screen.displayOutPut(terminal);
		super.repaint();
	}
	public void keyPressed(KeyEvent e) {
		screen = screen.respondToUserInput(e);
		repaint();
	}
	public void keyReleased(KeyEvent e) { }
	public static void main(String[] args) {
		ApplicationMain app = new ApplicationMain();
		app.setTitle("Rogue");
		app.setLocationRelativeTo(null);//mettre le jframe au centre
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setResizable(false);
		//app.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		app.setVisible(true);
	}
}
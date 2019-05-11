package uvsq.projet;

import java.awt.Color;

import asciiPanel.AsciiPanel;

public enum Tile {
	FLOOR('.', Color.WHITE),
    WALL((char)35, AsciiPanel.blue),
    BOUNDS((char)33, AsciiPanel.brightBlack); // pour definir les cases hors limite du jeu 
	private char glyph;
	private Color color;
	public char glyph()
	{
		return glyph;
	}
	public Color color()
	{
		return color;
	}
	Tile(char glyph, Color color)
	{
		this.glyph=glyph;
		this.color=color;
	}
	public boolean isWall() {
	    return this == Tile.WALL;
	}
	
	/**verif si la case n'est pas un mur et qu'elle fait bien partie de notre zone de jeu
	 * @return
	 */
	public boolean isGround() {
	    return this != WALL && this != BOUNDS;
	}

	
}

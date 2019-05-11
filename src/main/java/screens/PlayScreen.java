package screens;


import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import asciiPanel.AsciiPanel;
import uvsq.projet.*;
public class PlayScreen implements Screen {
	private World world;
	boolean levelUp;
	private int screenWidth;
	private int screenHeight;
	Creature player;
	private List<String> messages;

	public PlayScreen(){
		messages = new ArrayList<String>();
		screenWidth = 80;// La longeur de notre zone de jeu
		screenHeight = 21;// la largeur de notre zone de jeu
		messages = new ArrayList<String>();
		createWorld();

		CreatureFactory creatureFactory = new CreatureFactory(world);
		createCreatures(creatureFactory);
	}
	public void displayOutPut(AsciiPanel terminal) {
		int left = getScrollX();
		int top = getScrollY();
		displayTiles(terminal, left, top);
		displayMessages(terminal, messages);
		terminal.write(player.glyph(), player.x - left, player.y - top, player.color());
		for(int i=0;i<79;i++)
		{
			terminal.write("-", i, 22,Color.ORANGE);
		}
		String score = String.format("Score %2d ", player.monsterKill);
		terminal.write(score , 35, 23);
		String healPoint = String.format("%3d/%1d Vie", player.hp(),player.maxHp());
		terminal.write(healPoint, 1, 23);
		String level = String.format("Level%2d ", player.getLevel());
		terminal.write(level,70,23);

	}

	public Screen respondToUserInput(KeyEvent key) {
		switch (key.getKeyCode()) {
		case KeyEvent.VK_G: 
			Creature t=world.verifPlayerOnPotion(player);
			if(world.verifPlayerOnPotion(player) != null)
			{
				if((player.hp()+t.hp() > player.maxHp()))
				{
					player.setHp(player.maxHp());
				}
				else 
				{
					player.setHp(this.player.hp() + t.hp());
				}
				world.remove(world.verifPlayerOnPotion(player));
			}
			break;

		case KeyEvent.VK_ENTER: return new WinScreen();
		case KeyEvent.VK_ESCAPE: return new LoseScreen();
		case KeyEvent.VK_LEFT:
			player.moveBy(-1, 0); 
			world.monsterMove();
			if(verifHpPlayer(player) == true)
			{
				return new LoseScreen();
			}
			break;
		case KeyEvent.VK_RIGHT:
			player.moveBy(1, 0);
			world.monsterMove();
			if(verifHpPlayer(player) == true)
			{
				return new LoseScreen();
			}
			break;
		case KeyEvent.VK_UP:
			player.moveBy( 0,-1);
			
			world.monsterMove();
			if(verifHpPlayer(player) == true)
			{
				return new LoseScreen();
			}
			break;
		case KeyEvent.VK_DOWN:
			player.moveBy( 0, 1);
			world.monsterMove();
			if(verifHpPlayer(player) == true)
			{
				return new LoseScreen();
			}
			break;
		default:
			break;
		}
		return this;
	}

	/**Creation du Player et des Monstres
	 * @param creatureFactory
	 */
	private void createCreatures(CreatureFactory creatureFactory){
		player = creatureFactory.newPlayer(messages);
		for (int i = 0; i < 10; i++){
			creatureFactory.newPNJ();
		}
		for (int i = 0; i < 20; i++){
			creatureFactory.newFungus();
			creatureFactory.newDragon();
		}

		for (int i = 0; i < 15; i++){
			creatureFactory.newPotionVie();
		}
	} 

	private void createWorld(){
		world = new WorldBuilder(90, 31)
				.makeCaves()
				.build();
	}

	public int getScrollX() {
		return Math.max(0, Math.min(player.x - screenWidth / 2, world.width() - screenWidth));
	}

	public int getScrollY() {
		return Math.max(0, Math.min(player.y - screenHeight / 2, world.height() - screenHeight));
	}

	private void displayTiles(AsciiPanel terminal, int left, int top) {
		for (int x = 0; x < screenWidth; x++){
			for (int y = 0; y < screenHeight; y++){
				int wx = x + left;
				int wy = y + top;
				Creature creature = world.creature(wx, wy);
				if (creature != null)
				{
					terminal.write(creature.glyph(), creature.x - left, creature.y - top, creature.color());

				}
				else
				{
					terminal.write(world.glyph(wx, wy), x, y, world.color(wx, wy));
				}
			}
		}
	}
	/**Affiche les messages pendant le jeu
	 * @param terminal
	 * @param messages
	 */
	private void displayMessages(AsciiPanel terminal, List<String> messages) {
		int top = screenHeight - messages.size();
		for (int i = 0; i < messages.size(); i++){
			terminal.writeCenter(messages.get(i), top + i);
		}
		messages.clear();
	}
	private boolean verifHpPlayer(Creature player)
	{
		if(player.hp()<1)
		{
			return true;
		}
		return false;
	}
}

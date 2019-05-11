package uvsq.projet;

import java.util.List;

public class PlayerAI extends CreatureAi {
	public List<String> messages;

	
	public PlayerAI(Creature creature, List<String> messages) {
		super(creature);
		this.messages = messages;
	}

	public void onEnter(int x, int y, Tile tile){
		if (tile.isGround()){
			creature.x = x;
			creature.y = y;
		} else if (tile.isWall()) {
			creature.dig(x, y);
		}
	}
	public void onNotify(String message){
		messages.add(message);
	}
}
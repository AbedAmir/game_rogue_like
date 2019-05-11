package uvsq.projet;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class World {
	private Tile[][] tiles;
	private int width;
	private int height;
	private List<Creature> creatures;
	private List<Creature> potions;
	private List<Creature> pnjs;
	public boolean verifTestAddEmpty=false;
	public int width() { return width; }

	public int height() { return height; }

	public World(Tile[][] tiles){
		this.tiles = tiles;
		this.width = tiles.length;
		this.height = tiles[0].length;
		this.creatures = new ArrayList<Creature>();
		this.potions= new ArrayList<Creature>();
		this.pnjs= new ArrayList<Creature>();
	}
	/**Verif si y'a une creature dans la case(x,y)
	 * @param x
	 * @param y
	 * @return
	 */
	public Creature creature(int x, int y){
		for (Creature c : creatures){
			if (c.x == x && c.y == y)
				return c;
		}
		for (Creature c : potions){
			if (c.x == x && c.y == y)
				return c;
		}
		for (Creature c : pnjs){
			if (c.x == x && c.y == y)
				return c;
		}
		return null;
	}

	/**Test si la case(x,y) fait partie de la MAP
	 * @param x
	 * @param y
	 * @return
	 */
	public Tile tile(int x, int y){
		if (x< 0 || x >= width || y< 0 || y >= height)
			return Tile.BOUNDS;
		else
			return tiles[x][y];
	}

	public char glyph(int x, int y){
		return tile(x, y).glyph();
	}

	public Color color(int x, int y){
		return tile(x, y).color();
	}

	public void addAtEmptyLocation(Creature creature){
		int x;
		int y;
		do {
			x = (int)(Math.random() * width);
			y = (int)(Math.random() * height);
		} 
		while (!tile(x,y).isGround() || creature(x,y) != null);
		verifTestAddEmpty=true;
		creature.x = x;
		creature.y = y;
		if(creature.type_creature==3)
		{
			potions.add(creature);
		}
		else if(creature.type_creature==4)
		{
			pnjs.add(creature);
		}
		else 
		{
			creatures.add(creature);
		}


	}

	/**Supprime la creature de la map
	 * @param other
	 */
	public void remove(Creature other) {
		if(other.type_creature == 2)
		{
			creatures.remove(other);
		}
		else 
			if(other.type_creature == 3)
			{
				potions.remove(other);
				other.doAction("give you 20 hp");
			}

	}

	/**on test si le player ce trouve sur une potion
	 * @param player
	 * @return
	 */
	public Creature verifPlayerOnPotion(Creature player) { 

		for(Creature c:potions)
		{
			if((player.x == c.x && player.y == c.y))
			{
				return c;
			}
		}
		return null;
	}

	public List<Creature> getCreatures() {
		return creatures;
	}

	
	/**Bouge les monstres sur la map 
	 * 
	 */
	public void monsterMove() {
		int w,x,y,z,a,b;
		for (Creature c: creatures)
		{
			if(c.type_creature == 2)
			{
				do {
					w = (int)(Math.random()*(2-0));
					x = (int)(Math.random()*(2-0));
					y = (int)(Math.random()*(2-0));
					z = (int)(Math.random()*(2-0));
					a = w - x;
					b = y - z;
				} 
				while (!tile(c.x+a,c.y+b).isGround() || creature(c.x+a,c.y+b) != null);
				a = w - x;
				b = y - z;
				c.x = c.x + a;
				c.y = c.y + b;

			}
		}
		if(monsterNearPlayer() != null) //Le monstre attaque le joueur
		{
			Creature monster = monsterNearPlayer();
			Creature player = monsterNearPlayer();
			for(Creature cc: creatures)
			{
				if(cc.type_creature == 1)
				{
					player=cc;
				}
			}
			player.monsterAttackPlayer(monster);
		}
	}
	/**On test si y'a un monstre a coté du player
	 * @return
	 */
	public Creature monsterNearPlayer() {
		Creature c = null;
		for(Creature cc: creatures)
		{
			if(cc.type_creature == 1)
			{
				c=cc;
			}
		}
		for(Creature t : creatures)
		{
			if(t.type_creature ==2 )
			{
				if(((c.x) == (t.x+1)) && ((c.y) == (t.y)))
				{
					return t;
				}
				else if(((c.x) == (t.x-1)) && ((c.y) == (t.y)))
				{
					return t;
				}
				else if(((c.x) == (t.x)) && ((c.y) == (t.y+1)))
				{
					return t;
				}
				else if(((c.x) == (t.x)) && ((c.y) == (t.y-1)))
				{
					return t;
				}
			}
		}
		return null;
	}
}

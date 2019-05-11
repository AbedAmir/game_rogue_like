package uvsq.projet;

import java.awt.Color;

public class Creature {
	private World world;

	public int x;
	public int y;
	public int type_creature; //1=player; 2=monstre; 3=potion; 4=pnj;
	public int level;
	public int monsterKill;
	private Color color;
	private char glyph;
	private CreatureAi ai;
	private int maxHp;
	private int hp;
	public char glyph() { return glyph; }
	public Color color() { return color; }
	public void setCreatureAi(CreatureAi ai) { this.ai = ai; }
	public int maxHp() { return maxHp; }
	public int hp() { return hp; }
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	private int attackValue;
	public int attackValue() { return attackValue; }

	private int defenseValue;
	public int defenseValue() { return defenseValue; }

	public Creature(World world, char glyph, Color color, int hp, int attack, int type, int level,int monsterKill){
		this.world = world;
		this.glyph = glyph;
		this.color = color;
		this.hp = hp;
		this.maxHp = hp;
		this.attackValue = attack;
		this.type_creature = type;
		this.level = level;
		this.monsterKill = monsterKill;
	}



	/**
	 * Deplace le joueur. 
	 * @param mx Deplacement sur x.
	 * @param my Deplacement sur y.
	 */
	public void moveBy(int mx, int my){
		Creature other = world.creature(x + mx, y + my);
		if (other == null)
		{
			ai.onEnter(x+mx, y+my, world.tile(x + mx, y + my));
		}
		else
			if(other.type_creature == 2)
			{
				attack(other);
			}
			else if(other.type_creature == 3)
			{
				ai.onEnter(x+mx, y+my, world.tile(x + mx, y + my));
				doAction("You find heal potion");
				doAction("You can press [G] to take it");
			}
			else
			{
				ai.onEnter(x+mx, y+my, world.tile(x + mx, y + my));
				int i =(int)(Math.random()*3);
				switch (i) {
				case 0:
					doAction("You can do it !");
					break;
				case 1:
					doAction("Keep continue !");
					break;
				case 2:
					doAction("Take care !");
					break;
				default:
					break;
				}

			}

	}

	public void attack(Creature other){
		int amount = (int)(Math.random() * this.attackValue()) + 1; //On ajoute +1 car pour qu'il attaque pas avec 0 dmg "fonction random"
		doAction("You attack the '%s' for %d damage", other.glyph, amount);
		int dmg = (int)(Math.random() * other.attackValue()) + 1;
		this.hp = hp - dmg;
		doAction("'%s' attack you with %d damage", other.glyph, dmg);
		if(other.modifyHp(amount) == true)
		{
			if(other.attackValue() == 20)
			{
				this.monsterKill = this.monsterKill + 2;
			}
			else 
			{
				this.monsterKill++;
			}

			this.level = ((int)(this.monsterKill/5)) + 1;

		}
		other.modifyHp(amount);

	}

	/**modifi les PV des monstres
	 * @param amount
	 * @return
	 */
	public boolean modifyHp(int amount) { 
		hp = hp-amount;

		if (hp < 1) {
			doAction("die");
			world.remove(this);
			return true;
		}
		return false;
	}

	public void dig(int wx, int wy) {
		doAction("You can't dig");
	}

	public void update(){
		ai.onUpdate();
	}

	/** return true si le player peut se deplacer sur la case
	 * @param wx
	 * @param wy
	 * @return
	 */
	public boolean canEnter(int wx, int wy) {
		return world.tile(wx, wy).isGround() && world.creature(wx, wy) == null;
	}

	public void notify(String message, Object ... params){
		ai.onNotify(String.format(message, params));
	}

	public void doAction(String message, Object ... params){
		int r = 9;
		for (int ox = -r; ox < r+1; ox++){
			for (int oy = -r; oy < r+1; oy++){
				if (ox*ox + oy*oy > r*r)
					continue;

				Creature other = world.creature(x+ox, y+oy);

				if (other == null)
					continue;

				if (other == this)
					other.notify(message + ".", params);
				else
					other.notify(String.format("The '%s' %s.", glyph, makeSecondPerson(message)), params);
			}
		}
	}

	private String makeSecondPerson(String text){
		String[] words = text.split(" ");
		words[0] = words[0] + "s";

		StringBuilder builder = new StringBuilder();
		for (String word : words){
			builder.append(" ");
			builder.append(word);
		}

		return builder.toString().trim();
	}
	/**Modifi les PV du player lorsque le monstre l'attaque
	 * @param other
	 */
	public void monsterAttackPlayer(Creature other){
		int dmg= (int)(Math.random() * other.attackValue()) + 1;
		doAction("'%s' attack you with %d damage", other.glyph, dmg);
		this.modifyHp(dmg);
	}
}

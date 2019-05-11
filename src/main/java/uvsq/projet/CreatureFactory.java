package uvsq.projet;

import java.awt.Color;
import java.util.List;

import screens.ChoiceChampion;


public class CreatureFactory {
	private World world;

	public CreatureFactory(World world){
		this.world = world;
	}

	/**
	 * @param messages
	 * @param code 1=Humain; 2= Zombie; 3=Alien;
	 * @return
	 */
	public Creature newPlayer(List<String> messages){
		Creature player;
		if(ChoiceChampion.code == 1)
		{
			player = new Creature(world, 'H', Color.GREEN, 100, 50,1,1,0);
		}
		else if(ChoiceChampion.code == 2)
		{
			player = new Creature(world, 'Z', Color.GREEN,250 , 15,1,1,0);
		}
		else 
		{
			player = new Creature(world, 'A', Color.GREEN, 50, 90,1,1,0);
		}
		world.addAtEmptyLocation(player);
		new PlayerAI(player, messages);
		return player;
	}
	public Creature newFungus(){
		Creature fungus = new Creature(world, 'f', Color.ORANGE, 10, 10,2,0,0);
		world.addAtEmptyLocation(fungus);
		new FungusAi(fungus, this);
		return fungus;
	}
	public Creature newDragon(){
		Creature dragon = new Creature(world, 'D', Color.RED, 20, 20,2,0,0);
		world.addAtEmptyLocation(dragon);
		new DragonAi(dragon, this);
		return dragon;
	}
	public Creature newPotionVie(){
		Creature potionVie = new Creature(world, 'V', Color.CYAN, 20, 0,3,0,0);
		world.addAtEmptyLocation(potionVie);
		new PotionVie(potionVie,this);
		return potionVie;
	}
	public Creature newPNJ(){
		Creature pnj = new Creature(world, 'P',Color.MAGENTA, 0, 0,4,0,0);
		world.addAtEmptyLocation(pnj);
		new PNJ(pnj,this);
		return pnj;
	}
}

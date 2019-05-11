package uvsq.projet;

public class DragonAi extends CreatureAi{
	@SuppressWarnings("unused")
	private CreatureFactory factory;
	
	public DragonAi(Creature creature, CreatureFactory factory) {
		super(creature);
		this.factory = factory;
	}
}

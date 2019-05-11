package uvsq.projet;


public class FungusAi extends CreatureAi {
	@SuppressWarnings("unused")
	private CreatureFactory factory;
	
	public FungusAi(Creature creature, CreatureFactory factory) {
		super(creature);
		this.factory = factory;
	}
}

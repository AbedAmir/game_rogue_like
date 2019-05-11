package uvsq.projet;

public class PNJ extends CreatureAi{
	@SuppressWarnings("unused")
	private CreatureFactory factory;
	public PNJ(Creature creature,CreatureFactory factory) {
		super(creature);
		this.factory = factory;
	}
}

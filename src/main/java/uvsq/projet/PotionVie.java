package uvsq.projet;

public class PotionVie extends CreatureAi{
	@SuppressWarnings("unused")
	private CreatureFactory factory;
	public PotionVie(Creature creature,CreatureFactory factory) {
		super(creature);
		this.factory = factory;
	}

}


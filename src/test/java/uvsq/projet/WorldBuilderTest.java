package uvsq.projet;

import static org.junit.Assert.*;

import org.junit.Test;

public class WorldBuilderTest {
	public WorldBuilder worldBuilder;
	
	@Test
	public void buildWorldTest() {
		worldBuilder = new WorldBuilder(5, 5);
		assertNotNull(worldBuilder.build());
	}
	@Test
	public void randomizeTilesTest() {
		worldBuilder = new WorldBuilder(5, 5);
		assertNotNull(worldBuilder.randomizeTiles());
	}

}


package uvsq.projet;

import static org.junit.Assert.*;

import org.junit.Test;

public class TileTest {
	private Tile tiles[][];
	World world;
	CreatureFactory creatureFactory;
	@Test
	public void isWallTest() {
		tiles=new Tile [2][2];
		tiles[0][0] = Tile.WALL;	
		assertTrue(tiles[0][0].isWall());
	}
	@Test
	public void isGround() {
		tiles=new Tile [2][2];
		tiles[0][0] = Tile.FLOOR;	
		assertTrue(tiles[0][0].isGround());
	}
	@Test
	public void isNotGroundWall() {
		tiles=new Tile [2][2];
		tiles[0][0] = Tile.WALL;	
		assertFalse(tiles[0][0].isGround());
	}
	@Test
	public void isNotGroundBounds() {
		tiles=new Tile [2][2];
		tiles[0][0] = Tile.BOUNDS;	
		assertFalse(tiles[0][0].isGround());
	}


}

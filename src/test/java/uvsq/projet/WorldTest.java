package uvsq.projet;

import static org.junit.Assert.*;

import java.awt.Color;
import org.junit.Test;
import asciiPanel.AsciiPanel;


public class WorldTest {
	private Tile tiles[][];
	World world;
	CreatureFactory creatureFactory;
	@Test
	public void notExistCaseLibre() {
		tiles=new Tile [2][2];
		tiles[0][0] = Tile.FLOOR;
		tiles[0][1] = Tile.FLOOR;
		tiles[1][0] = Tile.FLOOR;
		tiles[1][1] = Tile.FLOOR;
		world = new World(tiles);
		creatureFactory = new CreatureFactory(world);
		for(int i = 0; i<4; i++)
		{
			creatureFactory.newFungus();
		}
		assertNotNull(world.creature(0, 0));
	}
	@Test
	public void ExistCaseLibre() {
		tiles=new Tile [2][2];
		tiles[0][0] = Tile.FLOOR;
		tiles[0][1] = Tile.FLOOR;
		tiles[1][0] = Tile.FLOOR;
		tiles[1][1] = Tile.FLOOR;
		world = new World(tiles);
		creatureFactory = new CreatureFactory(world);		
		assertNull(world.creature(0, 0));
	}
	@Test
	public void caseOutBound() {
		tiles=new Tile [2][2];
		tiles[0][0] = Tile.FLOOR;
		tiles[0][1] = Tile.FLOOR;
		tiles[1][0] = Tile.FLOOR;
		tiles[1][1] = Tile.FLOOR;
		world = new World(tiles);	
		assertEquals(world.tile(3, 3),Tile.BOUNDS);
	}
	@Test
	public void caseInBound() {
		tiles=new Tile [2][2];
		tiles[0][0] = Tile.FLOOR;
		tiles[0][1] = Tile.FLOOR;
		tiles[1][0] = Tile.FLOOR;
		tiles[1][1] = Tile.FLOOR;
		world = new World(tiles);	
		assertEquals(world.tile(1, 1),Tile.FLOOR);
	}
	@Test
	public void caseGlyphWall() {
		tiles=new Tile [2][2];
		tiles[0][0] = Tile.WALL;
		tiles[0][1] = Tile.FLOOR;
		tiles[1][0] = Tile.FLOOR;
		tiles[1][1] = Tile.FLOOR;
		world = new World(tiles);	
		assertEquals(world.glyph(0, 0),(char)35);
	}
	@Test
	public void caseGlyphFloor() {
		tiles=new Tile [2][2];
		tiles[0][0] = Tile.FLOOR;
		tiles[0][1] = Tile.FLOOR;
		tiles[1][0] = Tile.FLOOR;
		tiles[1][1] = Tile.FLOOR;
		world = new World(tiles);	
		assertEquals(world.glyph(0, 0),'.');
	}
	@Test
	public void caseColorFloor() {
		tiles=new Tile [2][2];
		tiles[0][0] = Tile.FLOOR;
		tiles[0][1] = Tile.FLOOR;
		tiles[1][0] = Tile.FLOOR;
		tiles[1][1] = Tile.FLOOR;
		world = new World(tiles);
		assertEquals(world.color(0, 0),Color.WHITE);
	}
	@Test
	public void caseColorWall() {
		tiles=new Tile [2][2];
		tiles[0][0] = Tile.WALL;
		tiles[0][1] = Tile.FLOOR;
		tiles[1][0] = Tile.FLOOR;
		tiles[1][1] = Tile.FLOOR;
		world = new World(tiles);	
		assertEquals(world.color(0, 0),AsciiPanel.blue);
	}
	@Test
	public void addCreatureInEmptyLocation() {
		tiles=new Tile [2][2];
		tiles[0][0] = Tile.FLOOR;
		tiles[0][1] = Tile.FLOOR;
		tiles[1][0] = Tile.FLOOR;
		tiles[1][1] = Tile.FLOOR;
		world = new World(tiles);		
		creatureFactory = new CreatureFactory(world);	
		@SuppressWarnings("unused")
		Creature creature=creatureFactory.newFungus();
		assertEquals(world.getCreatures().size(), 1);
	}
	@Test
	public void removeCreature() {
		tiles=new Tile [2][2];
		tiles[0][0] = Tile.FLOOR;
		tiles[0][1] = Tile.FLOOR;
		tiles[1][0] = Tile.FLOOR;
		tiles[1][1] = Tile.FLOOR;
		world = new World(tiles);
		creatureFactory = new CreatureFactory(world);	
		Creature creature=creatureFactory.newFungus();
		world.remove(creature);
		assertEquals(world.getCreatures().size(), 0);
	}
	@Test
	public void monsterNearPlayer() {
		tiles=new Tile [2][1];
		tiles[0][0] = Tile.FLOOR;
		tiles[1][0] = Tile.FLOOR;
		//tiles[1][0] = Tile.FLOOR;
		//tiles[1][1] = Tile.FLOOR;
		world = new World(tiles);
		creatureFactory = new CreatureFactory(world);	
		@SuppressWarnings("unused")
		Creature monster=creatureFactory.newFungus();
		@SuppressWarnings("unused")
		Creature player=creatureFactory.newPlayer(null);
		assertNotNull(world.monsterNearPlayer());
	}
}

package uvsq.projet;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CreatureTest {
	private Tile tiles[][];
	World world;
	CreatureFactory creatureFactory;
	@Test
	public void attackTest() {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<String> messages = new ArrayList();
		tiles=new Tile [2][1];
		tiles[0][0] = Tile.FLOOR;
		tiles[1][0] = Tile.FLOOR;
		world = new World(tiles);
		creatureFactory = new CreatureFactory(world);	
		Creature monster = creatureFactory.newFungus();
		Creature player = creatureFactory.newPlayer(messages);
		player.attack(monster);
		assertEquals(player.monsterKill, 1);
	}
	@Test
	public void modifyHpTest() {
		int pv;
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<String> messages = new ArrayList();
		tiles=new Tile [2][1];
		tiles[0][0] = Tile.FLOOR;
		tiles[1][0] = Tile.FLOOR;
		world = new World(tiles);
		creatureFactory = new CreatureFactory(world);	
		Creature monster = creatureFactory.newFungus();
		pv = monster.hp();
		Creature player = creatureFactory.newPlayer(messages);
		player.attack(monster);
		assertTrue(monster.hp()<pv);
	}
	@Test
	public void canEnterTest() {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<String> messages =new ArrayList();
		tiles=new Tile [3][3];
		tiles[0][0] = Tile.FLOOR;
		tiles[0][1] = Tile.FLOOR;
		tiles[0][2] = Tile.FLOOR;
		tiles[1][0] = Tile.FLOOR;
		tiles[1][1] = Tile.FLOOR;
		tiles[1][2] = Tile.FLOOR;
		tiles[2][0] = Tile.FLOOR;
		tiles[2][1] = Tile.FLOOR;
		tiles[2][2] = Tile.FLOOR;
		world = new World(tiles);
		creatureFactory = new CreatureFactory(world);	
		Creature player=creatureFactory.newPlayer(messages);
		assertTrue(player.canEnter(1, 0));
	}
	@Test
	public void canNotEnterTest() {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<String> messages = new ArrayList();
		tiles=new Tile [2][1];
		tiles[0][0] = Tile.FLOOR;
		tiles[1][0] = Tile.WALL;
		world = new World(tiles);
		creatureFactory = new CreatureFactory(world);	
		Creature player = creatureFactory.newPlayer(messages);
		assertFalse(player.canEnter(1, 0));
	}
	@Test
	public void monsterAttackPlayerTest() {
		int pv;
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<String> messages = new ArrayList();
		tiles=new Tile [2][1];
		tiles[0][0] = Tile.FLOOR;
		tiles[1][0] = Tile.FLOOR;
		world = new World(tiles);
		creatureFactory = new CreatureFactory(world);
		Creature monster = creatureFactory.newFungus();
		Creature player = creatureFactory.newPlayer(messages);
		pv = player.hp();
		player.monsterAttackPlayer(monster);
		assertTrue(player.hp() < pv);
	}

}

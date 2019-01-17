package tp.p3.logic.lists;

import java.io.BufferedReader;
import java.io.IOException;

import tp.p3.logic.Game;
import tp.p3.logic.Level;
import tp.p3.logic.lists.GameObjectList;
import tp.p3.util.MyStringUtils;
import tp.p3.exceptions.FileContentsException;
import tp.p3.logic.entities.GameObject;
import tp.p3.logic.entities.zombies.Zombie;

public class Board {

	private GameObjectList plantList;
	private GameObjectList zombieList;
	
	static private final int ROWS = 4;
	static private final int COLS = 8;
	static private final int MAX_PLANTS = ROWS * COLS;
	
	public Board(int numZombies) {
		plantList = new GameObjectList(MAX_PLANTS);
		zombieList = new GameObjectList(numZombies);
	}
	
	public void update() {
		plantList.update();
		zombieList.update();
		cleanBoard();
	}

	public void cleanBoard() {
		plantList.clean();
		zombieList.clean();
	}
	
	public String store() {
		return "plantList: " + plantList.externalise() + "\r\nzombieList: " + zombieList.externalise();
	}
	
	public void load(BufferedReader inReader, Game game, Level level) throws FileContentsException{
		String[] prefijos = {"plantList", "zombieList" };
		String[] plantListLoad,zombieListLoad;
		try{
			plantListLoad = MyStringUtils.loadLine(inReader, prefijos[0], true);
			zombieListLoad = MyStringUtils.loadLine(inReader, prefijos[1],true);
			
			this.plantList = new GameObjectList(MAX_PLANTS);
			this.zombieList = new GameObjectList(level.getNumZombies());
			
			plantList.loadList(plantListLoad, false, game);
			zombieList.loadList(zombieListLoad, true, game);
		
		}
		catch(Exception ex) {
			throw new FileContentsException("Load failed: invalid file contents");
		}
	}
	

	public String getPlantsString(int pos) {
		return plantList.getStringDebug(pos);
	}
	
	public String getZombiesString(int pos) {
		return zombieList.getStringDebug(pos);
	}
	
	public int getNumPlants() {
		return plantList.getCont();
	}
	
	public int getNumZombies() {
		return zombieList.getCont();
	}
	
	public int getRows() {
		return ROWS;
	}
	
	public int getCols() {
		return COLS;
	}
	
	public boolean isEmpty(int x, int y) {
		boolean empty = true;
		
		if(plantList.isGameObject(x, y))
			empty = false;
		else if(zombieList.isGameObject(x, y))
			empty = false;
		
		return empty;
	}
	
	public boolean isZombie(int coor_x, int coor_y) {
		return zombieList.isGameObject(coor_x, coor_y);
	}
	public boolean isPlant(int coor_x, int coor_y) {
		return plantList.isGameObject(coor_x, coor_y);
	}
	public void addPlant(GameObject plant) {
		plantList.add(plant);
	}
	public void addZombie(Zombie zombie) {
		zombieList.add(zombie);
	}
	public boolean emptyRow(int row) {
		return zombieList.emptyRow(row);
	}
	public int firstZombie(int row) {
		return zombieList.checkFirst(row);
	}
	public void takeZombieDamage(int row, int y, int damage) {
		zombieList.takeDamage(row, y, damage);
	}
	public boolean areZombiesTerminated() {
		return (zombieList.getCont() == 0);
	}
	public boolean emptyCol(int col) {
		return zombieList.emptyCol(col);
	}
	
	public String getString(int coor_x, int coor_y) {
		return (plantList.getString(coor_x, coor_y) + zombieList.getString(coor_x, coor_y));
	}
	
	public boolean canZombieAttack(int x, int y) {
		return (plantList.isGameObject(x, y));
	}
	
	public void ZombieAttacks(int x, int y, int damage) {
		plantList.takeDamage(x, y, damage);
	}

	public void explode(int x, int y, int damage) {
		for(int i = -1; i <= 1;i++) {
			for(int j = -1; j <= 1; j++ ) {
				if(!isEmpty(x - i, y - j))
					if(zombieList.isGameObject(x-i, y - j))
						zombieList.takeDamage(x - i, y - j, damage);
			}
		}		
	}
	
}
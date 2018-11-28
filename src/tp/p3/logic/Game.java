package tp.p3.logic;

import tp.p3.logic.lists.Board;
import tp.p3.logic.Level;
import tp.p3.logic.SuncoinManager;
import tp.p3.logic.ZombieManager;
import tp.p3.logic.entities.plants.*;
import tp.p3.logic.entities.zombies.Zombie;
import tp.p3.logic.factories.ZombieFactory;

public class Game {
	
	private int cycleCounter;
	private boolean gameFinished;
	private Level level;
	private long seed;
	
	private Board board;
	private SuncoinManager suncoinManager;
	private ZombieManager zombieManager;
	
	public Game(Level new_level, long new_seed) {
//		cycleCounter = 0;
		gameFinished = false;
		
		level = new_level;
		seed = new_seed;
		
		board = new Board(level.getNumZombies());
		suncoinManager = new SuncoinManager();
		zombieManager = new ZombieManager(level, seed);
	}
	
	public void update(){
		board.update();
	}
	
	public boolean addPlantToGame(Plant plant, int x, int y) {
		if(suncoinManager.getCoins() >= plant.getCost()) {
			plant.setCoords(x, y);
			plant.setGame(this);
			
			board.addPlant(plant);
			suncoinManager.useCoins(plant.getCost());
			
			return true;
		}
		return false;
	}
	
	public void endGame() {
		gameFinished = true;
	}

	public void computerAction() {
		if(zombieManager.isZombieAdded()) {
			
			Zombie zombie = ZombieFactory.getZombie();
			zombie.setCoords((cycleCounter % (board.getRows() - 1)), (board.getCols()-1));
			zombie.setGame(this);
			board.addZombie(zombie);
		}
		cycleCounter++;
	}
	
	public void shoot(int row, int damage) {
		if(!board.emptyRow(row)) 
		{
			int y = board.firstZombie(row);
			board.takeZombieDamage(row,y, damage);
		}
	}
	
	public int getCycle() {
		return cycleCounter;
	}
	
	public int getSuncoins() {
		return suncoinManager.getCoins();
	}
	
	public boolean isFinished() {
		if(board.areZombiesTerminated() && zombieManager.getNumZom() == 0) { // User Wins
			gameFinished = true;
		}
		else if(!board.emptyCol(0)) {
			gameFinished = true;
		}
		return gameFinished;
	}
	
	public void resetGame() {
		
		cycleCounter = 0;
		gameFinished = false;
		
		board = new Board(level.getNumZombies());
		suncoinManager = new SuncoinManager();
		zombieManager = new ZombieManager(level, seed);
	}
	
	public String zombiesWin() {
		return  "ZZ'\"\"\"\"\"`ZZ ZZP\"\"\"\"\"\"\"ZZ Z\"\"\"\"\"`'\"\"\"`YZ ZZ\"\"\"\"\"\"\"\"`Z    ZZP\"\"\"\"\"YZZ Z\"\"ZZZZZ\"\"Z ZZ\"\"\"\"\"\"\"\"`Z ZZ\"\"\"\"\"\"\"`ZZ \r\n" + 
				"Z' .zzz. `Z Z' .zzzz  ZZ Z  zz.  zz.  Z ZZ  zzzzzzzZ    Z' .zzz. `Z Z  ZZZZZ  Z ZZ  zzzzzzzZ ZZ  zzzz,  Z \r\n" + 
				"Z  ZZZZZZZZ Z         `Z Z  ZZZ  ZZZ  Z Z`      ZZZZ    Z  ZZZZZ  Z Z  ZZZZP  Z Z`      ZZZZ Z'        .Z \r\n" + 
				"Z  ZZZ   `Z Z  ZZZZZ  ZZ Z  ZZZ  ZZZ  Z ZZ  ZZZZZZZZ    Z  ZZZZZ  Z Z  ZZZZ' .Z ZZ  ZZZZZZZZ ZZ  ZZZb. \"Z \r\n" + 
				"Z. `ZZZ' .Z Z  ZZZZZ  ZZ Z  ZZZ  ZZZ  Z ZZ  ZZZZZZZZ    Z. `ZZZ' .Z Z  ZZP' .ZZ ZZ  ZZZZZZZZ ZZ  ZZZZZ  Z \r\n" + 
				"ZZ.     .ZZ Z  ZZZZZ  ZZ Z  ZZZ  ZZZ  Z ZZ        .Z    ZZb     dZZ Z     .dZZZ ZZ        .Z ZZ  ZZZZZ  Z \r\n" + 
				"ZZZZZZZZZZZ ZZZZZZZZZZZZ ZZZZZZZZZZZZZZ ZZZZZZZZZZZZ    ZZZZZZZZZZZ ZZZZZZZZZZZ ZZZZZZZZZZZZ ZZZZZZZZZZZZ \r\n" + 
				"                                                                                                          ";
	}
	
	public String userWins() {
		return	"oooooo   oooo   .oooooo.   ooooo     ooo    oooooo   oooooo     oooo ooooo ooooo      ooo\r\n" + 
				" `888.   .8'   d8P'  `Y8b  `888'     `8'     `888.    `888.     .8'  `888' `888b.     `8'\r\n" + 
				"  `888. .8'   888      888  888       8       `888.   .8888.   .8'    888   8 `88b.    8 \r\n" + 
				"   `888.8'    888      888  888       8        `888  .8'`888. .8'     888   8   `88b.  8 \r\n" + 
				"    `888'     888      888  888       8         `888.8'  `888.8'      888   8     `88b.8 \r\n" + 
				"     888      `88b    d88'  `88.    .8'          `888'    `888'       888   8       `888 \r\n" + 
				"    o888o      `Y8bood8P'     `YbodP'             `8'      `8'       o888o o8o        `8 ";
	}
	
	public void winner() {
		if(board.areZombiesTerminated() && zombieManager.getNumZom() == 0) 
			System.out.println(userWins());
		
		else if(!board.emptyCol(0)) 
			System.out.println(zombiesWin());
	}
	
	public String getString(int coor_x, int coor_y) {
		return board.getString(coor_x, coor_y);
	}
	
	public String getPlantsStringDebug(int pos) {
		return board.getPlantsString(pos);
	}
	
	public String getZombiesStringDebug(int pos) {
		return board.getZombiesString(pos);
	}
	
	public int getNumPlants() {
		return board.getNumPlants();
	}
	
	public int getRemainigZombies() {
		return zombieManager.getNumZom();
	}
	
	public int getNumZombies() {
		return board.getNumZombies();
	}
	
	public boolean isZombie(int coor_x, int coor_y) {
		return board.isZombie(coor_x, coor_y);
	}
	
	public boolean isPlant(int coor_x, int coor_y) {
		return board.isPlant(coor_x, coor_y);
	}
	public void addCoins(int num) {
		suncoinManager.addCoins(num);
	}
	
	public int getCols() {
		return board.getCols();
	}
	
	public int getRows() {
		return board.getRows();
	}
	
	public boolean isEmpty(int coor_x, int coor_y) {
		return board.isEmpty(coor_x, coor_y);
	}
	
	public boolean canZombieAttack(int x, int y) {
		return board.canZombieAttack(x, y);
	}
	
	public void zombieAttacks(int x, int y, int damage) {
		board.ZombieAttacks(x, y, damage);
	}

	public void explode(int x, int y, int damage) {
		board.explode(x,y,damage);
	}
	
	public String getLevel() {
		if(level == Level.EASY)
			return "EASY";
		else if(level == Level.HARD)
			return "HARD";
		else
			return "INSANE";
	}
	
	public long getSeed() {
		return seed;
	}
}

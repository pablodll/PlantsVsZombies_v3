package tp.p3.logic.entities.plants;

import tp.p3.logic.Game;
import tp.p3.logic.entities.GameObject;

public class Sunflower extends Plant {
	
	private static int coins = 10;
	
	public Sunflower() {
		super();
		initialize();
	}
	
	public Sunflower(int coor_x, int coor_y, Game currentGame) {
		super(coor_x, coor_y, currentGame);
		initialize();
	}
	
	private void initialize() {
		cost = 20;
		maxHealth = 2;
		health = maxHealth;
		cycle = 0;
		freq = 2;
		damage = 0;
		symbol = "S";
		name = "sunflower";
		infoName = "[S]unflower";
	}
	
	public GameObject getThisObject() {
		return new Sunflower();
	}
	
	public void update() {
		generateSun();
		this.cycle++;
	}
	
	public void generateSun() {
		if((cycle % 2) == 0) {
			game.addCoins(coins);
		}
	}
	
}

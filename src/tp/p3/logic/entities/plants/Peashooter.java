package tp.p3.logic.entities.plants;

import tp.p3.logic.Game;
import tp.p3.logic.entities.GameObject;

public class Peashooter extends Plant {
	
	public Peashooter() {
		super();
		initialize();
	}
	
	public Peashooter(int coor_x, int coor_y, Game currentGame) {
		super(coor_x, coor_y, currentGame);
		initialize();
	}
	
	private void initialize() {
		cost = 50;
		maxHealth = 5;
		health = maxHealth;
		cycle = 0;
		freq = 1;
		damage = 1;
		symbol = "P";
		name = "peashooter";
		infoName = "[P]eashooter";
	}
	
	public GameObject getThisObject() {
		return new Peashooter();
	}
	
	public void update() {
		shoot();
		this.cycle++;
	}
	
	public void shoot() {
		game.shoot(x, damage);
	}
	
}

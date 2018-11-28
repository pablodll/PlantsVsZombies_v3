package tp.p3.logic.entities.plants;

import tp.p3.logic.Game;
import tp.p3.logic.entities.GameObject;

public class Wallnut extends Plant {
	
	public Wallnut() {
		super();
		initialize();
	}
	
	public Wallnut(int coor_x, int coor_y, Game currentGame) {
		super(coor_x, coor_y, currentGame);
		initialize();
	}
	
	private void initialize() {
		cost = 50;
		maxHealth = 10;
		health = maxHealth;
		cycle = 0;
		freq = 1;
		damage = 0;
		symbol = "N";
		name = "wallnut";
		infoName = "Wall[N]ut";
	}
	
	public GameObject getThisObject() {
		return new Wallnut();
	}
	
	public void update() {
		//Nothing
	}
	
	
}

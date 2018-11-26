package tp.p3.logic.entities.plants;

import tp.p3.logic.Game;
import tp.p3.logic.entities.GameObject;

public class Wallnut extends Plant {
	
	public Wallnut() {
		initialise();
	}
	
	public Wallnut(int coor_x, int coor_y, Game currentGame) {
		super(coor_x, coor_y, currentGame);
		initialise();
	}
	
	private void initialise() {
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
	
	public GameObject getThisObject(int x, int y, Game game) {
		return new Wallnut(x, y, game);
	}
	
	public void update() {
		//Nothing
	}
	
	
}

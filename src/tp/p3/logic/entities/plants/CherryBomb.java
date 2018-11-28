package tp.p3.logic.entities.plants;

import tp.p3.logic.Game;
import tp.p3.logic.entities.GameObject;

public class CherryBomb extends Plant {
	
	public CherryBomb() {
		super();
		initialize();
	}
	
	public CherryBomb(int coor_x, int coor_y, Game currentGame) {
		super(coor_x, coor_y, currentGame);
		initialize();
	}
	
	private void initialize() {
		cost = 50;
		maxHealth = 2;
		health = maxHealth;
		cycle = 0;
		freq = 1;
		damage = 10; 
		symbol = "C";
		name = "cherrybomb";
		infoName = "[C]herrybomb";
	}
	
	public GameObject getThisObject() {
		return new CherryBomb();
	}
	
	private void selfDestroy() {
		health = 0;
	}
	
	public void update() {
		if(cycle == 2) {
			game.explode(x, y, damage);
			selfDestroy();
		}
		this.cycle++;
	}	
}

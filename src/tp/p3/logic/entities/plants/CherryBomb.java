package tp.p3.logic.entities.plants;

import tp.p3.logic.Game;
import tp.p3.logic.entities.GameObject;

public class CherryBomb extends Plant {
	
	public CherryBomb() {
		initialise();
	}
	
	public CherryBomb(int coor_x, int coor_y, Game currentGame) {
		super(coor_x, coor_y, currentGame);
		initialise();
	}
	
	private void initialise() {
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
	
	public GameObject getThisObject(int x, int y, Game game) {
		return new CherryBomb(x, y, game);
	}
	
	private void selfdestroy() {
		health = 0;
	}
	
	public void update() {
		if(cycle == 2) {
			game.explode(x, y, damage);
			selfdestroy();
		}
		this.cycle++;
	}	
}

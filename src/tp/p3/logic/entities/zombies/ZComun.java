package tp.p3.logic.entities.zombies;

import tp.p3.logic.Game;
import tp.p3.logic.entities.GameObject;

public class ZComun extends Zombie{
	
	public ZComun() {
		initialize();
	}
	
	public ZComun(int coor_x, int coor_y, Game currentGame) {
		super(coor_x, coor_y, currentGame);
		initialize();
	}
	
	private void initialize() {
		maxHealth = 5;
		health = maxHealth;
		cycle = 0;
		freq = 2;
		damage = 1;
		symbol = "Z";
		name = "zcomun";
		infoName = "[Z]ombie comun";
	}
	
	public GameObject getThisObject() {
		return new ZComun();
	}
	
}

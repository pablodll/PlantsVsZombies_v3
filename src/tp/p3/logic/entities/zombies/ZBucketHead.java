package tp.p3.logic.entities.zombies;

import tp.p3.logic.Game;
import tp.p3.logic.entities.GameObject;

public class ZBucketHead extends Zombie{
	
	public ZBucketHead() {
		initialize();
	}
	
	public ZBucketHead(int coor_x, int coor_y, Game currentGame) {
		super(coor_x, coor_y, currentGame);
		initialize();
	}
	
	private void initialize() {
		maxHealth = 8;
		health = maxHealth;
		cycle = 0;
		freq = 4;
		damage = 1;
		symbol = "W";
		name = "buckethead";
		infoName = "Zombie buckethead[W]";
	}
	
	public GameObject getThisObject() {
		return new ZBucketHead();
	}
	
}

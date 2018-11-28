package tp.p3.logic.entities.plants;

import tp.p3.logic.Game;
import tp.p3.logic.entities.GameObject;

public abstract class Plant extends GameObject{
	
	protected static int cost;
	
	protected Plant() {
		super();
	}
	
	protected Plant(int coor_x, int coor_y, Game currentGame) {
		super(coor_x, coor_y, currentGame);
	}
	
	public String getInfo() {
		return (infoName + " Cost: " + cost + " suncoins Harm: " + damage + "\n");
	}
	
	public int getCost() {
		return cost;
	}
}

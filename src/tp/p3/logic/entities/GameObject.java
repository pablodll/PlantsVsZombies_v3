package tp.p3.logic.entities;

import tp.p3.logic.Game;
import tp.p3.logic.entities.plants.Peashooter;
import tp.p3.logic.entities.plants.Plant;

public abstract class GameObject {
	
	protected int x, y;
	protected int maxHealth;
	protected int health;
	protected int cycle;
	protected int freq;
	protected String symbol;
	protected String name;
	protected String infoName;
	protected Game game;
	
	protected int damage;
	
	protected GameObject() {
		
	}
	
	protected GameObject(int coor_x, int coor_y, Game currentGame) {
		this.x = coor_x;
		this.y = coor_y;
		this.game = currentGame;
		cycle = 0;
	}
	
	public abstract void update();
	public abstract GameObject getThisObject(int x, int y, Game game);
	
	public GameObject parse(String name, int x, int y, Game game) {
		if(name.equals(this.name) || (name.equals(this.symbol.toLowerCase()))) {
			return getThisObject(x, y, game);
		}
		else {
			return null;
		}
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getPosX() {
		return x;
	}
	
	public int getPosY() {
		return y;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean positionIs(int coor_x, int coor_y) {
		return (x == coor_x && y == coor_y);
	}
	
	public void takeDamage(int damage_taken) {
		if(health >= damage_taken)
			health -= damage_taken;
		else
			health = 0;
	}
	
	public String toString() {
		return symbol + " [" + health + "]";
	}
	
	public String toStringDebug() {
		return symbol + " [l:" + health + ",x:" + x + ",y:" + y + ",t:" + cycle%freq + "]";
	}
}

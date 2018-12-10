package tp.p3.logic.entities;

import tp.p3.logic.Game;

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
	}
	
	public abstract void update();
	public abstract GameObject getThisObject();
	
	public void setCycle(int cycle) {
		this.cycle = cycle;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public void setCoords(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	public GameObject parse(String name) {
		if(name.equals(this.name) || (name.equals(this.symbol.toLowerCase()))) {
			return getThisObject();
		}
		else {
			return null;
		}
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getFreq() {
		return freq;
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
	
	public String getSymbol() {
		return symbol;
	}
	
	public int getCycle() {
		return (this.cycle%this.freq);
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

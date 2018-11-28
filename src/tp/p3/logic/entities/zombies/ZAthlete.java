package tp.p3.logic.entities.zombies;

import tp.p3.logic.Game;
import tp.p3.logic.entities.GameObject;

public class ZAthlete extends Zombie{
	
	public ZAthlete() {
		initialize();
	}
	
	public ZAthlete(int coor_x, int coor_y, Game currentGame) {
		super(coor_x, coor_y, currentGame);
		initialize();
	}
	
	private void initialize() {
		maxHealth = 2;
		health = maxHealth;
		cycle = 0;
		freq = 1;
		damage = 1;
		symbol = "X";
		name = "athlete";
		infoName = "Zombie athlete[X]";
	}
	

	public GameObject getThisObject() {
		return new ZAthlete();
	}
	
	@Override
	public void update() {
			if(!game.isEmpty(x, y-1)) {
				if(game.isPlant(x, y-1)) {
					game.zombieAttacks(x, y-1,damage);
				}
				// else { theres a zombie, dont move }
			}
			else {
				if(!(this.cycle == 0)) {
				move();		
			}
				else
					this.cycle++;
		}
	}
}

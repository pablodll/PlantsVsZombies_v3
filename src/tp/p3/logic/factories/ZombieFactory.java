package tp.p3.logic.factories;

import java.util.Random;
import tp.p3.logic.Game;
import tp.p3.logic.entities.GameObject;
import tp.p3.logic.entities.zombies.*;

public class ZombieFactory {
	
	private static Zombie[] availableZombies = {
		new ZComun(),
		new ZBucketHead(),
		new ZAthlete(),
	};
		
	public static GameObject getZombie(int x, int y, Game game) {
		GameObject zombie = null;
		int i = 0;
		String zombieType = randZombie();
		while(zombie == null && i < availableZombies.length) {
			zombie = availableZombies[i].parse(zombieType, x, y, game);
			i++;
		}
			
		return zombie;
	}
	
	public static String listOfAvailableZombies() {
		String info = "";
		for(Zombie zombie : availableZombies) {
			info += zombie.getInfo();
		}
		return info;
	}
	
	private static String randZombie() {
		int random = new Random().nextInt(availableZombies.length);	
		return availableZombies[random].getName();
	}
	
}

package tp.p3.logic.factories;

import java.util.Random;
import tp.p3.logic.entities.zombies.*;

public class ZombieFactory {
	
	private static Zombie[] availableZombies = {
		new ZComun(),
		new ZBucketHead(),
		new ZAthlete(),
	};
		
	public static Zombie getZombie() {
		Zombie zombie = null;
		String zombieType = randZombie();
		
		zombie = getZombie(zombieType);
			
		return zombie;
	}
	
	public static Zombie getZombie(String zombieType) {
		Zombie zombie = null;
		int i = 0;
		
		while(i < availableZombies.length && zombie == null) {
			zombie = (Zombie)availableZombies[i].parse(zombieType);
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

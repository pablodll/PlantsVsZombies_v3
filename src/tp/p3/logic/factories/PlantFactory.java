package tp.p3.logic.factories;

import tp.p3.logic.entities.GameObject;
import tp.p3.logic.entities.plants.*;
import tp.p3.logic.Game;

public class PlantFactory {
	
	private static Plant[] availablePlants = {
		new Sunflower(),
		new Peashooter(),
		new CherryBomb(),
		new Wallnut()
	};
	
	public static GameObject getPlant(String plantName, int x, int y, Game game) {
		GameObject plant = null;
		int i = 0;
		
		while(plant == null && i < availablePlants.length) {
			plant = availablePlants[i].parse(plantName, x, y, game);
			i++;
		}
		
		return plant;
	}
	
	public static String listOfAvailablePlants() {
		String info = "";
		for(Plant plant : availablePlants) {
			info += plant.getInfo();
		}
		return info;
	}
	
}

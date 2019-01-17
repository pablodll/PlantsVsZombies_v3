package tp.p3.logic.lists;

import tp.p3.exceptions.FileContentsException;
import tp.p3.logic.Game;
import tp.p3.logic.entities.GameObject;
import tp.p3.logic.factories.PlantFactory;
import tp.p3.logic.factories.ZombieFactory;

public class GameObjectList {

	private GameObject list[];
	private int cont;

	protected GameObjectList(int numMAX) {
		list = new GameObject[numMAX];
		cont = 0;
	}
	
	protected void update() {
		for (int i = 0; i < cont; i++) {
			list[i].update();
		}
	}
		
	public int getCont() {
		return cont;
	}
	
	public void add(GameObject object) {
		list[cont] = object ;
		cont++;
	}
	
	public void clean() {
		int cont_aux = cont;		
		for(int i = 0; (i<cont_aux); ) {
			if(list[i].getHealth() <= 0) {
				remove(i);
				cont_aux--;
			}else i++;
		}
	}
	
	public void remove(int pos) {
		while(pos < cont-1) {
			list[pos] = list[pos+1];
			pos++;
		}
		cont--;
	}
	
	public boolean isGameObject(int coor_x, int coor_y) { // Devuelve si en una coordenada dada hay un gameobject determinado
		int i = 0;
		while(i < cont && !(list[i].getPosX() == coor_x && list[i].getPosY() == coor_y)) {
			i++;
		}
		return i < cont;
	}
	
	public String getString(int x, int y) {
		if(isGameObject(x, y)) {
			
			int i = 0;
			while((i < cont) && !(list[i].positionIs(x, y))) {
				i++;
			}
			
			return list[i].toString();
		}
		else
			return "";
	}
	
	public String externalise() {
		String ret = "";
		for(int i = 0; i < this.cont; i++) {
			ret += list[i].getSymbol() + ":" + list[i].getHealth() + ":" + list[i].getPosX() + ":" + list[i].getPosY() + ":" + list[i].getCycle() + ", ";
		}
		return ret;
	}
	
	public String getStringDebug(int pos) {
		return list[pos].toStringDebug();
	}
	
	public boolean emptyRow(int row) { // Comprueba si la fila tiene algun gameObject del tipo
		int i = 0;
		
		while((i < cont) && (list[i].getPosX() != row))
			i++;
		
		return i == cont;
	}
	
	public boolean emptyCol(int col) { // Comprueba si la columna tiene algun gameObject del tipo
		int i = 0;
		
		while((i < cont) && (list[i].getPosY() != col))
			i++;
		
		return i == cont;
	}
	
	public void takeDamage(int x, int y, int damage) {
		int i = 0;
		
		while((i < cont) && !(list[i].positionIs(x, y))) {
			i++;
		}
		
		list[i].takeDamage(damage);
	}
	
	public int checkFirst(int row) { // Dada una fila(X) devuelve la coord y del primer gameObject deseado en esa fila
		int y = -1;
		
		for(int i = 0; i < cont; i++) {
			
			if((list[i].getPosX() == row) && (y == -1)) {
				y = list[i].getPosY();
			}
			else if((list[i].getPosX() == row) && (y != -1)) {
				if(list[i].getPosY() < y)
					y = list[i].getPosY();
			}
		}
		
		return y;
	}
	
	public void loadList(String[] list, boolean isZombie, Game game) throws FileContentsException{
		
		GameObject plant = null;
		GameObject zombie = null;
		
		for(int i = 0; i < list.length; i++) {
			String[] info = list[i].split(":");
			if(isZombie) {
				zombie = ZombieFactory.getZombie(info[0].toLowerCase());
				if(zombie != null) {
					try {
						zombie.setHealth(Integer.parseInt(info[1]));
						zombie.setCoords(Integer.parseInt(info[2]),Integer.parseInt(info[3]));
						zombie.setCycle(zombie.getFreq() - Integer.parseInt(info[4]));
						zombie.setGame(game);
					}
					catch(Exception ex) {
						throw new FileContentsException("Load failed: invalid file contents");
					}
				}
				this.add(zombie);
			}
			else{
				plant = PlantFactory.getPlant(info[0].toLowerCase());
				if(plant != null) {
					try {
						plant.setHealth(Integer.parseInt(info[1]));
						plant.setCoords(Integer.parseInt(info[2]),Integer.parseInt(info[3]));
						plant.setCycle(plant.getFreq() - Integer.parseInt(info[4]));
						plant.setGame(game);
					}
					catch(Exception ex) {
						throw new FileContentsException("Load failed: invalid file contents");
					}
				}
				this.add(plant);
			}
		}
		
	}
	
}

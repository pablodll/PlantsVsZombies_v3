package tp.p3.logic.lists;

import tp.p3.logic.entities.GameObject;

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

	public GameObject getGameObject(int x, int y) { // Devuelve un gameObject en una posicion dada
		int i = 0;
		while((i < cont) && !(list[i].positionIs(x, y)))
				i++;
		return list[i];
	}
	
	public boolean isGameObject(int coor_x, int coor_y) { // Devuelve si en una coordenada dada hay un gameobject determinado
		int i = 0;
		while(i < cont && !(list[i].getPosX() == coor_x && list[i].getPosY() == coor_y)) {
			i++;
		}
		return i < cont;
	}
	
	public String getString(int i, int j) {
		if(isGameObject(i, j))
			return getGameObject(i, j).toString();
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
	
	public void getAttacked(int x, int y, int damage) {
		getGameObject(x, y).takeDamage(damage);
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
		GameObject obj = getGameObject(x, y);
		obj.takeDamage(damage);
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
}

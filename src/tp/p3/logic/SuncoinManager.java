package tp.p3.logic;

import tp.p3.exceptions.SuncoinException;

public class SuncoinManager {
	private int sunCoins = 50;

	public void setCoins(int value) {
		sunCoins = value;
	}

	public int getCoins() {
		return sunCoins;
	}

	public void addCoins(int coins) {
		sunCoins += coins;
	}

	public void useCoins(int coins) {
		sunCoins -= coins;
	}
	
	public void spendCoins(int cost) throws SuncoinException{
		if(sunCoins >= cost) {
			this.useCoins(cost);
		}
		else {
			throw new SuncoinException("Not enough suncoins");
		}
	}
}

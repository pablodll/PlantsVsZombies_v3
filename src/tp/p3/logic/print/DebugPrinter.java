package tp.p3.logic.print;

import tp.p3.logic.Game;
import tp.p3.util.MyStringUtils;

public class DebugPrinter extends BoardPrinter{
	
	private String[] board;
	private long seed;
	private String level;
	private int numPlants;
	private int numZombies;
	private int cycle,suncoins,remZombies;

	
	private int tam; 
	
	public DebugPrinter(Game game) {
		super(game);
	}
	
	protected void encodeGame(Game game) {
		this.numPlants = game.getNumPlants();
		this.numZombies = game.getNumZombies();
		this.tam = numPlants + numZombies;
		
		this.level = game.getLevel();
		this.seed = game.getSeed();
		this.cycle = game.getCycle();
		this.suncoins = game.getSuncoins();
		this.remZombies = game.getRemainigZombies();
		
		board = new String[tam];
		
		int i = 0;
		while(i < numPlants) {			
			board[i] = game.getPlantsStringDebug(i);
			i++;
		}
		int j = 0;
		while(i < tam && j < (numZombies)) {
			board[i] = game.getZombiesStringDebug(j);
			i++;
			j++;
		}
	}
	
	public String toString() {

		int cellSize = 19;
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
		
		String rowDelimiter = MyStringUtils.repeat(hDelimiter, (tam * (cellSize + 1)) - 1);
		String margin = MyStringUtils.repeat(space, marginSize);
		String lineDelimiter = String.format("%n%s%s%n", margin + space, rowDelimiter);
		
		StringBuilder str = new StringBuilder();
		
		str.append("Number of cycles: " + cycle + "\nCoins: " + suncoins + 
				"\nRemaining zombies: " + remZombies + "\nLevel : " + level + "\nSeed: " + seed);
		
		str.append(lineDelimiter);
		
		for(int i=0; i < tam; i++) {
				str.append(margin).append(vDelimiter);
				str.append( MyStringUtils.centre(board[i], cellSize)).append(vDelimiter);
		}
		str.append(lineDelimiter);
		
		return str.toString();
	}
	
}

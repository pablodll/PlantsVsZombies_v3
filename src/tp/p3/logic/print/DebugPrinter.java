package tp.p3.logic.print;

import tp.p3.logic.Game;

public class DebugPrinter extends BoardPrinter{
	
	//private String[] board;
	private long seed;
	private String level;
//	private int numPlants;
//	private int numZombies;
	//private int cycle,suncoins,remZombies;

	private final int cellSize = 19;
	
//	private int tam; 
	
	public DebugPrinter() {	
		super();
		this.name = "debug";
	}
	
	public DebugPrinter(Game game) {
		super(game);
		this.name = "debug";
	}
	
	protected GamePrinter getThisPrinter(Game game) {
		return new DebugPrinter(game);
	}
	
	protected void encodeGame(Game game) {
//		this.numPlants = game.getNumPlants();
//		this.numZombies = game.getNumZombies();
//		this.tam = numPlants + numZombies;
		
		this.dimX = 1;
		this.dimY = game.getNumPlants() + game.getNumZombies();
		
		this.board = new String[dimX][dimY];
		
		this.level = game.getLevel();
		this.seed = game.getSeed();
		this.cycle = game.getCycle();
		this.suncoins = game.getSuncoins();
		this.remZombies = game.getRemainigZombies();
		
//		board = new String[tam];
		
		int i = 0;
		while(i < game.getNumPlants()) {			
			board[0][i] = game.getPlantsStringDebug(i);
			i++;
		}
		
		int j = 0;
		while((i < dimY) && (j < game.getNumZombies())) {
			board[0][i] = game.getZombiesStringDebug(j);
			i++;
			j++;
		}
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		str.append("Number of cycles: " + cycle + "\nCoins: " + suncoins + "\nRemaining zombies: " + remZombies + "\nLevel : " + level + "\nSeed: " + seed);
		str.append(boardToString(cellSize));
		
		return str.toString();
	}
	
//	public String toString() {
//
//		int cellSize = 19;
//		int marginSize = 2;
//		String vDelimiter = "|";
//		String hDelimiter = "-";
//		
//		String rowDelimiter = MyStringUtils.repeat(hDelimiter, (tam * (cellSize + 1)) - 1);
//		String margin = MyStringUtils.repeat(space, marginSize);
//		String lineDelimiter = String.format("%n%s%s%n", margin + space, rowDelimiter);
//		
//		StringBuilder str = new StringBuilder();
//		
//		str.append("Number of cycles: " + cycle + "\nCoins: " + suncoins + 
//				"\nRemaining zombies: " + remZombies + "\nLevel : " + level + "\nSeed: " + seed);
//		
//		str.append(lineDelimiter);
//		
//		for(int i=0; i < tam; i++) {
//				str.append(margin).append(vDelimiter);
//				str.append( MyStringUtils.centre(board[i], cellSize)).append(vDelimiter);
//		}
//		str.append(lineDelimiter);
//		
//		return str.toString();
//	}
	
}

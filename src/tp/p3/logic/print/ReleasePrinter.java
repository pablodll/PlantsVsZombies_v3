package tp.p3.logic.print;

import tp.p3.logic.Game;

public class ReleasePrinter extends BoardPrinter{
	
//	private String[][] board;
//	private final int dimX; 
//	private final int dimY;
//	private int cycle,suncoins,remZombies;
	
	private final int cellSize = 7;
	
	public ReleasePrinter() {	
		super();
		this.name = "release";
	}
	
	public ReleasePrinter(Game game) {
		super(game);
		
		this.dimX = game.getRows();
		this.dimY = game.getCols();
		this.name = "release";
	}
	
	protected GamePrinter getThisPrinter(Game game) {
		return new ReleasePrinter(game);
	}
	
	protected void encodeGame(Game game) {
		this.board = new String[dimX][dimY];
		
		this.cycle = game.getCycle();
		this.suncoins = game.getSuncoins();
		this.remZombies = game.getRemainigZombies();
		
		
		for(int i = 0; i < dimX; i++) {			
			for(int j = 0; j < dimY; j++) {
				board[i][j] = game.getString(i,j);
			}
		}
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		str.append("Number of cycles: " + cycle + "\nCoins: " + suncoins + "\nRemaining zombies: " + remZombies + "\n");
		str.append(boardToString(cellSize));
		
		return str.toString();
	}
	
//	public String toString() {
//
//		int cellSize = 7;
//		int marginSize = 2;
//		String vDelimiter = "|";
//		String hDelimiter = "-";
//		
//		String rowDelimiter = MyStringUtils.repeat(hDelimiter, (dimY * (cellSize + 1)) - 1);
//		String margin = MyStringUtils.repeat(space, marginSize);
//		String lineDelimiter = String.format("%n%s%s%n", margin + space, rowDelimiter);
//		
//		StringBuilder str = new StringBuilder();
//
//		str.append("Number of cycles: " + cycle + "\nCoins: " + suncoins + 
//				"\nRemaining zombies: " + remZombies + "\n");
//		
//		str.append(lineDelimiter);
//		
//		for(int i=0; i<dimX; i++) {
//				str.append(margin).append(vDelimiter);
//				for (int j=0; j<dimY; j++) {
//					str.append( MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);
//				}
//				str.append(lineDelimiter);
//		}
//		return str.toString();
//	}
	
}

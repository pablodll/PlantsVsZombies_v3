package tp.p3.logic.print;

import tp.p3.logic.Game;
import tp.p3.util.MyStringUtils;

public class ReleasePrinter extends BoardPrinter{
	
	private String[][] board;
	private final int dimX; 
	private final int dimY;
	private int cycle,suncoins,remZombies;
	
	public ReleasePrinter(Game game, int dimX, int dimY) {
		super(game);
		
	
		this.dimX = dimX;
		this.dimY = dimY;
	}
	
	protected void encodeGame(Game game) {
		board = new String[dimX][dimY];
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

		int cellSize = 7;
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
		
		String rowDelimiter = MyStringUtils.repeat(hDelimiter, (dimY * (cellSize + 1)) - 1);
		String margin = MyStringUtils.repeat(space, marginSize);
		String lineDelimiter = String.format("%n%s%s%n", margin + space, rowDelimiter);
		
		StringBuilder str = new StringBuilder();

		str.append("Number of cycles: " + cycle + "\nCoins: " + suncoins + 
				"\nRemaining zombies: " + remZombies + "\n");
		
		str.append(lineDelimiter);
		
		for(int i=0; i<dimX; i++) {
				str.append(margin).append(vDelimiter);
				for (int j=0; j<dimY; j++) {
					str.append( MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);
				}
				str.append(lineDelimiter);
		}
		return str.toString();
	}
	
}

package tp.p3.logic.print;

import tp.p3.logic.Game;
import tp.p3.util.MyStringUtils;

public abstract class BoardPrinter implements GamePrinter{
	
	protected String name;
	
	protected String[][] board;
	protected int dimX; 
	protected int dimY;
	protected int cycle,suncoins,remZombies;
	
	private static final String space = " ";
	
	public BoardPrinter() {	
		
	}
	
	public BoardPrinter(Game game) {	
		encodeGame(game);
	}
	
	protected abstract void encodeGame(Game game);
	protected abstract GamePrinter getThisPrinter(Game game);
	
	public GamePrinter parse(String name, Game game) {
		if(name.equals(this.name)) {
			return getThisPrinter(game);
		}
		else {
			return null;
		}
	}
	
	public String boardToString(int cellSize) {
		
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
		
		String rowDelimiter = MyStringUtils.repeat(hDelimiter, (dimY * (cellSize + 1)) - 1);
		String margin = MyStringUtils.repeat(space, marginSize);
		String lineDelimiter = String.format("%n%s%s%n", margin + space, rowDelimiter);
		
		StringBuilder str = new StringBuilder();
		
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
	
	public void printGame(Game game) {
		encodeGame(game);
		System.out.println(this.toString());
	}
	
}

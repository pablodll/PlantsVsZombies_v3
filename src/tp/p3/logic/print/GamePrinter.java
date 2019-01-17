package tp.p3.logic.print;

import tp.p3.logic.Game;

public interface GamePrinter {
	
	public void printGame(Game game);
	public GamePrinter parse(String name, Game game);
	
}

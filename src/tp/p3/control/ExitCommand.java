package tp.p3.control;

import tp.p3.logic.Game;

public class ExitCommand extends NoParamsCommand{
	
	private static String commandText = "exit";
	private static String commandTextMsg = "[E]xit";
	private static String helpTextMsg = "terminates the program.";
	
	public ExitCommand() {
		super(commandText, commandTextMsg, helpTextMsg);
	}
	
	public NoParamsCommand getThisCommand() {
		return new ExitCommand();
	}
	
	public boolean execute(Game game) {
		game.endGame();
		System.out.println(game.gameOver());
		return false;
	}
	
}

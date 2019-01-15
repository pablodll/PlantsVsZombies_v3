package tp.p3.control;

import tp.p3.logic.Game;

public class ResetCommand extends NoParamsCommand{

	private static String commandText = "reset";
	private static String commandTextMsg = "[R]eset";
	private static String helpTextMsg = "resets game.";
	
	public ResetCommand() {
		super(commandText, commandTextMsg, helpTextMsg);
	}
	
	public NoParamsCommand getThisCommand() {
		return new ResetCommand();
	}
	
	public boolean execute(Game game) {
		game.resetGame();
		return true;
	}
}

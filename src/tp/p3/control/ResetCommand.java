package tp.p3.control;

import tp.p3.logic.Game;

public class ResetCommand extends NoParamsCommand{

	private static String commandText = "reset";
	private static String commandTextMsg = "[R]eset";
	private static String helpTextMsg = "resets game.";
	
	public ResetCommand() {
		super(commandText, commandTextMsg, helpTextMsg);
	}
	
	public NoParamsCommand parse(String[] commandWords, Controller controller) {
		if(commandWords[0].equals(this.commandName) || commandWords[0].equals(this.commandLetter)) {
			return new ResetCommand();
		}
		else {
			return null;
		}
	}
	
	public boolean execute(Game game, Controller controller) {
		game.resetGame();
		return true; // NO
	}
}

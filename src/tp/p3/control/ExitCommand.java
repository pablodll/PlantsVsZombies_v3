package tp.p3.control;

import tp.p3.logic.Game;

public class ExitCommand extends NoParamsCommand{
	
	private static String commandText = "exit";
	private static String commandTextMsg = "[E]xit";
	private static String helpTextMsg = "terminates the program.";
	
	public ExitCommand() {
		super(commandText, commandTextMsg, helpTextMsg);
	}
	
	public NoParamsCommand parse(String[] commandWords, Controller controller) {
		if(commandWords[0].equals(this.commandName) || commandWords[0].equals(this.commandLetter)) {
			return new ExitCommand();
		}
		else {
			return null;
		}
	}
	
	public boolean execute(Game game, Controller controller) {
		game.endGame();
		System.out.println(game.zombiesWin());
	return true;
	}
	
}

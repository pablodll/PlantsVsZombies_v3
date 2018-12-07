package tp.p3.control;

import tp.p3.logic.Game;
import tp.p3.control.CommandParser;
import tp.p3.exceptions.*;

public class HelpCommand extends NoParamsCommand{
	
	private static String commandText = "help";
	private static String commandTextMsg = "[H]elp";
	private static String helpTextMsg = "print this help message.";
	
	public HelpCommand() {
		super(commandText, commandTextMsg, helpTextMsg);
	}
	
	public NoParamsCommand parse(String[] commandWords, Controller controller) throws CommandParseException{
		if(commandWords[0].equals(this.commandName) || commandWords[0].equals(this.commandLetter)) {
			if(commandWords.length > 1)
				throw new CommandParseException(this.commandName + " command has no arguments");
			else
				return new HelpCommand();
		}
		else {
			return null;
		}
	}
	
	public boolean execute(Game game, Controller controller) {
		//controller.setNoPrintGameState();
		System.out.println(CommandParser.commandHelp());
		return true;
	}
}

package tp.p3.control;

import tp.p3.exceptions.CommandParseException;
import tp.p3.logic.Game;

public class NoneCommand extends NoParamsCommand {
	
	private static String commandText = "none";
	private static String commandTextMsg = "[N]one";
	private static String helpTextMsg = "skips cycle.";
	
	public NoneCommand() {
		super(commandText, commandTextMsg, helpTextMsg);
	}
	
	public NoParamsCommand getThisCommand() {
		return new NoneCommand();
	}
	
	public boolean execute(Game game) {
		return true;
	}
	
	// Como NoneCommand tiene que llamarse con su letra (n) pero tambien con un string vacio 
	// tiene un parse propio del resto de NoParamsCommands con la condicion del string vacio
	public NoParamsCommand parse(String[] commandWords) throws CommandParseException{
		if(commandWords[0].equals(this.commandName) || commandWords[0].equals(this.commandLetter) || commandWords[0].equals("")) {
			if(commandWords.length > 1)
				throw new CommandParseException(this.commandName + " command has no arguments");
			else
				return getThisCommand();
		}
		else {
			return null;
		}
	}
}

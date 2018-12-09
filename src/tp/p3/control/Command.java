package tp.p3.control;

import tp.p3.exceptions.*;
import tp.p3.logic.Game;

public abstract class Command {
	
	private String helpText;
	private String helpInfo;
	protected final String commandName;
	protected final String commandLetter;
	
	public Command(String commandText, String commandTextMsg, String helpTextMsg){
		commandName = commandText;
		commandLetter = Character.toString(commandName.charAt(0));
		helpText = commandTextMsg;
		helpInfo = helpTextMsg;
	}
	
	public abstract boolean execute(Game game) throws CommandExecuteException;
	
	public abstract Command parse(String[] commandWords) throws CommandParseException;
	
	public String helpText(){return " " + helpText + ": " + helpInfo;}

}
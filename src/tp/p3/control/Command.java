package tp.p3.control;

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
	// Some commands may generate an error in the execute or parse methods.
	// In the absence of exceptions , they must the tell the controller not to print the board
	public abstract boolean execute(Game game, Controller controller);
	public abstract Command parse(String[] commandWords, Controller controller);
	public String helpText(){return " " + helpText + ": " + helpInfo;}

}
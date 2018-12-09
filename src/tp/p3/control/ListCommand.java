package tp.p3.control;

import tp.p3.exceptions.*;
import tp.p3.logic.Game;
import tp.p3.logic.factories.PlantFactory;

public class ListCommand extends NoParamsCommand{
	
	private static String commandText = "list";
	private static String commandTextMsg = "[L]ist";
	private static String helpTextMsg = "print the list of available plants.";
	
	public ListCommand() {
		super(commandText, commandTextMsg, helpTextMsg);
	}
	
	public NoParamsCommand parse(String[] commandWords) throws CommandParseException{
		if(commandWords[0].equals(this.commandName) || commandWords[0].equals(this.commandLetter)) {
			if(commandWords.length > 1)
				throw new CommandParseException(this.commandName + " command has no arguments");
			else
				return new ListCommand();
		}
		else {
			return null;
		}
	}
	
	public boolean execute(Game game) {
		System.out.println(PlantFactory.listOfAvailablePlants());
		return false;
	}
}

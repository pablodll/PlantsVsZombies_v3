package tp.p3.control;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import tp.p3.exceptions.CommandExecuteException;
import tp.p3.exceptions.CommandParseException;
import tp.p3.logic.Game;

public class SaveCommand extends Command{

	private String filename;

	private static String commandText = "add";
	private static String commandTextMsg = "[A]dd <plant> <x> <y>";
	private static String helpTextMsg = "adds plant in position x, y.";

	public SaveCommand() {
		super(commandText, commandTextMsg, helpTextMsg);
	}

	public SaveCommand(String filename) {
		super(commandText, commandTextMsg, helpTextMsg);
		this.filename = filename;
	}
	
	public boolean execute(Game game, Controller controller) throws CommandExecuteException {
		// TODO Auto-generated method stub
		return false;
	}
	public Command parse(String[] commandWords, Controller controller) throws CommandParseException {
		if(commandWords[0].equals(this.commandName) || commandWords[0].equals(this.commandLetter)) {
			
			if(commandWords.length == 2) { 						
				return new SaveCommand(commandWords[1]);
			}
			else {
				throw new CommandParseException("Incorrect number of arguments for " + this.commandName + " command: " + commandTextMsg);
			}
	}
	else {
		return null;
	}
	}
}

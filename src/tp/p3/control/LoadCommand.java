package tp.p3.control;

import java.io.BufferedReader;
import java.io.PrintWriter;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException; SE RECOMIENDA LANZAR IOEXCEPTION


import tp.p3.exceptions.CommandExecuteException;
import tp.p3.exceptions.CommandParseException;
import tp.p3.logic.Game;

public class LoadCommand extends Command{

	private String filename;
	
	private static String commandText = "load";
	private static String commandTextMsg = "[Lo]ad <filename>";
	private static String helpTextMsg = "Load the state of the game from a file.";

	public LoadCommand() {
		super(commandText, commandTextMsg, helpTextMsg);
	}

	public LoadCommand(String filename) {
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
				return new LoadCommand(commandWords[1]);
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

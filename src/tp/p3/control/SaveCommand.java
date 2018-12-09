package tp.p3.control;

import java.io.BufferedWriter;
import java.io.FileWriter;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;

import tp.p3.exceptions.CommandExecuteException;
import tp.p3.exceptions.CommandParseException;
import tp.p3.logic.Game;

public class SaveCommand extends Command{

	private String filename;

	private BufferedWriter buffwriter = null;
	private Writer  writeOut = null;
	
	private static String commandText = "save";
	private static String commandTextMsg = "[S]ave <filename>";
	private static String helpTextMsg = "Save the state of the game to a file.";

	public SaveCommand() {
		super(commandText, commandTextMsg, helpTextMsg);
	}

	public SaveCommand(String filename) {
		super(commandText, commandTextMsg, helpTextMsg);
		this.filename = filename;

	}
	
	public boolean execute(Game game, Controller controller) throws CommandExecuteException {
		try{
			buffwriter = new BufferedWriter(new FileWriter(this.filename));
			buffwriter.write("Plants Vs Zombies 3.0");
			buffwriter.newLine();
			buffwriter.newLine();
			buffwriter.write(game.store());
			buffwriter.close();
			System.out.println("Game successfully saved in file " + this.filename + " Use the load command to reload it");
		}
		catch(IOException ex){
			System.err.println("IOException");
		}
		return true;
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

package tp.p3.control;

import java.io.BufferedWriter;
import java.io.FileWriter;

import tp.p3.util.MyStringUtils;
import tp.p3.exceptions.CommandExecuteException;
import tp.p3.exceptions.CommandParseException;
import tp.p3.logic.Game;

public class SaveCommand extends Command{

	private String filename;
	private static String extension = ".dat";
	
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
	
	public boolean execute(Game game) throws CommandExecuteException {
		if(MyStringUtils.isValidFilename(filename)) {
			try (BufferedWriter buffwriter = new BufferedWriter(new FileWriter(this.filename + extension))) {
				buffwriter.write("Plants Vs Zombies 3.0");
				buffwriter.newLine();
				buffwriter.newLine();
				buffwriter.write(game.store());
				System.out.println("Game successfully saved to file " + this.filename + extension + "; use the load command to reload it.");
				return true;
			}
			catch(Exception ex){
				throw new CommandExecuteException("Unexpected error saving the data");
			}
		}
		else{
			throw new CommandExecuteException("\"" + filename + "\" is not a valid file name.");
		}
	}
	
	public Command parse(String[] commandWords) throws CommandParseException {
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

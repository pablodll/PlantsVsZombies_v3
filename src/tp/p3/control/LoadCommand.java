package tp.p3.control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import tp.p3.util.MyStringUtils;
import tp.p3.exceptions.CommandExecuteException;
import tp.p3.exceptions.CommandParseException;
import tp.p3.logic.Game;

public class LoadCommand extends Command{

	private String filename;
	
	private BufferedReader inReader = null; 
	
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
		if(MyStringUtils.isValidFilename(filename) && MyStringUtils.isReadable(filename)) {
			try {
				inReader = new BufferedReader(new FileReader(filename));
				String title = inReader.readLine();
				if(title.equals("Plants Vs Zombies 3.0")) {
					inReader.readLine();
					game.load(inReader);
					System.out.println("Game successfully loaded from file " + filename);
					inReader.close();
				}
				else {
					inReader.close();
					throw new CommandExecuteException("Cabecera " + title +" no valida.");
				}
			}
			catch(IOException ex) {
				
			}
		}
		else {
			throw new CommandExecuteException("El fichero" + filename + "no es valido.");
		}
		
		return true;
	}
	public Command parse(String[] commandWords, Controller controller) throws CommandParseException {
		if(commandWords[0].equals(this.commandName) || commandWords[0].equals(commandName.substring(0, 2))) {
			
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

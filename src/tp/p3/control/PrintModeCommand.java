package tp.p3.control;

import tp.p3.logic.Game;
import tp.p3.logic.print.*;
import tp.p3.exceptions.*;

public class PrintModeCommand extends Command{

	private String mode;
	
	private static String commandText = "printmode";
	private static String commandTextMsg = "[P]rintMode <mode>";
	private static String helpTextMsg = "change print mode [Release|Debug].";
	
	public PrintModeCommand() {
		super(commandText, commandTextMsg, helpTextMsg);
	}
	
	public PrintModeCommand(String mode) {
		super(commandText, commandTextMsg, helpTextMsg);
		this.mode = mode;
	}
	
	public Command parse(String[] commandWords, Controller controller) throws CommandParseException{
		
		if(commandWords[0].equals(this.commandName) || commandWords[0].equals(this.commandLetter)) {
			
				if(commandWords.length == 2) { 
					
						if(commandWords[1].equals("debug") || commandWords[1].equals("release")) {
							return new PrintModeCommand(commandWords[1]);
						}
						else {
							throw new CommandParseException("Unknown print mode: " + commandWords[1]);
						}
				}
				else {
					throw new CommandParseException("Incorrect number of arguments for " + this.commandName + " command: " + this.helpText());
				}
		}
		else {
			return null;
		}
	}
	
	public boolean execute(Game game, Controller controller) {
		switch(mode) {
			case "release":
				controller.setPrinter(new ReleasePrinter(game));
				break;
			case "debug":
				controller.setPrinter(new DebugPrinter(game));
				break;
		}
		return true; // NO
	}
	
}

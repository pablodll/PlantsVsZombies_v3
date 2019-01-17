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
	
	public Command parse(String[] commandWords) throws CommandParseException{
		
		if(commandWords[0].equals(this.commandName) || commandWords[0].equals(this.commandLetter)) {
			
				if(commandWords.length == 2) { 						
					return new PrintModeCommand(commandWords[1]);
				}
				else {
					throw new CommandParseException("Incorrect number of arguments for " + this.commandName + " command: " + commandTextMsg);
				}
		}
		else {
			return null;
		}
	}
	
	public boolean execute(Game game) throws CommandExecuteException {
		
		boolean ret = false;
		
		GamePrinter printer = PrinterFactory.parsePrinter(this.mode, game);
		
		if(printer != null) {
			game.setPrinter(printer);
			ret = true;
		}
		else {
			throw new CommandExecuteException("Unknown print mode: " + mode);
		}
		
//		switch(mode) {
//			case "release":
//				game.setPrinter(new ReleasePrinter(game));
//				ret = true;
//				break;
//			case "debug":
//				game.setPrinter(new DebugPrinter(game));
//				ret = true;
//				break;
//			default:
//				throw new CommandExecuteException("Unknown print mode: " + mode);
//		}
		
		return ret;
	}
	
}

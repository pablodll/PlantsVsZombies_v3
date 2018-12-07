package tp.p3.control;

import tp.p3.exceptions.*;
import tp.p3.logic.Game;
import tp.p3.logic.factories.ZombieFactory;

public class ZombieListCommand extends NoParamsCommand{
	
	private static String commandText = "zombielist";
	private static String commandTextMsg = "[Z]ombie list";
	private static String helpTextMsg = "print the list of available zombies.";
	
	public ZombieListCommand() {
		super(commandText, commandTextMsg, helpTextMsg);
	}
	
	public NoParamsCommand parse(String[] commandWords, Controller controller) throws CommandParseException{
		if(commandWords[0].equals(this.commandName) || commandWords[0].equals(this.commandLetter)) {
			if(commandWords.length > 1)
				throw new CommandParseException(this.commandName + " command has no arguments");
			else
				return new ZombieListCommand();
		}
		else {
			return null;
		}
	}
	
	public boolean execute(Game game, Controller controller) {
		controller.setNoPrintGameState();
		System.out.println(ZombieFactory.listOfAvailableZombies());
		return true; // NO
	}
	
}

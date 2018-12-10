package tp.p3.control;

import tp.p3.exceptions.*;
import tp.p3.logic.Game;
import tp.p3.logic.entities.plants.*;
import tp.p3.logic.factories.PlantFactory;

public class AddCommand extends Command {

	private int x, y;
	private String plantName;

	private static String commandText = "add";
	private static String commandTextMsg = "[A]dd <plant> <x> <y>";
	private static String helpTextMsg = "adds plant in position x, y.";

	public AddCommand() {
		super(commandText, commandTextMsg, helpTextMsg);
	}

	public AddCommand(String plantName, int x, int y) {
		super(commandText, commandTextMsg, helpTextMsg);
		this.x = x;
		this.y = y;
		this.plantName = plantName;
	}

	public Command parse(String[] commandWords) throws CommandParseException {
		
		if (commandWords[0].equals(this.commandName) || commandWords[0].equals(this.commandLetter)) {
			
				if (commandWords.length == 4) {
					try {
						return new AddCommand(commandWords[1], Integer.parseInt(commandWords[2]), Integer.parseInt(commandWords[3]));
					} catch (NumberFormatException ex) {
						throw new CommandParseException("Invalid argument for " + this.commandName + " command, number expected: " + commandTextMsg);
					}
				}
				else
					throw new CommandParseException("Incorrect number of arguments for " + this.commandName + " command: " + commandTextMsg);
		} 
		else
			return null;
	}

	public boolean execute(Game game) throws CommandExecuteException{
		
		Plant plant = PlantFactory.getPlant(plantName);
			
		if (plant != null) {
			if (!game.addPlantToGame(plant, x, y)) {
				return false;
			}
		} 
		else {
			throw new CommandExecuteException("Unknown plant name: " + plantName);
		}
		return true;
	}
}

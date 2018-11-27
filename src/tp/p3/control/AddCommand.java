package tp.p3.control;

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

	public Command parse(String[] commandWords, Controller controller) {
		if ((commandWords[0].equals(this.commandName) || commandWords[0].equals(this.commandLetter))
				&& ((commandWords.length == 4))) {
			return new AddCommand(commandWords[1], Integer.parseInt(commandWords[2]),
					Integer.parseInt(commandWords[3]));
		} else {
			return null;
		}
	}

	public void execute(Game game, Controller controller) {
		if ((x >= 0 && x < game.getRows()) && (y >= 0 && y < game.getCols() - 1) && game.isEmpty(x, y)) {
			Plant plant = (Plant)PlantFactory.getPlant(plantName, x, y, game);

			if (plant != null) {
				if (!game.addPlantToGame(plant)) {
					System.err.println("The plant could not be added");
					controller.setNoPrintGameState();
				}
			} else {
				System.err.println("Invalid plant");
				controller.setNoPrintGameState();
			}
		} else {
			System.err.println("Invalid position");
			controller.setNoPrintGameState();
		}
	}
}

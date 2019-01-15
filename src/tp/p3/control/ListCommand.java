package tp.p3.control;

import tp.p3.logic.Game;
import tp.p3.logic.factories.PlantFactory;

public class ListCommand extends NoParamsCommand{
	
	private static String commandText = "list";
	private static String commandTextMsg = "[L]ist";
	private static String helpTextMsg = "print the list of available plants.";
	
	public ListCommand() {
		super(commandText, commandTextMsg, helpTextMsg);
	}
	
	public NoParamsCommand getThisCommand() {
		return new ListCommand();
	}
	
	public boolean execute(Game game) {
		System.out.println(PlantFactory.listOfAvailablePlants());
		return false;
	}
}

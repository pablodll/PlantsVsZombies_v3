package tp.p3.control;

import tp.p3.logic.Game;
import tp.p3.logic.factories.ZombieFactory;

public class ZombieListCommand extends NoParamsCommand{
	
	private static String commandText = "zombielist";
	private static String commandTextMsg = "[Z]ombie list";
	private static String helpTextMsg = "print the list of available zombies.";
	
	public ZombieListCommand() {
		super(commandText, commandTextMsg, helpTextMsg);
	}
	
	public NoParamsCommand getThisCommand() {
		return new ZombieListCommand();
	}
	
	public boolean execute(Game game) {
		System.out.println(ZombieFactory.listOfAvailableZombies());
		return true;
	}
	
}

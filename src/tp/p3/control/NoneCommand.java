package tp.p3.control;

import tp.p3.logic.Game;

public class NoneCommand extends NoParamsCommand {
	
	private static String commandText = "none";
	private static String commandTextMsg = "[N]one";
	private static String helpTextMsg = "skips cycle.";
	
	public NoneCommand() {
		super(commandText, commandTextMsg, helpTextMsg);
	}
	
	public NoParamsCommand getThisCommand() {
		return new NoneCommand();
	}
	
	public boolean execute(Game game) {
		return true;
	}
}

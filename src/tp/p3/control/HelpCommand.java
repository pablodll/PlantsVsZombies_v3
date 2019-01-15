package tp.p3.control;

import tp.p3.logic.Game;
import tp.p3.control.CommandParser;

public class HelpCommand extends NoParamsCommand{
	
	private static String commandText = "help";
	private static String commandTextMsg = "[H]elp";
	private static String helpTextMsg = "print this help message.";
	
	public HelpCommand() {
		super(commandText, commandTextMsg, helpTextMsg);
	}
	
	public NoParamsCommand getThisCommand() {
		return new HelpCommand();
	}
	
	public boolean execute(Game game) {
		System.out.println(CommandParser.commandHelp());
		return false;
	}
}

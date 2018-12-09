package tp.p3.control;

import tp.p3.exceptions.CommandParseException;

public class CommandParser {
	
	private static Command[] availableCommands = {
		new AddCommand(),
		new HelpCommand(),
		new ResetCommand(),
		new ExitCommand(),
		new ListCommand(),
		new NoneCommand(),
		new PrintModeCommand(),
		new ZombieListCommand(),
		new SaveCommand(),
		new LoadCommand(),
	};
	
	public static Command parseCommand(String[] commandWords) throws CommandParseException {
		Command command = null;
		int i = 0;
		while(command == null && i < availableCommands.length) {
			command = availableCommands[i].parse(commandWords);
			i++;
		}
		return command;
	}
	
	public static String commandHelp() {
		String help = "";
		for(Command command : availableCommands) {
			help += command.helpText();
			help += "\n";
		}
		return help;
	}
}

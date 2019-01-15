package tp.p3.control;

import tp.p3.exceptions.CommandParseException;

public abstract class NoParamsCommand extends Command {
	
	public NoParamsCommand(String commandText, String commandTextMsg, String helpTextMsg) {
		super(commandText, commandTextMsg, helpTextMsg);
	}

	public NoParamsCommand parse(String[] commandWords) throws CommandParseException{
		if(commandWords[0].equals(this.commandName) || commandWords[0].equals(this.commandLetter)) {
			if(commandWords.length > 1)
				throw new CommandParseException(this.commandName + " command has no arguments");
			else
				return getThisCommand();
		}
		else {
			return null;
		}
	}
	
	public abstract NoParamsCommand getThisCommand();
	
}

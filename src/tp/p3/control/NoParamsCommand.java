package tp.p3.control;

import tp.p3.exceptions.*;

public abstract class NoParamsCommand extends Command {
	
	public NoParamsCommand(String commandText, String commandTextMsg, String helpTextMsg) {
		super(commandText, commandTextMsg, helpTextMsg);
	}

	public abstract NoParamsCommand parse(String[] commandWords, Controller controller) throws CommandParseException;
}

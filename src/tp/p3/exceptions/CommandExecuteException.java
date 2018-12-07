package tp.p3.exceptions;

@SuppressWarnings("serial")
public class CommandExecuteException extends Exception {
	
	public CommandExecuteException() {
		super();
	}
	
	public CommandExecuteException(String msg) {
		super(msg);
	}
	
	public CommandExecuteException(Throwable ex) {
		super(ex);
	}
	
	public CommandExecuteException(String msg, Throwable ex) {
		super(msg, ex);
	}
	
}

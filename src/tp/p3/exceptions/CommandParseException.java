package tp.p3.exceptions;

@SuppressWarnings("serial")
public class CommandParseException extends Exception {
	
	public CommandParseException() {
		super();
	}
	
	public CommandParseException(String msg) {
		super(msg);
	}
	
	public CommandParseException(Throwable ex) {
		super(ex);
	}
	
	public CommandParseException(String msg, Throwable ex) {
		super(msg, ex);
	}
}

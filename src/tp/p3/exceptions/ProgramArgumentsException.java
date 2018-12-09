package tp.p3.exceptions;

@SuppressWarnings("serial")
public class ProgramArgumentsException extends Exception {
	
	public ProgramArgumentsException() {
		super();
	}
	
	public ProgramArgumentsException(String msg) {
		super(msg);
	}
	
	public ProgramArgumentsException(Throwable ex) {
		super(ex);
	}
	
	public ProgramArgumentsException(String msg, Throwable ex) {
		super(msg, ex);
	}
	
}

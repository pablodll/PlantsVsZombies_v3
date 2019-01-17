package tp.p3.exceptions;

@SuppressWarnings("serial")
public class SuncoinException extends Exception {
	
	public SuncoinException() {
		super();
	}
	
	public SuncoinException(String msg) {
		super(msg);
	}
	
	public SuncoinException(Throwable ex) {
		super(ex);
	}
	
	public SuncoinException(String msg, Throwable ex) {
		super(msg, ex);
	}
	
}

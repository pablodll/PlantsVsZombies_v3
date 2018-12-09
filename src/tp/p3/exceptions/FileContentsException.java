package tp.p3.exceptions;

@SuppressWarnings("serial")
public class FileContentsException extends Exception {
	
	public FileContentsException() {
		super();
	}
	
	public FileContentsException(String msg) {
		super(msg);
	}
	
	public FileContentsException(Throwable ex) {
		super(ex);
	}
	
	public FileContentsException(String msg, Throwable ex) {
		super(msg, ex);
	}
	
}

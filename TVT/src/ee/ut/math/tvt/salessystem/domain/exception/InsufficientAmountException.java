package ee.ut.math.tvt.salessystem.domain.exception;

public class InsufficientAmountException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InsufficientAmountException() {
		super();
	}
	
	public InsufficientAmountException(String s) {
		super(s);
	}

}

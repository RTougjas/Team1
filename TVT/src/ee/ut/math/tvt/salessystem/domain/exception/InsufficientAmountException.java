package ee.ut.math.tvt.salessystem.domain.exception;

import org.apache.log4j.Logger;



public class InsufficientAmountException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(InsufficientAmountException.class);
	
	public InsufficientAmountException() {
		super();
	}
	
	public InsufficientAmountException(String s) {
		super(s);
		log.error(s);
	}

}

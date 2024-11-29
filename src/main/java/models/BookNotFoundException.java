package models;

/**
 * Exception thrown when a requested book cannot be found in the library system.
 * It can be used to signal issues related to unavailable or "missing books".
 */
public class BookNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new BookNotFoundException with no detail message.
	 */
	public BookNotFoundException() {
		super();
	}

}

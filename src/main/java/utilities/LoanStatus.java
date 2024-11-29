package utilities;

/**
 * Show if you have to return your book or not
 */
public enum LoanStatus {
	/**
	 * CURRENT: if you can keep the book
	 */
	CURRENT,
	/**
	 * HISTORIC: if you have to leave it back
	 */
	HISTORIC;
}

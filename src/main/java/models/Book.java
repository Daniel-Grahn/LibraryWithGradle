package models;

/**
 * Represents a book in a library system.
 * A book has an author, an ISBN-number,
 * and additional attributes inherited from Material.
 */
public class Book extends Material {

	private String author;
	private String isbn;
	private int noOfPages;

	/**
	 * Constructs a new Book with the specified details.
	 * @param id         the unique identifier of the book
	 * @param title      the title of the book
	 * @param author     the name of the book's author
	 * @param isbn       the ISBN-number of the book
	 * @param branch     the branch of the library where the book is located
	 * @param noOfpages  the number of pages in the book
	 */
	public Book(int id, String title, String author, String isbn, String branch, int noOfpages) 
	{
		super(id,title,branch);
		this.author = author;
		this.isbn = isbn;
		this.noOfPages= noOfpages;
	}

	/**
	 * Gives who the author of the book is.
	 * @return the author's name
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Gives the ISBN-number of the book.
	 * @return the ISBN as a string
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * Prints a message indicating that
	 * the book has been sent for repair.
	 */
	public void sendForRepair() {
		System.out.println("Book has been sent for repair");
	}

	/**
	 * Retrieves the loan period for the book in days.
	 * The default loan period for books is 21 days.
	 * @return the loan period in days
	 */
	public int getLoanPeriod() {
		return 21;
	}
}

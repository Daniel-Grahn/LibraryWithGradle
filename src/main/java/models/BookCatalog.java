package models;

/**
 * Make a BookCatalog of 100 different books.
 */
public class BookCatalog {


	/**
	 * Gives an array containing the books in the catalog.
	 * @return an array of Book(s) objects currently in the catalog.
	 */
	private Book[] bookArray = new Book[100];
	private int nextPosition = 0;


	/**
	 * A default constructor.
	 */
	public BookCatalog() {

	}


	/**
	 * Retrieves the array containing the books in the catalog.
	 * @return an array of Book objects currently in the catalog
	 */
	public Book[] getBookArray() {
		return bookArray;
	}

	/**
	 * Retrieves the number of books currently in the catalog.
	 * @return the number of books in the catalog.
	 */
	public int getNumberOfBooks() {
		return nextPosition;
	}


	/**
	 * Adding a book to the class Bookcatalog (bc) and test if it has changed.
	 * @param newBook saves in bookArray.
	 */
	public void addBook(Book newBook) {
		bookArray[nextPosition] = newBook;
		nextPosition++;
	}

	/**
	 * Searches for a book in the catalog by its title.
	 * The search is case-insensitive and ignores leading or trailing whitespace.
	 * if the book is not find it throws an exception
	 * @param title the title of the book to search for
	 * @return a bookArray[counter] with the matching title
	 * @throws BookNotFoundException if no book with the specified title is found in the catalog
	 */
	public Book findBook(String title) throws BookNotFoundException
	{
		title = title.trim();
		
		for (int counter = 0; counter < nextPosition; counter++) {
			if (bookArray[counter].getTitle().equalsIgnoreCase(title)) {
				return bookArray[counter];
			}
		}
		throw new BookNotFoundException();
	}

}
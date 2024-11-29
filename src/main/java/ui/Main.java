package ui;

import models.Book;
import models.BookCatalog;
import models.BookNotFoundException;
import models.Customer;
import models.Loan;
import models.LoanAlreadyExistsException;
import utilities.GenderType;

/**
 * The Main class demonstrates how various classes in the library system can be used.
 * This class shows the creation of books, customers, and loans, as well as how to handle exceptions
 * and interact with a catalog of books.
 */
public class Main {

	/**
	 * Default constructor for the Main class.
	 * Initializes the Main object, though no specific initialization is required.
	 */
	public Main() {
		// Default constructor with no specific initialization.
	}

	/**
	 * The main method is the entry point of the application.
	 * It demonstrates the following:
	 * <ul>
	 *   <li>Creating and managing a book catalog.</li>
	 *   <li>Adding books to the catalog and searching for a book.</li>
	 *   <li>Handling exceptions such as when a book is not found.</li>
	 *   <li>Creating customer instances and displaying customer details.</li>
	 *   <li>Creating loans for customers and displaying loan details.</li>
	 * </ul>
	 *
	 * @param args command-line arguments (not used in this case).
	 */
	public static void main(String[] args) {

		// Create a book catalog
		BookCatalog bookCatalog = new BookCatalog();

		// Create and add books to the catalog
		Book book1 = new Book(1, "An introduction to Java", "Matt Greencroft", "12345", "Anytown Branch", 400);
		Book book2 = new Book(2, "Better Java", "Joe Le Blanc", "23456", "Anytown Branch", 150);

		bookCatalog.addBook(book1);
		bookCatalog.addBook(book2);

		// Attempt to find a book by title and handle exception if not found
		try {
			Book foundBook = bookCatalog.findBook("Better");
			System.out.println("We found " + foundBook.getTitle());
		} catch (BookNotFoundException e) {
			System.out.println("The book wasn't found");
		}

		// Example of a runtime exception
		int myTest = 1;
		try {
			if (myTest != 2) {
				throw new RuntimeException("Something went wrong");
			}
		} catch (RuntimeException e) {
			// Exception caught, continuing without action
		}

		// Create a customer and display their details
		Customer customer = new Customer("Mr", "Michael", "Smith", "1 The High Street", "1234", "a@b.com", 1, GenderType.MALE);
		System.out.println(customer.getExpiryDate());
		System.out.println(customer.getMailingName());

		// Display customer information
		System.out.println(customer);

		// Demonstrating equality check (customer equals itself)
		System.out.println(customer.equals(customer));

		// Create a loan for the customer and display loan details
		Loan firstLoan = new Loan(1, customer, book1);
		System.out.println(firstLoan.getDueDate());
		System.out.println(firstLoan);
	}
}
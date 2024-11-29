package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BookCatalogTest {

	private BookCatalog bc;
	private Book book1;

	public BookCatalogTest() {
		bc = new BookCatalog();
		book1 = new Book(1,"Learning Java","","","",0);
		bc.addBook(book1);
	}

	//G
	@Test
	public void testAddABook() {
		Book book2 = new Book(2,"Advanced Java","","","",0);
		bc.addBook(book2);
		assertEquals(2, bc.getNumberOfBooks(), "add a book to AddBook");
	}

	//G
	@Test
	public void testFindBook() {
		assertEquals("Learning Java",bc.getBookArray()[bc.getNumberOfBooks()-1].getTitle(),"Find Title Learning Java");
		assertEquals(book1 ,bc.getBookArray()[bc.getNumberOfBooks()-1],"Find right book");

		Book book2 = new Book(2,"Advanced Java","","","",0);
		bc.addBook(book2);

		assertEquals("Advanced Java",bc.getBookArray()[bc.getNumberOfBooks()-1].getTitle(),"Find right Title Advanced Java");
		assertEquals(book2 ,bc.getBookArray()[bc.getNumberOfBooks()-1],"Find right book");

	}

	//G
	@Test
	public void testFindBookIgnoringCase() {
		String book1TitleWithUpperCase = book1.getTitle().toUpperCase();
		Book foundBook = null;

		try{
			foundBook = bc.findBook(book1TitleWithUpperCase);
		}catch(BookNotFoundException e){
			fail("Book not found");
		}
		assertEquals(book1, foundBook,"UpperCase book were found");

		book1TitleWithUpperCase = book1.getTitle().toLowerCase();

		try{
			foundBook = bc.findBook(book1TitleWithUpperCase);
		}catch(BookNotFoundException e){
			fail("Book not found");
		}
		assertEquals(book1, foundBook,"LowerCase book were found");
	}

	//G
	@Test
	public void testFindBookWithExtraSpaces() {
		String book1TitelWithSpace = "     Learning Java   ";
		Book foundBook = null;

		try{
			foundBook = bc.findBook(book1TitelWithSpace);
		}catch(BookNotFoundException e){
			fail("Book not found");
		}
		assertEquals(book1, foundBook,"Space book were found");

	}

	//VG
	// This test should throw BookNotFoundException in order to pass.
	@Test
	public void testFindBookThatDoesntExist() throws BookNotFoundException {
		String notExistentBook = "Nonexistent Book öauvöinv945ytwykjdn";
		Book foundBook = null;

		try{
			foundBook = bc.findBook(notExistentBook);
			fail("It has to fail to succeed");
		}catch(BookNotFoundException e){
			assertNotEquals(notExistentBook,book1.getTitle(),"Book not found as planed");
		}
	}
}
package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookTest {

	// G
	@Test
	public void test2EqualBooks() {
		Book book1 = new Book(1, "Learning Java", "Author A", "123456789", "Main Branch", 300);
		Book book2 = new Book(2, "Learning Java", "Author A", "123456789", "Main Branch", 300);

		assertEquals(book1.getIsbn(), book2.getIsbn(), "Books with the same isbn number should be considered equal");

		if(book1.getIsbn().equals(book2.getIsbn())) {
			assertEquals(true,book1 != book2,"They are coppies becuse they have different id but same isbn number");
		}
		else{
			book2.sendForRepair();
		}
	}

	// G
	@Test
	public void test2NonEqualBooks() {
		Book book1 = new Book(1, "Learning Java", "Author A", "123456789", "Main Branch", 300);
		Book book2 = new Book(3, "Advanced Java", "Author B", "987654321", "Secondary Branch", 400);

		if(book1.getIsbn() != book2.getIsbn()) {
			assertNotEquals(book1.getIsbn(), book2.getIsbn(), "Books with different Isbn's should not be considered equal");
		}
		else {
			book2.sendForRepair();
		}

	}
}

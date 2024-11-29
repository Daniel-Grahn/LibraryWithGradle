package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import utilities.GenderType;
import utilities.LoanStatus;

public class LoanTest {

	//VG
	@Test
	public void testDueDate() {
		Book book1 = new Book(1, "Learning Java", "Author A", "123456789", "Main Branch", 300);
		Customer customer = new Customer("Mr", "Michael", "Smith", "1 The High Street","1234","a@b.com",1, GenderType.MALE);
		Loan loan = new Loan(book1.getID(), customer, book1);
		assertEquals(LoanStatus.CURRENT,loan.getStatus(),"get book loan for 14 days" );

		//14 days Later
		loan.endLoan();
		assertEquals(LoanStatus.HISTORIC,loan.getStatus(),"Loan has ended" );
		System.out.println(loan.getDueDate());

   }
}
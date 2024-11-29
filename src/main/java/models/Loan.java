package models;


import java.util.Date;
import java.util.GregorianCalendar;

import java.time.LocalDate;
import utilities.LoanStatus;

/**
 * Represents a loan in a library system.
 * A loan is associated with a specific customer, a book, and includes details
 * such as the loan start date, due date, return date, and current status.
 */
public class Loan {

private int ID;
private Customer customer;
private Book book;
private Date startDate;
private LocalDate dueDate;
private Date returnDate;
private LoanStatus status;

  /**
   * A constructor for a loan
   * @param iD the unique identifier for this loan
   * @param customer the customer associated with the loan
   * @param book the book being loaned
   */
  public Loan(int iD, Customer customer, Book book) {
  super();
  ID = iD;
  this.customer = customer;
  this.book = book;  
  dueDate = LocalDate.now().plusDays(14);
  status = LoanStatus.CURRENT;
}

@Override
public String toString() {
  return "Loan [ID=" + ID + ", customer=" + customer.getMailingName() + ", book=" + book.getTitle()
    + "]";
}

@Override
public int hashCode() {
  final int prime = 31;
  int result = 1;
  result = prime * result + ID;
  return result;
}

@Override
public boolean equals(Object obj) {
  if (this == obj)
    return true;
  if (obj == null)
    return false;
  if (getClass() != obj.getClass())
    return false;
  Loan other = (Loan) obj;
  if (ID != other.ID)
    return false;
  return true;
}

  /**
   * return who the customer is.
   * @return customer
   */
  public Customer getCustomer() {
  return customer;
}

  /**
   * return the book
   * @return book
   */
  public Book getBook() {
  return book;
}

  /**
   * return dueDate Which is the day the book should be returned.
   * @return dueDate
   */
  public LocalDate getDueDate() {
  return dueDate;
}

  /**
   *return the status if the book is CURRENT or HISTORIC
   * @return status
   */
  public LoanStatus getStatus() {
  return status;
}

  /**
   * change the status to HISTORIC instead of CURRENT
   */
  public void endLoan() {
  returnDate = new Date();
  status = LoanStatus.HISTORIC;
}
	
}

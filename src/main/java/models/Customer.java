package models;
import java.util.Date;
import java.util.GregorianCalendar;

import utilities.GenderType;

/**
 * Represents a customer in the library system.
 * A customer is identified by their personal details such as name, address,
 * phone number, and email. Each customer has a unique customer number,
 * a gender, a validity status, and a membership expiry date.
 */
public class Customer {

	private String title;
	private String firstName;
	private String surname;
	private String address;
	private String phoneNumber;
	private String email;
	private int customerNumber;
	private GenderType gender;
	private boolean isvalid;
	private Date expiryDate;

	/**
	 * Constructs a new {@code Customer} object with the specified details.
	 * The membership expiry date is set to one year from the date of creation.
	 *
	 * @param title the customer's title (e.g., Mr., Mrs., Dr.)
	 * @param firstName the customer's first name
	 * @param surname the customer's surname
	 * @param address the customer's address
	 * @param phoneNumber the customer's phone number
	 * @param email the customer's email address
	 * @param customerNumber a unique number identifying the customer
	 * @param gender the gender of the customer
	 */
	public Customer(String title, String firstName, String surname, String address,
			String phoneNumber, String email, int customerNumber, GenderType gender) {

		setName(title, firstName, surname);
		this.address = address;
		this.phoneNumber=phoneNumber;
		this.email = email;
		this.customerNumber = customerNumber;
		this.gender = gender;
		this.isvalid = true;
		GregorianCalendar gCal = new GregorianCalendar();
		gCal.add(GregorianCalendar.YEAR, 1);
		this.expiryDate = gCal.getTime();
	}

	/**
	 * Returns the customer's first name.
	 * @return the first name of the customer
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Returns the customer's surname.
	 *
	 * @return the surname of the customer
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * If needed, the customer's surname can be updated.
	 *
	 * @param surname the new surname of the customer
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Updates the customer's title, first name, and surname.
	 * This method is private and used internally to initialize or update the name.
	 * @param title the customer's title
	 * @param firstName the customer's first name
	 * @param surname the customer's surname
	 */
	private void setName(String title, String firstName, String surname) {
		this.title = title;
		this.firstName = firstName;
		this.surname = surname;
	}

	/**
	 * Returns a mailing name for the customer in the format
	 * @return the formatted mailing name of the customer
	 */
	public String getMailingName() {
		StringBuilder sb = new StringBuilder(title);
		sb.append(" ");
		sb.append(firstName.substring(0,1));
		sb.append(" ");
		sb.append(surname);
		
		return sb.toString(); 
	}

	/**
	 * Returns the gender of the customer.
	 *
	 * @return the gender of the customer
	 */
	public GenderType getGender() {
		return gender;
	}

	/**
	 * Returns the membership expiry date of the customer.
	 * @return the expiry date of the customer's membership
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * Returns a string representation of the customer, which is their mailing name.
	 * @return a string representation of the customer
	 */
	@Override
	public String toString() {
		return getMailingName();
	}

	/**
	 * Computes a hash code for this customer based on various fields,
	 * including address, customer number, email, expiry date, name, gender, and validity.
	 * @return the hash code for this customer
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + customerNumber;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + (isvalid ? 1231 : 1237);
		result = prime * result
				+ ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/**
	 * Compares this customer with another object for equality.
	 * Two customers are considered equal if all their fields match.
	 *
	 * @param obj the object to compare with
	 * @return true if the two customers are equal, else false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (customerNumber != other.customerNumber)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (expiryDate == null) {
			if (other.expiryDate != null)
				return false;
		} else if (!expiryDate.equals(other.expiryDate))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender != other.gender)
			return false;
		if (isvalid != other.isvalid)
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
}

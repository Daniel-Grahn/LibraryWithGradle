package models;


/**
 * Abstract class representing a material in a library system.
 * Each material has an ID, a title, a branch where it is located,
 * and an optional borrower if the material is currently lent out.
 */
public abstract class Material {

	private int id;
	private String title;
	private String branch;
	private Customer borrower;

	/**
	 * Constructs a new Material with the specified ID, title, and branch.
	 * @param id    the unique identifier for the material.
	 * @param title the title of the material.
	 * @param branch the branch where the material is initially located.
	 */
	public Material(int id, String title, String branch) {
		this.id = id;
		this.title = title;
		this.branch = branch;
	}

	/**
	 * Returns the title of the material.
	 * @return the title of the material.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Returns the unique ID of the material.
	 * @return the unique ID of the material.
	 */
	public int getID() {
		return id;
	}

	/**
	 * Relocates the material to a new branch.
	 * (Has no usage right now.)
	 * @param newBranch the name of the new branch.
	 */
	public void relocate (String newBranch) {
		this.branch = newBranch;
	}

	/**
	 * Attempts to lend the material to a customer.
	 * The lending is successful only if the material is not already borrowed.
	 *
	 * @param customer the customer who wants to borrow the material.
	 * @return true if the material was successfully lent or
	 * 		   false if it is already borrowed.
	 */
	public boolean lend(Customer customer) {
		if (borrower == null) {
			borrower = customer;
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Returns the loan period for the material.
	 * This method must be implemented by subclasses.
	 *
	 * @return the loan period in days.
	 */
	public abstract int getLoanPeriod();


	/**
	 * Returns the string representation of the material, which is its title.
	 *
	 * @return the title of the material.
	 */
	@Override
	public String toString() {
		return title;
	}

	/**
	 * Compares this material to another object for equality.
	 * Two materials are considered equal if they have the same ID.
	 * @param obj the object to compare to this material.
	 * @return true if the given object is a Material
	 * 		   with the same ID, else false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		
		if (obj == null) {
			return false;
		}
		
		if (getClass() == obj.getClass())
		{
			Material otherClass = (Material)obj;
			if (id == otherClass.id) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	
}

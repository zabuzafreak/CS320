package f;

public class Contact{
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String contactAddress;
	
	// constructor
	public Contact(String id, String firstName, String lastName, String phoneNumber, String contactAddress) {
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID");
		}
		
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		
		if (phoneNumber == null || phoneNumber.length() > 10 || phoneNumber.length() < 10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		
		if (contactAddress == null || contactAddress.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		this.contactID = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.contactAddress = contactAddress;
	}
	
	// getters
	public String getContactID() {
		return this.contactID;
	}
	
	public String getName() {
		return this.firstName + " " + this.lastName;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public String getContactAddress() {
		return this.contactAddress;
	}
	
	// setters
	public void setContactID(String newId) {
		if (newId == null || newId.length() > 10) {
			throw new IllegalArgumentException("No Such ID");
		}
		
		contactID = newId;
	}
	
	public void setFirstName(String newFirstName) {
		if (newFirstName == null || newFirstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		
		firstName = newFirstName;
	}
	
	public void setLastName(String newLastName) {
		if (newLastName == null || newLastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		
		lastName = newLastName;
	}
	
	public void setPhoneNumber(String newPhoneNumber) {
		if (newPhoneNumber == null || newPhoneNumber.length() > 10 || newPhoneNumber.length() < 10) {
			throw new IllegalArgumentException("Invalid phone number");
		}

		phoneNumber = newPhoneNumber;
	}
	
	public void setContactAddress(String newContactAddress) {
		if (newContactAddress == null || newContactAddress.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		contactAddress = newContactAddress;
	}
	
	
}
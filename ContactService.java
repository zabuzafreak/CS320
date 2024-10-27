package f;

import java.util.Vector;
import java.util.Random;

public class ContactService {
	
	// Vector Used to Store All Contacts.
	private Vector<Contact> Contacts = new Vector<Contact>();
	
	// For Storing the Number of Contacts.
	private int numberOfContacts = 0;
	
	// Getter for Number of Contacts
	public int getNumContacts() {
		return numberOfContacts;
	}
	
	// Getter for List
	public Vector<Contact> getContactLIst(){
		return Contacts;
	}
	
	// Adding Contact To List.
	public void addContact(String contactID, String firstName, String lastName, String phoneNumber, String contactAddress) {
		// Creating New Contact
		Contact newContact = new Contact(contactID, firstName, lastName, phoneNumber, contactAddress);
		
		Contacts.add(newContact);
		
		numberOfContacts++;
	}
	
	public void addContact(Contact contact) {
		// Add Contact
		Contacts.add(contact);
		
		numberOfContacts++;
	}
	
	// Adding Contacts to List.
	public void removeContact(String contactID) {
		
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("No Such ID");
		}
		
		if (Contacts.isEmpty()) {
			throw new IllegalArgumentException("No Saved Contacts.");
		}
		
		int index = -1;
		for (Contact c: Contacts) {
			if (c.getContactID() == contactID) {
				index = Contacts.indexOf(c);
			}
		}
		
		if (index == -1) {
			System.out.println("Not found.");
			return;
		}
		
		else {
			Contacts.remove(index);
			numberOfContacts--;
			System.out.println("Removed.");
		}
	}
	
	public void removeContact(Contact contact) {
		Contacts.remove(contact);
		numberOfContacts --;
	}
	
	// Updating Contacts
	void updateContact(String ID, String update, int selection) {
		if (ID == null || ID.length() > 10 || update == null || selection < 0) {
			throw new IllegalArgumentException("No Such ID");
		}
		
		if (Contacts.isEmpty()) {
			throw new IllegalArgumentException("No contacts to update.");
		}
		
		int index = -1;
		
		for (Contact c: Contacts) {
			if (c.getContactID() == ID) {
				index = Contacts.indexOf(c);
			}
		}
		
		if (index == -1) {
			System.out.println("Not found");
			return;
		}
		
		Contact updatedContact = Contacts.get(index);
		
		switch(selection) {
			case 1:{
				updatedContact.setFirstName(update);
				break;
			}
			
			case 2:{
				updatedContact.setLastName(update);
				break;
			}
			
			case 3:{
				updatedContact.setPhoneNumber(update);
				break;
			}
			
			case 4:{
				updatedContact.setContactAddress(update);
				break;
			}
			
			default:{
				removeContact(Contacts.elementAt(index));
				addContact(updatedContact);
			}
		}
		
	}
	
	public void updatedContact(String ID, String firstName, String lastName, String phoneNumber, String contactAddress) {
		if (ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID.");
		}
		
		if (Contacts.isEmpty()) {
			throw new IllegalArgumentException("There are no contacts.");
		}
		
		int index = -1;
		
		for (Contact c: Contacts) {
			if (c.getContactID() == ID) {
				index = Contacts.indexOf(c);
			}
		}
		
		if (index == -1) {
			System.out.println("Not found");
			return;
		}
		
		Contact tempContact = Contacts.get(index);
		
		tempContact.setFirstName(firstName);
		tempContact.setFirstName(lastName);
		tempContact.setFirstName(phoneNumber);
		tempContact.setFirstName(contactAddress);
		
		Contacts.remove(index);
		Contacts.add(tempContact);
	}
	
	public String generateUniqueId() {
		Random rand = new Random();
		int newID = rand.nextInt(1000000000);
		String uniqueID = Integer.toString(newID);
		
		for (Contact c: Contacts) {
			while(c.getContactID() == uniqueID) {
				newID = rand.nextInt(1000000000);
				uniqueID = Integer.toString(newID);
			}
		}
		
		System.out.println("New Contact ID created: " + uniqueID);
		return uniqueID;
	}
}
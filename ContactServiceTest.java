package f;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

	
	@Test
	void testAddContactMethod() {
		// create a contact
		ContactService contactService = new ContactService();
		String testContactID = contactService.generateUniqueId();
		Contact contact = new Contact(testContactID, "Blue", "Red", "4445556666", "12345 Fake Street");
		
		// add contact to the list
		contactService.addContact(contact);
		
		// confirm contact is in the list, count is not zero
		assertTrue(!contactService.getContactLIst().isEmpty());
		assertTrue(contactService
				.getContactLIst()
				.elementAt(0)
				.getContactID()
				.equals(testID));
		assertTrue(contactService.getNumContacts() > 0);
	}
	
	@Test
	void testRemoveContactMethod() {
		ContactService contactService = new ContactService();
		// create new contact
		Contact contact = new Contact("111111", "Blue", "Red", "4445556666", "12345 Fake Street");
		
		// try to remove with null id
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.removeContact("");
		});
		
		// try to remove with id that's too long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.removeContact("12345678901");
		});
		
		// try to remove from empty list
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.removeContact("1234567890");
		});
		
		// add the contact
		contactService.addContact(contact);
		
		// remove a contact that isn't there
		contactService.removeContact("123456");
		
		// contact list is not empty, count is not zero
		// contact not removed because contact doesn't exist
		assertTrue(!contactService.getContactLIst().isEmpty());
		assertTrue(contactService.getNumContacts() != 0);
		
		// remove correct contact
		contactService.removeContact("111111");
		
		// list is empty, count is zero, contact successfully removed
		assertTrue(contactService.getNumContacts() == 0);
		assertTrue(contactService.getContactLIst().isEmpty());
		
	}
	
	@Test
	void testUpdateContactMethodErrors() {
		ContactService contactService = new ContactService();
		// contact list is empty
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact("111111", "Green", 1);
		});
		
		// create new contact, add to list
		Contact contact = new Contact("111111", "Red", "Blue", "4445556666", "12345 Fake Street");
		contactService.addContact(contact);
		// check that contact was added
		assertTrue(!contactService.getContactLIst().isEmpty());
		
		// id is too long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact("12345678901", "Green", 1);
		});
		// id is null
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact(null, "Green", 1);
		});
		// update value is null
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact("111111", null, 1);
		});
		// selection value is less than zero
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact("111111", "Green", -1);
		});
		
		// print "contact not found" to console
		contactService.updateContact("123456", "Green", 1);
		
		// print "contact not updated" to console
		contactService.updateContact("111111", "Green", 5);
		
	}
	
	@Test
	void testUpdateContactMethod() {
		ContactService contactService = new ContactService();
		Contact contact = new Contact("111111", "Red", "Blue", "4445556666", "12345 Fake Street");
		contactService.addContact(contact);
		assertTrue(!contactService.getContactLIst().isEmpty());
		
		// update first name
		contactService.updateContact("111111", "Green", 1);
		assertTrue(contactService
				.getContactLIst()
				.elementAt(0)
				.getName()
				.equals("Green Blue"));
		// update last name
		contactService.updateContact("111111", "Yellow", 2);
		assertTrue(contactService
				.getContactLIst()
				.elementAt(0)
				.getName()
				.equals("Green Yellow"));
		// update phone number
		contactService.updateContact("111111", "7778889999", 3);
		assertTrue(contactService
				.getContactLIst()
				.elementAt(0)
				.getPhoneNumber()
				.equals("7778889999"));
		// update address
		contactService.updateContact("111111", "54321 Fake Ave", 4);
		assertTrue(contactService
				.getContactLIst()
				.elementAt(0)
				.getContactAddress()
				.equals("54321 Fake Ave"));
		
		// update first name too long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact("111111", "GreenYellow", 1);
		});
				
		// check that list has been updated
		// only one contact in list, check that it's updated by checking name
		assertTrue(contactService.getNumContacts() == 1);
		assertTrue(contactService.getContactLIst().elementAt(0)
				.getName().equals("Green Yellow"));
				
	}

}
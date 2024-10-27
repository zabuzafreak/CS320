package f;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ContactTest {
	
	@Test
	void testContactNullArguments() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact(null, null, null, null, null);
		});
	}
	
	@Test
	void testContactAndGetters() {
		Contact contact = new Contact("111111", "Pete", "Krentz", "1112223333", "321 Fake Ave.");
		assertTrue(contact.getName().equals("Pete Krentz"));
		assertTrue(contact.getPhoneNumber().equals("1112223333"));
		assertTrue(contact.getContactAddress().equals("321 Fake Ave."));
		assertTrue(contact.getContactID().equals("111111"));
	}
	
	@Test
	void testSetFirstAndLastName() {
		Contact contact = new Contact("111111", "Pete", "Krentz", "1112223333", "321 Fake Ave.");
		contact.setFirstName("Pete");
		contact.setLastName("Krentz");
		assertTrue(contact.getName().equals("Pete Krentz"));
	}
	
	@Test
	void testSetPhoneNumberAndAddress() {
		Contact contact = new Contact("111111", "Pete", "Krentz", "1112223333", "321 Fake Ave.");
		contact.setPhoneNumber("1112223333");
		contact.setContactAddress("321 Fake Ave.");
		assertTrue(contact.getPhoneNumber().equals("1112223333"));
		assertTrue(contact.getContactAddress().equals("321 Fake Ave."));
	}
	
	@Test
	void testNullSetAttributes() {
		Contact contact = new Contact("111111", "Pete", "Krentz", "1112223333", "321 Fake Ave.");
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setFirstName(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setLastName(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setContactAddress(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setPhoneNumber(null);
		});
	}
	
	@Test
	void testAllGetters() {
		Contact contact = new Contact("111111", "Pete", "Krentz", "1112223333", "321 Fake Ave.");
		assertTrue(contact.getName().equals("Pete Krentz"));
		assertTrue(contact.getContactID().equals("111111"));
		assertTrue(contact.getPhoneNumber().equals("1112223333"));
		assertTrue(contact.getContactAddress().equals("321 Fake Ave."));
	}

}
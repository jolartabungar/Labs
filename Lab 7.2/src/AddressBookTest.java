import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;

/**
 * @author Jolar Tabungar 101030060
 * @version 2018.10.30
 *
 */
public class AddressBookTest {
	
	private AddressBook aAddressBook;
	private BuddyInfo kenobiBuddy;
	private BuddyInfo benBuddy;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		aAddressBook = new AddressBook();
		kenobiBuddy = new BuddyInfo("Obi-wan Kenobi", "12-26 Lexington Street London", "111-111-1111", "Hello There!",
				47);
		benBuddy = new BuddyInfo("Ben Kenobi", "Tatooine", "777-777-7777", "Hello There!",
				60);
	}
	
	@Test
	public void testEmptyAddressBook() {
		assertEquals("AddressBook should be empty", 0, aAddressBook.size());
	}
	
	@Test
	public void testAddressBookWithOneBuddy() {
		aAddressBook.addBuddy(kenobiBuddy);
		assertEquals("AddressBook size should be 1.", 1, aAddressBook.size());
	}
	
	@Test
	public void testAddressBookWithTwoBuddies() {
		aAddressBook.addBuddy(kenobiBuddy);
		aAddressBook.addBuddy(benBuddy);
		assertEquals("AddressBook size should be 2.", 2, aAddressBook.size());
	}
	
	@Test
	public void testAddressBookClear() {
		aAddressBook.addBuddy(kenobiBuddy);
		aAddressBook.addBuddy(benBuddy);
		aAddressBook.clear();
		assertEquals("AddressBook should be empty with size 0.", 0, aAddressBook.size());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		//Not Used
	}

	
}

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
public class BuddyInfoTest {

	private BuddyInfo kenobiBuddy;
	private BuddyInfo copyBuddy;
	private BuddyInfo over18Buddy;
	private BuddyInfo under18Buddy;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		kenobiBuddy = new BuddyInfo("Obi-wan Kenobi", "12-26 Lexington Street London", "111-111-1111", "Hello There!",
				47);
		over18Buddy = new BuddyInfo(null, null, null, null, 19);
		under18Buddy = new BuddyInfo(null, null, null, null, 5);
	}

	@Test
	public void testCopyBuddyInfo() {
		copyBuddy = new BuddyInfo(kenobiBuddy);
		assertTrue("BuddyInfo should be the same as parameter BuddyInfo", copyBuddy.equals(kenobiBuddy));
	}

	@Test
	public void testBuddyInfoGreeting() {
		assertEquals("Greetings should be equal", kenobiBuddy.getGreeting(), "Hello There!");
	}

	@Test
	public void testBuddyOver18() {
		assertTrue("Age should be over 18.", over18Buddy.isOver18());
	}

	@Test
	public void testBuddyUnder18() {
		assertFalse("Age should be under 18.", under18Buddy.isOver18());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		//Not Used
	}

}

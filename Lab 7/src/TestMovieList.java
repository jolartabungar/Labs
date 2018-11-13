import junit.framework.TestCase;

public class TestMovieList extends TestCase {

	private MovieList movieList = null;
	private Movie starWars = null;
	private Movie starTrek = null;
	private Movie stargate = null;

	protected void setUp() {
		movieList = new MovieList();
		starWars = new Movie("Star Wars");
		starTrek = new Movie("Star Trek");
	}

	public void testEmptyListSize() {
		assertEquals("Size of empty movie list should be 0.", 0, movieList.size());
	}

	public void testSizeAfterAddingOne() {
		movieList.add(starWars);
		assertEquals("Size of one item list should be 1.", 1, movieList.size());
	}

	public void testSizeAfterAddingTwo() {
		movieList.add(starWars);
		movieList.add(starTrek);
		assertEquals("Size of a two item list should be 2.", 2, movieList.size());
	}

	public void testContents() {
		movieList.add(starWars);
		movieList.add(starTrek);
		assertTrue("List should contain starWars.", movieList.contains(starWars));
		assertTrue("List should contain starTrek.", movieList.contains(starTrek));
		assertFalse("List should not contain stargate.", movieList.contains(stargate));
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(TestMovieList.class);
	}

}

import junit.framework.TestCase;

public class TestMovieListWithEmptyList extends TestCase {
	private MovieList movieList = null;

	protected void setUp() {
		movieList = new MovieList();
	}

	public void testSize() {
		assertEquals("Size of empty movie list should be 0.", 0, movieList.size());
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(TestMovieListWithEmptyList.class);
	}
}

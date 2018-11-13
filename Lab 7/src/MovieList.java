import java.util.*;

public class MovieList {

	private int numberOfMovies = 0;
	private Collection movies = new ArrayList();

	public int size() {
		return movies.size();
	}

	public void add(Movie aMovie) {
		numberOfMovies++;
		movies.add(aMovie);
	}

	public boolean contains(Movie aMovie) {
		return movies.contains(aMovie);
	}

}

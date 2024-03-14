import java.util.HashMap;
import java.util.Map;
public class User {
	String name;
	Movie favoriteMovie;
    Map<String, Movie> watchedMovies;
    

    public User(String name) {
        this.name = name;
		favoriteMovie = new Movie();
        watchedMovies = new HashMap<>();
    }
    public User() {
        this.name = null;
		favoriteMovie = new Movie();
        watchedMovies = new HashMap<>();
    }
    public void addMovie(Movie movie) {
        watchedMovies.put(movie.title, movie);
    }
	public void setFavoriteMovie(Movie movie){
		favoriteMovie=movie;
	}
}
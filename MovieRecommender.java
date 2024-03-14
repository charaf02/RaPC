import java.util.HashMap;
import java.util.Map;
public class MovieRecommender {
	Map<String, User> users;
    Map<String, Movie> movies;
    
    MovieRecommender() {
        users = new HashMap<>();
        movies = new HashMap<>();

        // Add some sample users and movies
        User user1 = new User("Max");
		user1.addMovie(new Movie("Fight Club", "Thriller","English",8.8));
        user1.addMovie(new Movie("Saving Private Rayan", "War","English",8.6));
        user1.addMovie(new Movie("Goodfellas", "Crime","English",8.7));
        user1.addMovie(new Movie("Le Samorai", "Crime", "French",8.));
        user1.addMovie(new Movie("City of God", "Crime","Portugues",8.6));
		user1.setFavoriteMovie(new Movie("Saving Private Rayan", "War","English",8.6));
        users.put(user1.name, user1);

        User user2 = new User("John");
        user2.addMovie(new Movie("The Godfather", "Crime","English",9.2));
        user2.addMovie(new Movie("A Separation", "Drama","Iranian",8.3));
        user2.addMovie(new Movie("The Deer Hunter", "War","English",8.2));
		user2.addMovie(new Movie("Alexandria... Why?", "Drama", "Arabic",7.7));
		user2.addMovie(new Movie("It's a Wonderful Life", "Drama", "English",8.6));
		user2.setFavoriteMovie(new Movie("The Deer Hunter", "War","English",8.2));
        users.put(user2.name, user2);

		User user3 = new User("Anna");
        user3.addMovie(new Movie("The Shawshank Redemption", "Drama","English",9.3));
        user3.addMovie(new Movie("The Best of Youth", "Drama","Italian",8.5));
        user3.addMovie(new Movie("spirited Away", "Animation","Japanese",8.6));
		user3.addMovie(new Movie("Life is Beatiful", "War", "Italian",8.6));
		user3.addMovie(new Movie("Heat", "Crime", "English",8.3));
		user3.setFavoriteMovie(new Movie("The Best of Youth", "Drama","Italian",8.5));
        users.put(user3.name, user3);

        movies.put("Fight Club"  , new Movie("Fight Club", "Thriller","English",8.8));
        movies.put( "Saving Private Rayan", new Movie("Saving Private Rayan", "War","English",8.6));
        movies.put( "Goodfellas", new Movie("Goodfellas", "Crime","English",8.7));
        movies.put( "Le Samorai", new Movie("Le Samorai", "Crime", "French",8.));
        movies.put( "City of God", new Movie("City of God", "Crime","Portugues",8.6));
		movies.put( "The Godfather", new Movie("The Godfather", "Crime","English",9.2));
        movies.put( "A Separation", new Movie("A Separation", "Drama","Iranian",8.3));
        movies.put( "The Deer Hunter", new Movie("The Deer Hunter", "War","English",8.2));
		movies.put( "Alexandria... Why?", new Movie("Alexandria... Why?", "Drama", "Arabic",7.7));
		movies.put( "It's a Wonderful Life", new Movie("It's a Wonderful Life", "Drama", "English",8.6));
		movies.put( "The Shawshank Redemption", new Movie("The Shawshank Redemption", "Drama","English",9.3));
        movies.put( "The Best of Youth", new Movie("The Best of Youth", "Drama","Italian",8.5));
        movies.put( "spirited Away", new Movie("spirited Away", "Animation","Japanese",8.6));
		movies.put( "Life is Beatiful", new Movie("Life is Beatiful", "War", "Italian",8.6));
		movies.put( "Heat", new Movie("Heat", "Crime", "English",8.3));


    }
    public double Similarity(Movie film1,Movie film2 ) {
    	int w1=2 ,w2=1,w3=3;
    	int sim1=0,sim2=0;
		double sim3=0;
    	int range=10;
    	if(film1.genre.equals(film2.genre)) sim1=1;
    	if(film1.language.equals(film2.language ))sim2=1;
    	sim3=1-Math.abs(film1.rating-film2.rating)/range;
    	return (sim1*w1+sim2*w2+sim3*w3)/(w1+w2+w3);
    }
	public Movie recommendMovie(User  user) {
    	User voisinUser= new User();
    	double similarity=0;
    	for(User otherUser : users.values()) {
    		if(!otherUser.name.equals(user.name)) {
    			if (Similarity(otherUser.favoriteMovie,user.favoriteMovie)>similarity) {
    				similarity=Similarity(otherUser.favoriteMovie,user.favoriteMovie);
    				voisinUser=otherUser;
    			}
    		}
    	}
    	similarity=0;
    	Movie Solution = new Movie();
    	for(Movie otherMovie : voisinUser.watchedMovies.values()) {
    		if(!user.watchedMovies.containsKey(otherMovie.title)) {
    			if(Similarity(otherMovie,user.favoriteMovie)>similarity) {
    				similarity=Similarity(otherMovie,user.favoriteMovie);
    				Solution=otherMovie;
    			}
    		}
    	}
    	return Solution;	
    }
}
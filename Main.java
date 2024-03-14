import java.util.HashMap;
import java.util.Map;
public class Main {
	public static void main(String[] args) {
		MovieRecommender recommender = new MovieRecommender();
        User user = recommender.users.get("Max");
        Movie recommendedMovie = recommender.recommendMovie(user);
        System.out.println("Recommended movie for " +user.name + ": " + recommendedMovie.title);

	}

}

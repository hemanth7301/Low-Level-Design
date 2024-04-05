import java.util.*;

public class MovieController {
    Map<City,List<Movie>>cityVsMovies;
    List<Movie>allMovies;
    public MovieController(){
        cityVsMovies= new HashMap<>();
        allMovies=new ArrayList<>();
    }

    public void addMovie(Movie movie, City city){
        allMovies.add(movie);
        List<Movie>movies=cityVsMovies.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityVsMovies.put(city, allMovies);
    }

    public Movie getMoviesByName(String movieName){
        for(Movie movie: allMovies){
            if(movie.getMovieName().equals(movieName)){
                return movie;
            }
        }
        return null;
    }

    public List<Movie> getMoviesByCity(City city){
        return cityVsMovies.get(city);
    }
}

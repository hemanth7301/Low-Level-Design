import java.util.*;

public class TheaterController {
    Map<City,List<Theater>>cityVsTheatres;
    List<Theater>allTheatres;
    public TheaterController(){
        cityVsTheatres= new HashMap<>();
        allTheatres=new ArrayList<>();
    }

    public void addTheatre(Theater theatre, City city){
        allTheatres.add(theatre);
        List<Theater>theatres=cityVsTheatres.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        cityVsTheatres.put(city, theatres);
    }

    public Map<Theater,List<Show>> getAllTheaters(City city,Movie movie){
        Map<Theater,List<Show>>theaterVsShows=new HashMap<>();
        List<Theater>theaters=cityVsTheatres.get(city);
        
        for(Theater theater:theaters){
            List<Show>givenMovieShows = new ArrayList<>();
            List<Show>shows =theater.getShows();
            for(Show show:shows){
                if(show.movie.getMovieId()==movie.getMovieId()){
                    givenMovieShows.add(show);
                }
            }
            if(!givenMovieShows.isEmpty()){
                theaterVsShows.put(theater, shows);
            }
        }
        return theaterVsShows;
    }

}

import java.util.*;

public class BookMyShow {

    MovieController movieController;
    TheaterController theaterController;

    public BookMyShow(){
        this.movieController= new MovieController();
        this.theaterController=new TheaterController();
    }

    public static void main(String args[]) {

        BookMyShow bookMyShow= new BookMyShow();

        bookMyShow.initialize();
        bookMyShow.createbooking(City.VIJAYAWADA,"mirchi");
        bookMyShow.createbooking(City.BANGALORE,"salaar");

    }

    public void initialize(){
        createMovies();
        createTheatres();
    }

    public void createbooking(City userCity, String movieName){
        List<Movie>movies=movieController.getMoviesByCity(userCity);
        Movie interestedMovie=null;
        for(Movie movie:movies){
            if(movie.getMovieName().equals(movieName)){
                interestedMovie=movie;
            }
        }
        Map<Theater,List<Show>>showsTheatreWise=theaterController.getAllTheaters(userCity, interestedMovie);
        
        int seatNumber=30;
        List<Integer>bookedSeats;
        if(){
            
            System.out.println("This seat is already booked, try another");
        }
        else{

            return;
        }
        System.out.println("Booking Successful");

    }

    public void createTheatres(){

        Movie salaar=movieController.getMoviesByName("salaar");
        Movie mirchi=movieController.getMoviesByName("mirchi");

        Theater inoxTheater=new Theater();
        inoxTheater.setTheaterId(1);
        inoxTheater.setCity(City.BANGALORE);
        inoxTheater.setScreens(createScreen());

        List<Show>inoxShows=new ArrayList<>();
        Show inoxMorningShow= createShow(1,inoxTheater.getScreens().get(0),salaar,10);
        Show inoxEveningShow= createShow(2,inoxTheater.getScreens().get(0),mirchi,15);
        Show inoxNytShow= createShow(3,inoxTheater.getScreens().get(0),salaar,22);

        inoxShows.add(inoxMorningShow);
        inoxShows.add(inoxEveningShow);
        inoxShows.add(inoxNytShow);

        inoxTheater.setShows(inoxShows);


        Theater cinepolisTheater=new Theater();
        cinepolisTheater.setTheaterId(2);
        cinepolisTheater.setCity(City.VIJAYAWADA);
        cinepolisTheater.setScreens(createScreen());

        List<Show>cinepolisShows=new ArrayList<>();
        Show cinepolisMorningShow= createShow(1,cinepolisTheater.getScreens().get(0),mirchi,9);
        Show cinepolisEveningShow= createShow(2,cinepolisTheater.getScreens().get(0),mirchi,14);
        Show cinepolisNytShow= createShow(3,cinepolisTheater.getScreens().get(0),salaar,23);

        cinepolisShows.add(cinepolisMorningShow);
        cinepolisShows.add(cinepolisEveningShow);
        cinepolisShows.add(cinepolisNytShow);

        inoxTheater.setShows(cinepolisShows);

        theaterController.addTheatre(cinepolisTheater, City.VIJAYAWADA);
        theaterController.addTheatre(inoxTheater, City.BANGALORE);

    }

    public Show createShow(int showId,Screen screen,Movie movie,int movieStartTime){
        Show show=new Show();
        show.setShowId(showId);
        show.setScreen(screen);
        show.setMovie(movie);
        show.setMovieStartTime(movieStartTime);;
        return show;
    }

    public List<Screen> createScreen(){

        List<Screen>screens=new ArrayList<>();
        Screen screen1= new Screen();
        screen1.setScreenId(1);
        screen1.setSeats(createSeats());
        screens.add(screen1);

        return screens;
    }

    public List<Seat> createSeats(){

        List<Seat>seats=new ArrayList<>();
        for(int i=1;i<=40;i++){
            Seat seat=new Seat();
            seat.setSeatId(i);
            seat.setRow(i%10);
            seat.setSeatCatergory(SeatCategory.GOLD);
            seats.add(seat);
        }
        for(int i=41;i<=70;i++){
            Seat seat=new Seat();
            seat.setSeatId(i);
            seat.setRow(i%10);
            seat.setSeatCatergory(SeatCategory.SILVER);
            seats.add(seat);
        }
        for(int i=71;i<=100;i++){
            Seat seat=new Seat();
            seat.setSeatId(i);
            seat.setRow(i%10);
            seat.setSeatCatergory(SeatCategory.PLATINUM);
            seats.add(seat);
        }

        return seats;
    }

    public void createMovies(){

        Movie salaar= new Movie();
        salaar.setMovieId(1);
        salaar.setMovieName("Salaar Part 1");
        salaar.setMovieDuration(240);

        Movie mirchi =new Movie();
        mirchi.setMovieId(2);
        mirchi.setMovieName("Mirchi The Saga");
        mirchi.setMovieDuration(320);

        movieController.addMovie(salaar, City.VIJAYAWADA);
        movieController.addMovie(salaar, City.BANGALORE);
        movieController.addMovie(mirchi, City.HYDERABAD);
        movieController.addMovie(mirchi, City.BANGALORE);

    }
}

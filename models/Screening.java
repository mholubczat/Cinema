package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Screening {
    Movie movie;
    LocalDateTime movieStart;
    int capacity;
    List<Place> places = new ArrayList<>();

    public Screening(Movie movie, LocalDateTime movieStart, int capacity) {
        this.movie = movie;
        this.movieStart = movieStart;
        this.capacity = capacity;
              for(int i=1; i<=capacity; i++){
                places.add(new Place(i));
        }

    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getMovieStart() {
        return movieStart;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public Place getPlace(int number) {
        return places.get(number);
    }
}

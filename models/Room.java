package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Room {
    int sittingPlaces;
    String name;

    List<Screening> timetable = new ArrayList<>();

    public Room(int sittingPlaces, String name) {
        this.sittingPlaces = sittingPlaces;
        this.name = name;
        }

    public void addMovie(Movie movie, LocalDateTime time) {
        Screening screening = new Screening(movie, time, sittingPlaces);
        this.timetable.add(screening);
    }


    public int getSittingPlaces() {
        return sittingPlaces;
    }

    public void setSittingPlaces(int sittingPlaces) {
        this.sittingPlaces = sittingPlaces;
    }

    public List<Screening> getTimetable() {
        return timetable;
    }
}

package utils;

import models.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class SystemBuilder {
    private List<Cinema> cinemas = new ArrayList<>();

    public void testData() {
        Cinema cinema1 = new Cinema(Cities.GDYNIA);
        Cinema cinema2 = new Cinema(Cities.KRAKOW);
        Cinema cinema3 = new Cinema(Cities.WARSZAWA);
        Cinema cinema4 = new Cinema(Cities.POZNAN);
        Cinema cinema5 = new Cinema(Cities.WROCLAW);
        Cinema cinema6 = new Cinema(Cities.LODZ);

        cinemas.add(cinema1);
        cinemas.add(cinema2);
        cinemas.add(cinema3);
        cinemas.add(cinema4);
        cinemas.add(cinema5);
        cinemas.add(cinema6);

        Room room1 = new Room(96, "Kwiatkowski");
        Room room2 = new Room(46, "Jagiełło");
        Room room3 = new Room(35, "Niemen");
        Room room4 = new Room(100, "Matołek");
        Room room5 = new Room(23, "Curie");
        Room room6 = new Room(22, "Dyzma");

        cinema1.addRoom(room1);
        cinema2.addRoom(room2);
        cinema3.addRoom(room3);
        cinema4.addRoom(room4);
        cinema5.addRoom(room5);
        cinema6.addRoom(room6);

        Movie sw4 = new Movie("A New Hope", 2 * 60 + 5);
        Movie sw5 = new Movie("The Empire Strikes Back", 2 * 60 + 7);
        Movie sw6 = new Movie("Return of the Jedi", 2 * 60 + 16);
        Movie sw1 = new Movie("Phantom Menace", 136);
        Movie sw2 = new Movie("Attack of the Clones", 142);
        Movie sw3 = new Movie("Revenge of the Sith", 140);
        Movie sw7 = new Movie("The Force Awakens", 136);
        Movie sw8 = new Movie("The Last Jedi", 152);

        for (Cinema c : cinemas
        ) {
            for (Room r : c.getRooms()) {
                r.addMovie(sw1, LocalDateTime.now().plusMinutes(222));
                r.addMovie(sw2, LocalDateTime.now().plusMinutes(2522));
                r.addMovie(sw3, LocalDateTime.now().plusMinutes(1));
                r.addMovie(sw4, LocalDateTime.now().plusMinutes(323));
                r.addMovie(sw5, LocalDateTime.now().plusMinutes(2222));
                r.addMovie(sw6, LocalDateTime.now().plusMinutes(23111));
                r.addMovie(sw7, LocalDateTime.now().plusMinutes(445));
                r.addMovie(sw8, LocalDateTime.now().plusMinutes(23232));

            }

        }



    }

    public Cinema getCinema(Cities city) {
        do {
            for (Cinema c : cinemas) {
                if (c.getCity().equals(city)) {
                    return c;
                }
            }
        } while (true);

    }

    public Ticket findTicket(String ticketId) {
        for (Cinema cinema : cinemas) {
            for (Room room : cinema.getRooms()) {
                for (Screening screening : room.getTimetable()) {
                    for (Place place : screening.getPlaces()) {
                        for (Ticket ticket : place.getTickets()){
                            if (ticket.getId().equals(ticketId)){return ticket;}
                        }
                    }
                }

            }

        }
        return null;
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }

    public Place findPlace(String ticketId) {
        for (Cinema cinema : cinemas) {
            for (Room room : cinema.getRooms()) {
                for (Screening screening : room.getTimetable()) {
                    for (Place place : screening.getPlaces()) {
                        for (Ticket ticket : place.getTickets()){
                            if (ticket.getId().equals(ticketId)){return place;}
                        }
                    }
                }

            }

        }
        return null;
    }

    public Screening findScreening(Cinema cinema, Movie movie) {

            for (Room room : cinema.getRooms()) {
                for (Screening screening : room.getTimetable()) {
                   if (screening.getMovie().equals(movie)){
                       return screening;
                   }
                }

            }


        return null;
    }
}

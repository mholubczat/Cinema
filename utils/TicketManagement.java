package utils;


import models.*;
import models.enums.Cities;
import models.enums.PlaceStatus;
import models.enums.TicketStatus;
import models.enums.TicketVariant;

import java.time.Month;


public class TicketManagement {

    SystemBuilder systemBuilder;

    public TicketManagement(SystemBuilder systemBuilder) {
        this.systemBuilder = systemBuilder;
    }

    public String bookTicket(Screening screening, int placeNumber, TicketVariant variant) {
        if (!screening.getPlace(placeNumber).getPlaceStatus().equals(PlaceStatus.FREE)) {
            System.out.println("Wybrane miejsce jest niedostępne");
        } else {
            screening.getPlace(placeNumber).setPlaceStatus(PlaceStatus.BOOKED);
            Ticket ticket = new Ticket(variant);
            screening.getPlace(placeNumber).addTicket(ticket);
            System.out.println("Zamówiono bilet " + variant + " na " + screening + " miejsce numer " + placeNumber);
            return ticket.getId();
        }


        return null;
    }

    public void removeTicket(String ticketId) {
        systemBuilder.findPlace(ticketId).setPlaceStatus(PlaceStatus.FREE);
        systemBuilder.findTicket(ticketId).setTicketStatus(TicketStatus.CANCELLED);
    }

    public void confirmTicketPayment(String ticketId) {
        systemBuilder.findPlace(ticketId).setPlaceStatus(PlaceStatus.SOLD);
        systemBuilder.findTicket(ticketId).setTicketStatus(TicketStatus.SOLD);
        System.out.println("Bilet opłacono");
    }

    public SystemBuilder getSystemBuilder() {
        return systemBuilder;
    }

    public void booked(Month month) {

        for (Cinema c : systemBuilder.getCinemas())

         {
             int soldPlaces = 0;
             int allPlaces = 0;
            for (Room r : c.getRooms()) {
                for (Screening screening : r.getTimetable())
                {

                    if (screening.getMovieStart().getMonth().equals(month)) {

                        for (Place place : screening.getPlaces()) {
                            if (place.getPlaceStatus().equals(PlaceStatus.SOLD)) {

                                        soldPlaces++;
                            }
                        }
                    }
                }

                allPlaces += r.getSittingPlaces();
                System.out.println("W " + month + " w " + c.getCity() + " sprzedano " + soldPlaces + " z " + allPlaces + " miejsc" );
            }


        }

    }

    public void income(Month month) {

        for (Cinema c : systemBuilder.getCinemas())

        {
            int income = 0;

            for (Room r : c.getRooms()) {
                for (Screening screening : r.getTimetable())
                {

                    if (screening.getMovieStart().getMonth().equals(month)) {

                        for (Place place : screening.getPlaces()) {
                            for (Ticket t: place.getTickets()
                                 ) {
                                if (t.getTicketStatus().equals(TicketStatus.SOLD)) {

                                    income += t.getPrice();
                                }
                            }

                        }
                    }
                }


                System.out.println("W " + month + " w " + c.getCity() + " sprzedano bilety za " + income + " zl" );
            }


        }

    }



    public void testBooking(int i) {
        {
            confirmTicketPayment(
            bookTicket(systemBuilder.findScreening(
                    systemBuilder.getCinema(Cities.WARSZAWA),
                    systemBuilder.findMovie("A New Hope")),
                    i,
                    TicketVariant.NORMAL));
        }

        }

    }









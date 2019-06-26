package utils;


import models.*;


public class TicketManagement {

    SystemBuilder systemBuilder;

    public TicketManagement(SystemBuilder systemBuilder) {
        this.systemBuilder = systemBuilder;
    }

    public void bookTicket(Screening screening, int placeNumber, TicketVariant variant) {

        if (!screening.getPlace(placeNumber).getPlaceStatus().equals(PlaceStatus.FREE)) {
            System.out.println("Wybrane miejsce jest niedostępne");
        } else {
            screening.getPlace(placeNumber).setPlaceStatus(PlaceStatus.BOOKED);
            Ticket ticket = new Ticket(variant);
            screening.getPlace(placeNumber).addTicket(ticket);
        }
    }

    public void removeTicket(String ticketId) {
        systemBuilder.findPlace(ticketId).setPlaceStatus(PlaceStatus.FREE);
        systemBuilder.findTicket(ticketId).setTicketStatus(TicketStatus.CANCELLED);
    }

    public void confirmTicketPayment(String ticketId) {
        systemBuilder.findPlace(ticketId).setPlaceStatus(PlaceStatus.SOLD);
        systemBuilder.findTicket(ticketId).setTicketStatus(TicketStatus.SOLD);
    }

    public double booked(long month) {
        int soldPlaces = 0;
        int allPlaces = 0;
        for (Cinema c : systemBuilder.getCinemas()
        ) {
            for (Room r : c.getRooms()) {
                for (Screening screening : r.getTimetable()) {
                    if (screening.getMovieStart().getMonth().equals(month)) {
                        for (Place place : screening.getPlaces()) {
                            if (place.getPlaceStatus().equals(PlaceStatus.SOLD)) {
                                soldPlaces++;
                            }
                        }
                    }
                }
            }
            for (Room r : c.getRooms()) {
                allPlaces += r.getSittingPlaces();
            }

        }
        return soldPlaces / allPlaces;
    }
}








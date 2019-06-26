package models;

import models.enums.PlaceStatus;

import java.util.ArrayList;
import java.util.List;

public class Place {

    int number;

    PlaceStatus placeStatus = PlaceStatus.FREE;

    List<Ticket> tickets = new ArrayList<>();

    public Place(int number) {
        this.number = number;
    }

    public void addTicket(Ticket ticket){
        this.tickets.add(ticket);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public PlaceStatus getPlaceStatus() {
        return placeStatus;
    }

    public void setPlaceStatus(PlaceStatus placeStatus) {
        this.placeStatus = placeStatus;
    }
}

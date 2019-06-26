package models;

import models.enums.TicketStatus;
import models.enums.TicketVariant;

import java.util.UUID;



public class Ticket {
    String id;
    double price;
    TicketStatus ticketStatus = TicketStatus.PENDING;
    TicketVariant ticketVariant;

    public Ticket(TicketVariant variant) {
       this.id = UUID.randomUUID().toString();
       this.ticketVariant = variant;
        if (variant.equals(TicketVariant.NORMAL)) {
            this.price = 25;
        }
        else {this.price = 15;}
    }

    public double getPrice() {
        return price;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public TicketVariant getTicketVariant() {
        return ticketVariant;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getId() {
        return id;
    }


}

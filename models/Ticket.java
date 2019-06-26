package models;

import java.util.UUID;



public class Ticket {
    String id;
    double price=20;
    TicketStatus ticketStatus = TicketStatus.PENDING;
    TicketVariant ticketVariant;

    public Ticket(TicketVariant variant) {
       this.id = UUID.randomUUID().toString();
       this.ticketVariant = variant;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getId() {
        return id;
    }


}

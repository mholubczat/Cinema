package models.enums;

public enum TicketVariant {
    NORMAL,
    DISCOUNT;

    @Override
    public String toString() {
        if(this.equals(NORMAL)){return "normalny";}
        else {return "ulgowy";}
    }
}

package exe;


import models.enums.Cities;
import models.enums.TicketVariant;
import utils.SystemBuilder;
import utils.TicketManagement;
import utils.UserInteraction;

import java.time.Month;

public class Execute {
    public static void main(String[] args) {

        SystemBuilder starWars = new SystemBuilder();
        starWars.testData();


        TicketManagement manage = new TicketManagement(starWars);
        for (int i = 2; i < 23; i++) {
            manage.testBooking(i);
        }


        manage.booked(Month.MAY);
        manage.income(Month.MAY);

UserInteraction userInteraction = new UserInteraction(manage);
    }
}

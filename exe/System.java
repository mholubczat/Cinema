package exe;


import models.Cities;
import models.TicketVariant;
import utils.SystemBuilder;
import utils.TicketManagement;

public class System {
    public static void main(String[] args) {
        SystemBuilder cinemaCity = new SystemBuilder();
        cinemaCity.testData();
        TicketManagement manage = new TicketManagement(cinemaCity);
        manage.bookTicket(cinemaCity.getCinema(Cities.WARSZAWA).getRoom("Niemen").getTimetable().get(2),23, TicketVariant.NORMAL);
        manage.bookTicket(cinemaCity.getCinema(Cities.WARSZAWA).getRoom("Niemen").getTimetable().get(2),22, TicketVariant.NORMAL);
        manage.bookTicket(cinemaCity.getCinema(Cities.WARSZAWA).getRoom("Niemen").getTimetable().get(2),21, TicketVariant.NORMAL);
        manage.bookTicket(cinemaCity.getCinema(Cities.WARSZAWA).getRoom("Niemen").getTimetable().get(2),20, TicketVariant.NORMAL);
        manage.bookTicket(cinemaCity.getCinema(Cities.WARSZAWA).getRoom("Niemen").getTimetable().get(2),23, TicketVariant.NORMAL);



        System.out.println("asd");
    }
}

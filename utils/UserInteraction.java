package utils;


import models.Room;
import models.enums.Cities;
import models.enums.TicketVariant;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class UserInteraction {
    private Map<Integer, Cities> mapCity = new HashMap<>();


    public UserInteraction(TicketManagement ticketManagement) {
        mapCity.put(1, Cities.WARSZAWA);
        mapCity.put(2, Cities.POZNAN);
        mapCity.put(3, Cities.LODZ);
        mapCity.put(4, Cities.WROCLAW);
        mapCity.put(5, Cities.KRAKOW);
        mapCity.put(6, Cities.GDYNIA);

        System.out.println("Hello! What can I do for you today?");
        System.out.println("Book a ticket - press 1");
        System.out.println("Confirm ticket payment - press 2");
        System.out.println("Cancel reservation - press 3");
        System.out.println("Print booking statistics - press 4");
        System.out.println("Print sales statistics - press 5");
        int input = 0;

        while (input < 1 || input > 5) {
            System.out.println("Enter a number from 1 to 5");
            Scanner scanner = new Scanner(System.in);
            try {
                input = scanner.nextInt();
            } catch (InputMismatchException exception) {
                System.out.println("Unexpected input");
            }
        }

        switch (input) {
            case 1:
                int city = 0;
                System.out.println("Warsaw - press 1");
                System.out.println("Poznan - press 2");
                System.out.println("Lodz - press 3");
                System.out.println("Wroclaw - press 4");
                System.out.println("Krakow - press 5");
                System.out.println("Gdynia - press 6");
                while (city < 1 || city > 6) {
                    System.out.println("Enter a city - number from 1 to 6");
                    Scanner scanner = new Scanner(System.in);
                    try {
                        city = scanner.nextInt();
                    } catch (InputMismatchException exception) {
                        System.out.println("Unexpected input");
                    }
                }
                Cities chosenCity = mapCity.get(city);
                int sw = 0;

                while (sw < 1 || sw > 8) {
                    System.out.println("Choose Star Wars part to see (1-8)");
                    Scanner scanner = new Scanner(System.in);
                    try {
                        sw = scanner.nextInt();
                    } catch (InputMismatchException exception) {
                        System.out.println("Unexpected input");
                    }
                }
                int monthc1 = 0; int day = 0;
                do {
                    monthc1 = 0;
                    day = 0;
                    while (monthc1 < 1 || monthc1 > 12) {
                        System.out.println("Enter a month 1-12");
                        Scanner scanner = new Scanner(System.in);
                        try {
                            monthc1 = scanner.nextInt();
                        } catch (InputMismatchException exception) {
                            System.out.println("Unexpected input");
                        }
                    }



                    while (day < 1 || day > 31) {
                        System.out.println("Enter a day");
                        Scanner scanner = new Scanner(System.in);
                        try {
                            day = scanner.nextInt();
                            LocalDate date = LocalDate.of(LocalDate.now().getYear(), monthc1, day);
                        } catch (InputMismatchException exception) {
                            System.out.println("Unexpected input");
                        } catch (DateTimeException exception) {
                            System.out.println("Unexpected input");
                        }
                    }
                    System.out.println(chosenCity + "" +sw+monthc1+day);
                   if(ticketManagement.getSystemBuilder().findScreening(chosenCity, sw, monthc1, day)==null){
                       System.out.println("No screening this day!");}
                  else{ break;}


                } while (true);
                TicketVariant variant;
                System.out.println("Are you eligible for a discount ticket? y/n");
                while (true) {
                    Scanner scanner = new Scanner(System.in);
                    if (scanner.nextLine().equalsIgnoreCase("y")) {
                        variant = TicketVariant.DISCOUNT;
                        break;
                    } else if (scanner.nextLine().equalsIgnoreCase("n")) {
                        variant = TicketVariant.NORMAL;
                        break;
                    } else {
                        System.out.println("Are you eligible for a discount ticket? y/n");
                    }
                }
                int place = 0;
                int maxPlaces = 0;
                for (Room r : ticketManagement.getSystemBuilder().getCinema(chosenCity).getRooms()
                ) {
                    maxPlaces += r.getSittingPlaces();
                }


                while (place < 1 || place > maxPlaces) {
                    System.out.println("Choose your place");
                    Scanner scanner = new Scanner(System.in);
                    try {
                        place = scanner.nextInt();
                    } catch (InputMismatchException exception) {
                        System.out.println("Unexpected input");
                    }
                }
                ticketManagement.bookTicket(ticketManagement.getSystemBuilder().findScreening(chosenCity, sw, monthc1, day), place, variant);
                break;


            case 2:
                break;


            case 3:
                break;


            case 4:
                int month = 0;

                while (month < 1 || month > 12) {
                    System.out.println("Enter a month from 1 to 12");
                    Scanner scanner = new Scanner(System.in);
                    try {
                        month = scanner.nextInt();
                    } catch (InputMismatchException exception) {
                        System.out.println("Unexpected input");
                    } catch (DateTimeException exception2) {
                        System.out.println("Unexpected input");
                    }
                }
                ticketManagement.booked(Month.of(month));

                break;


            case 5:
                int month1 = 0;

                while (month1 < 1 || month1 > 12) {
                    System.out.println("Enter a month from 1 to 12");
                    Scanner scanner = new Scanner(System.in);
                    try {
                        month1 = scanner.nextInt();
                    } catch (InputMismatchException exception) {
                        System.out.println("Unexpected input");
                    } catch (DateTimeException exception2) {
                        System.out.println("Unexpected input");
                    }
                }
                ticketManagement.income(Month.of(month1));
                break;
        }

    }
}

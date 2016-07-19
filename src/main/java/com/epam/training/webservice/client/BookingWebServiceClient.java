package com.epam.training.webservice.client;

import com.epam.training.webservice.client.reporter.Reporter;
import com.epam.training.webservice.client.services.BookingService;
import com.epam.training.webservice.common.domains.Person;
import com.epam.training.webservice.common.domains.Ticket;

import java.net.MalformedURLException;
import java.util.Date;

public class BookingWebServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        BookingService bookingService = new BookingService();

        Ticket[] freeTickets = bookingService.getAllFree();

        System.out.println(Reporter.getAllTicket(freeTickets, "ALL FREE"));

        System.out.println("We book ticket (tver->st.peterburg)");
        int numberBookingTicket = bookingService.bookedTicket(2, new Person("Bobovich", "Ilya", "XXX", new Date(2000, 10, 15)));
        freeTickets = bookingService.getAllFree();
        Ticket[] ticketInSystem = bookingService.getAllInSystem();
        System.out.println(Reporter.bookedTicket(numberBookingTicket, freeTickets, ticketInSystem));

        System.out.println("We pay booking ticket");
        System.out.println("True buy");
        bookingService.buyTicket(ticketInSystem[0].getNumberBook());
        ticketInSystem = bookingService.getAllInSystem();
        System.out.println(Reporter.buyTicket(ticketInSystem));
        System.out.println("False buy");
        bookingService.buyTicket(freeTickets[0].getNumberBook());
        ticketInSystem = bookingService.getAllInSystem();
        System.out.println(Reporter.buyTicket(ticketInSystem));

        System.out.println("Get ticket (tver->st.peterburg) under number");
        int numberTicket = ticketInSystem[0].getNumberBook();
        Ticket ticketByNumber = bookingService.getTicketByNumberBook(numberTicket);
        System.out.println(Reporter.getTicketByNumberBook(ticketByNumber, ticketInSystem));

        System.out.println("Return ticket");
        System.out.println("True return");
        bookingService.returnTicket(ticketInSystem[0].getNumberBook());
        ticketInSystem = bookingService.getAllInSystem();
        freeTickets = bookingService.getAllFree();
        System.out.println(Reporter.returnTicket(ticketInSystem, freeTickets));
        System.out.println("False return");
        bookingService.returnTicket(freeTickets[0].getNumberBook());
        ticketInSystem = bookingService.getAllInSystem();
        freeTickets = bookingService.getAllFree();
        System.out.println(Reporter.returnTicket(ticketInSystem, freeTickets));
    }
}

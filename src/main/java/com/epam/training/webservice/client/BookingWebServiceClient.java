package com.epam.training.webservice.client;

import com.epam.training.webservice.client.reporter.Reporter;
import com.epam.training.webservice.client.services.BookingService;
import com.epam.training.webservice.common.domains.Person;
import com.epam.training.webservice.common.domains.Ticket;

import java.net.MalformedURLException;
import java.util.Date;
import java.util.List;

public class BookingWebServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        BookingService bookingService = new BookingService();

        List<Ticket> freeTickets = bookingService.getAllFree();

        System.out.println(Reporter.getAllTicket(freeTickets, "ALL FREE"));

        System.out.println("We book ticket (tver->st.peterburg)");
        int numberBookingTicket = bookingService.bookedTicket(freeTickets.get(2), new Person("Bobovich", "Ilya", "XXX", new Date(2000, 10, 15)));
        freeTickets = bookingService.getAllFree();
        List<Ticket> ticketInSystem = bookingService.getAllInSystem();
        System.out.println(Reporter.bookedTicket(numberBookingTicket, freeTickets, ticketInSystem));

        System.out.println("We pay booking ticket");
        System.out.println("True buy");
        boolean resultOperation = bookingService.buyTicket(ticketInSystem.get(0));
        ticketInSystem = bookingService.getAllInSystem();
        System.out.println(Reporter.buyTicket(resultOperation, ticketInSystem));
        System.out.println("False buy");
        resultOperation = bookingService.buyTicket(freeTickets.get(0));
        ticketInSystem = bookingService.getAllInSystem();
        System.out.println(Reporter.buyTicket(resultOperation, ticketInSystem));

        System.out.println("Get ticket (tver->st.peterburg) under number");
        int numberTicket = ticketInSystem.get(0).getNumberBook();
        Ticket ticketByNumber = bookingService.getTicketByNumberBook(numberTicket);
        System.out.println(Reporter.getTicketByNumberBook(ticketByNumber, ticketInSystem));

        System.out.println("Return ticket");
        System.out.println("True return");
        resultOperation = bookingService.returnTicket(ticketInSystem.get(0));
        ticketInSystem = bookingService.getAllInSystem();
        freeTickets = bookingService.getAllFree();
        System.out.println(Reporter.returnTicket(resultOperation, ticketInSystem, freeTickets));
        System.out.println("False return");
        resultOperation = bookingService.returnTicket(freeTickets.get(0));
        ticketInSystem = bookingService.getAllInSystem();
        freeTickets = bookingService.getAllFree();
        System.out.println(Reporter.returnTicket(resultOperation, ticketInSystem, freeTickets));
    }
}

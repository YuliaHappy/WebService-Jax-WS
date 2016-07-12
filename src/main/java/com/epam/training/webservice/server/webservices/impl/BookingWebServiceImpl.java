package com.epam.training.webservice.server.webservices.impl;

import com.epam.training.webservice.common.domains.Person;
import com.epam.training.webservice.common.domains.Ticket;
import com.epam.training.webservice.common.exceptions.BookingException;
import com.epam.training.webservice.server.dao.impl.MemoryTicketDaoImpl;
import com.epam.training.webservice.server.services.BookingService;
import com.epam.training.webservice.common.webservices.BookingWebService;
import com.epam.training.webservice.server.services.TicketService;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.List;

@WebService(
        endpointInterface = "com.epam.training.webservice.common.webservices.BookingWebService",
        targetNamespace = "http://samples/bookingservice",
        serviceName = "BookingWebService")
public class BookingWebServiceImpl implements BookingWebService {
    private BookingService bookingService = new BookingService(
            new TicketService(new MemoryTicketDaoImpl()), new HashMap<>());

    @Override
    public int bookTicket(int idTicket, Person person) {
        return bookingService.bookTicket(idTicket, person);
    }

    @Override
    public Ticket getByNumber(int numberTicket) {
        return bookingService.getByNumber(numberTicket);
    }

    @Override
    public void buyTicket(int numberTicket) throws BookingException {
        bookingService.buyTicket(numberTicket);
    }

    @Override
    public void returnTicket(int numberTicket) throws BookingException {
        bookingService.returnTicket(numberTicket);
    }

    @Override
    public Ticket[] getAllFree() {
        List<Ticket> ticketList = bookingService.getAllFree();
        return ticketList.toArray(new Ticket[ticketList.size()]);
    }

    @Override
    public Ticket[] getAllInSystem() {
        List<Ticket> ticketList = bookingService.getAllInSystem();
        return ticketList.toArray(new Ticket[ticketList.size()]);
    }
}

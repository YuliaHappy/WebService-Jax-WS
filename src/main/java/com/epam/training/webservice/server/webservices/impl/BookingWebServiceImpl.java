package com.epam.training.webservice.server.webservices.impl;

import com.epam.training.webservice.common.domains.Ticket;
import com.epam.training.webservice.server.dao.impl.MemoryTicketDaoImpl;
import com.epam.training.webservice.server.services.BookingService;
import com.epam.training.webservice.common.services.JsonService;
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
    public int bookedTicket(String ticket, String person) {
        return bookingService.bookedTicket(
                JsonService.parseTicket(ticket),
                JsonService.parsePerson(person));
    }

    @Override
    public String getByNumber(int numberTicket) {
        return JsonService.stringifyTicket(
                bookingService.getByNumber(numberTicket));
    }

    @Override
    public boolean buyTicket(String ticket) {
        return bookingService.buyTicket(JsonService.parseTicket(ticket));
    }

    @Override
    public boolean returnTicket(String ticket) {
        return bookingService.returnTicket(JsonService.parseTicket(ticket));
    }

    @Override
    public String[] getAllFree() {
        List<Ticket> ticketsList = bookingService.getAllFree();
        String[] tickets = new String[ticketsList.size()];

        for (int i = 0; i < ticketsList.size(); i++) {
            tickets[i] = JsonService.stringifyTicket(ticketsList.get(i));
        }
        return tickets;
    }

    @Override
    public String[] getAllInSystem() {
        List<Ticket> ticketList = bookingService.getAllInSystem();
        String[] tickets = new String[ticketList.size()];

        for (int i = 0; i < ticketList.size(); i++) {
            tickets[i] = JsonService.stringifyTicket(ticketList.get(i));
        }
        return tickets;
    }

    @Override
    public String getTicketByNumber(int numberTicket) {
        return JsonService.stringifyTicket(bookingService.getByNumber(numberTicket));
    }
}

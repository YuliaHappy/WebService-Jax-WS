package com.epam.training.webservice.server.services;

import com.epam.training.webservice.common.domains.StateTicket;
import com.epam.training.webservice.common.domains.Person;
import com.epam.training.webservice.common.domains.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookingService {
    private TicketService ticketService;
    private Map<Integer, Ticket> processedTickets;

    public BookingService(TicketService ticketService, Map<Integer, Ticket> processedTickets) {
        this.ticketService = ticketService;
        this.processedTickets = processedTickets;
    }


    public int bookedTicket(Ticket ticket, Person person) {
        int numberBook = ticketService.saveToSystem(ticket, person);
        processedTickets.put(numberBook, ticket);
        return numberBook;
    }

    public Ticket getByNumber(int numberTicket) {
        return processedTickets.get(numberTicket);
    }

    public boolean buyTicket(Ticket ticket) {
        Ticket ticketInSystem = processedTickets.get(ticket.getNumberBook());
        if (ticketInSystem != null && ticketInSystem.getState() == StateTicket.BOOKED) {
            ticketInSystem.setState(StateTicket.PAID);
            return true;
        }
        return false;
    }

    public boolean returnTicket(Ticket ticket) {
        if (processedTickets.containsKey(ticket.getNumberBook())) {
            ticketService.addTicket(processedTickets.remove(ticket.getNumberBook()));
            return true;
        }
        return false;
    }

    public List<Ticket> getAllFree() {
        return ticketService.getAll();
    }

    public List<Ticket> getAllInSystem() {
        return new ArrayList<>(processedTickets.values());
    }
}

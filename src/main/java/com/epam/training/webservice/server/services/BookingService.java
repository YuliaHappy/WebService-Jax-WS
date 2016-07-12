package com.epam.training.webservice.server.services;

import com.epam.training.webservice.common.domains.StateTicket;
import com.epam.training.webservice.common.domains.Person;
import com.epam.training.webservice.common.domains.Ticket;
import com.epam.training.webservice.common.exceptions.BookingException;

import javax.xml.bind.annotation.XmlList;
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


    public int bookTicket(int idTicket, Person person) {
        Ticket ticket = ticketService.saveToSystem(idTicket, person);
        processedTickets.put(ticket.getNumberBook(), ticket);
        return ticket.getNumberBook();
    }

    public Ticket getByNumber(int numberTicket) {
        return processedTickets.get(numberTicket);
    }

    public void buyTicket(int numberTicket) throws BookingException {
        Ticket ticketInSystem = processedTickets.get(numberTicket);
        if (ticketInSystem != null) {
            if (ticketInSystem.getState() == StateTicket.BOOKED) {
                ticketInSystem.setState(StateTicket.PAID);
                return;
            }
            throw new BookingException("State ticket " + ticketInSystem.getState() + " incorret!");
        }
        throw new BookingException("Number ticket " + numberTicket + " incorret!");
    }

    public void returnTicket(int numberTicket) throws BookingException {
        if (processedTickets.containsKey(numberTicket)) {
            ticketService.addTicket(processedTickets.remove(numberTicket));
            return;
        }
        throw new BookingException("Number ticket " + numberTicket + " incorret!");
    }
    public List<Ticket> getAllFree() {
        return ticketService.getAll();
    }

    public List<Ticket> getAllInSystem() {
        return new ArrayList<>(processedTickets.values());
    }
}

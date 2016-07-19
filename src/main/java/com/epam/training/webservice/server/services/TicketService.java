package com.epam.training.webservice.server.services;

import com.epam.training.webservice.common.domains.Ticket;
import com.epam.training.webservice.server.dao.TicketDao;
import com.epam.training.webservice.common.domains.Person;

import java.util.List;

public class TicketService {
    private TicketDao ticketDao;

    public TicketService(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public int saveToSystem(Ticket ticket, Person person) {
        return ticketDao.saveToSystem(ticket, person);
    }

    public void addTicket(Ticket ticket) {
        ticketDao.addTicket(ticket);
    }

    public List<Ticket> getAll() {
        return ticketDao.getAll();
    }
}

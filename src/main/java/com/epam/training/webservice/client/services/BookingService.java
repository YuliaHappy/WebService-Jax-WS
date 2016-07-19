package com.epam.training.webservice.client.services;

import com.epam.training.webservice.common.domains.Person;
import com.epam.training.webservice.common.domains.Ticket;
import com.epam.training.webservice.common.services.JsonService;
import com.epam.training.webservice.common.webservices.BookingWebService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BookingService {
    private BookingWebService bookingWebService;

    public BookingService() throws MalformedURLException {
        URL url = new URL("http://localhost:1224/bookingservice?wsdl");
        QName qName = new QName("http://samples/bookingservice",
                "BookingWebService");

        Service service = Service.create(url, qName);
        bookingWebService = service.getPort(BookingWebService.class);
    }

    public List<Ticket> getAllFree() {
        String[] tickets = bookingWebService.getAllFree();
        List<Ticket> ticketList = new ArrayList<>();

        for (int i = 0; i < tickets.length; i++) {
            ticketList.add(JsonService.parseTicket(tickets[i]));
        }
        return ticketList;
    }

    public int bookedTicket(Ticket ticket, Person person) {
        return bookingWebService.bookedTicket(JsonService.stringifyTicket(ticket),
                JsonService.stringifyPerson(person));
    }

    public List<Ticket> getAllInSystem() {
        String[] tickets = bookingWebService.getAllInSystem();
        List<Ticket> ticketList = new ArrayList<>();

        for (int i = 0; i < tickets.length; i++) {
            ticketList.add(JsonService.parseTicket(tickets[i]));
        }
        return ticketList;
    }

    public boolean buyTicket(Ticket ticket) {
        return bookingWebService.buyTicket(JsonService.stringifyTicket(ticket));
    }

    public Ticket getTicketByNumberBook(int numberTicket) {
        String ticket = bookingWebService.getTicketByNumber(numberTicket);
        return JsonService.parseTicket(ticket);
    }

    public boolean returnTicket(Ticket ticket) {
        return bookingWebService.returnTicket(JsonService.stringifyTicket(ticket));
    }
}

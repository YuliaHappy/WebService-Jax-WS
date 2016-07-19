package com.epam.training.webservice.client.services;

import com.epam.training.webservice.common.domains.Person;
import com.epam.training.webservice.common.domains.Ticket;
import com.epam.training.webservice.common.exceptions.BookingException;
import com.epam.training.webservice.common.webservices.BookingWebService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class BookingService {
    private BookingWebService bookingWebService;

    public BookingService() throws MalformedURLException {
        URL url = new URL("http://localhost:1224/bookingservice?wsdl");
        QName qName = new QName("http://samples/bookingservice",
                "BookingWebService");

        Service service = Service.create(url, qName);
        bookingWebService = service.getPort(BookingWebService.class);
    }

    public Ticket[] getAllFree() {
        return bookingWebService.getAllFree();
    }

    public int bookedTicket(int idTicket, Person person) {
        return bookingWebService.bookTicket(idTicket, person);
    }

    public Ticket[] getAllInSystem() {
        return bookingWebService.getAllInSystem();
    }

    public void buyTicket(int numberTicket) {
        try {
            bookingWebService.buyTicket(numberTicket);
        } catch (BookingException e) {
            e.printStackTrace();
        }
    }

    public Ticket getTicketByNumberBook(int numberTicket) {
        return bookingWebService.getByNumber(numberTicket);
    }

    public void returnTicket(int numberTicket) {
        try {
            bookingWebService.returnTicket(numberTicket);
        } catch (BookingException e) {
            e.printStackTrace();
        }
    }
}

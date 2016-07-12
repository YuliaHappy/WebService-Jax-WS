package com.epam.training.webservice.common.webservices;

import com.epam.training.webservice.common.domains.Person;
import com.epam.training.webservice.common.domains.Ticket;
import com.epam.training.webservice.common.exceptions.BookingException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface BookingWebService {
    @WebMethod
    public int bookTicket(int idTicket, Person person);

    @WebMethod
    public Ticket getByNumber(int numberTicket);

    @WebMethod
    public void buyTicket(int numberTicket) throws BookingException;

    @WebMethod
    public void returnTicket(int numberTicket) throws BookingException;

    @WebMethod
    public Ticket[] getAllFree();

    @WebMethod
    public Ticket[] getAllInSystem();
}

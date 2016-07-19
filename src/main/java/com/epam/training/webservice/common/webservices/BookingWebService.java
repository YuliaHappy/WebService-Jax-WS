package com.epam.training.webservice.common.webservices;

import com.epam.training.webservice.common.domains.Person;
import com.epam.training.webservice.common.domains.Ticket;
import com.epam.training.webservice.common.exceptions.BookingException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface BookingWebService {
    @WebMethod
    public int bookTicket(@WebParam(name = "idTicket") int idTicket, @WebParam(name = "person") Person person);

    @WebMethod
    public Ticket getByNumber(@WebParam(name = "numberTicket") int numberTicket);

    @WebMethod
    public void buyTicket(@WebParam(name = "numberTicket")int numberTicket) throws BookingException;

    @WebMethod
    public void returnTicket(@WebParam(name = "numberTicket")int numberTicket) throws BookingException;

    @WebMethod
    public Ticket[] getAllFree();

    @WebMethod
    public Ticket[] getAllInSystem();
}

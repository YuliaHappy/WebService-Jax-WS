package com.epam.training.webservice.common.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface BookingWebService {
    @WebMethod
    public int bookedTicket(String ticket, String person);

    @WebMethod
    public String getByNumber(int numberTicket);

    @WebMethod
    public boolean buyTicket(String ticket);

    @WebMethod
    public boolean returnTicket(String ticket);

    @WebMethod
    public String[] getAllFree();

    @WebMethod
    public String[] getAllInSystem();

    @WebMethod
    public String getTicketByNumber(int numberTicket);
}

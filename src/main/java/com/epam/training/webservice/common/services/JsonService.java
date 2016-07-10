package com.epam.training.webservice.common.services;

import com.epam.training.webservice.common.domains.Person;
import com.epam.training.webservice.common.domains.Ticket;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;


public final class JsonService {
    public static String stringifyTicket(Ticket ticket) {
        String result = null;
        try {
            result = new ObjectMapper().writeValueAsString(ticket);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Ticket parseTicket(String ticket) {
        Ticket ticketClass = null;
        try {
            ticketClass = new ObjectMapper().readValue(ticket, Ticket.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ticketClass;
    }

    public static String stringifyPerson(Person person) {
        String result = null;
        try {
            result =  new ObjectMapper().writeValueAsString(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Person parsePerson(String person) {
        Person personClass = null;
        try {
            personClass = new ObjectMapper().readValue(person, Person.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personClass;
    }
}

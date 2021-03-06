package com.epam.training.webservice.client.reporter;

import com.epam.training.webservice.common.domains.Ticket;

import java.util.List;

public final class Reporter {
    public static String getAllTicket(List<Ticket> tickets, String nameGroup) {
        StringBuilder reporter = new StringBuilder();
        reporter.append("Get all " + nameGroup + ":\n");
        reporter.append("----------------------------------------------\n");
        for (Ticket ticket :
                tickets) {
            reporter.append(ticket.toString());
            reporter.append("\n-----------------\n");
        }
        reporter.append("----------------------------------------------\n");
        return reporter.toString();
    }

    public static String bookedTicket(int numberBook, List<Ticket> allFree, List<Ticket> ticketsInSystem) {
        StringBuilder reporter = new StringBuilder();
        reporter.append("Booked ticket\n");
        reporter.append("------------------------------------------------------------------------------------------\n");
        reporter.append("numberBook is " + numberBook + "\n");
        reporter.append(Reporter.getAllTicket(allFree, "ALL FREE"));
        reporter.append(Reporter.getAllTicket(ticketsInSystem, "TICKET IN THE SYSTEM"));
        reporter.append("------------------------------------------------------------------------------------------\n");
        return reporter.toString();
    }

    public static String buyTicket(boolean resultByuing, List<Ticket> ticketsInSystem) {
        StringBuilder reporter = new StringBuilder();
        reporter.append("Buy ticket\n");
        reporter.append("------------------------------------------------------------------------------------------\n");
        reporter.append("Result buying ticket is " + resultByuing + "\n");
        reporter.append(Reporter.getAllTicket(ticketsInSystem, "TICKET IN THE SYSTEM"));
        reporter.append("------------------------------------------------------------------------------------------\n");
        return reporter.toString();
    }

    public static String getTicketByNumberBook(Ticket ticketByNumber, List<Ticket> ticketInSystem) {
        StringBuilder reporter = new StringBuilder();
        reporter.append("Get ticket by number book\n");
        reporter.append("------------------------------------------------------------------------------------------\n");
        reporter.append("The selection result is " + ticketByNumber + "\n");
        reporter.append(Reporter.getAllTicket(ticketInSystem, "TICKET IN THE SYSTEM"));
        reporter.append("------------------------------------------------------------------------------------------\n");
        return reporter.toString();
    }

    public static String returnTicket(boolean resultOperation, List<Ticket> ticketInSystem, List<Ticket> freeTickets) {
        StringBuilder reporter = new StringBuilder();
        reporter.append("Return ticket\n");
        reporter.append("------------------------------------------------------------------------------------------\n");
        reporter.append("Result return ticket is " + resultOperation + "\n");
        reporter.append(Reporter.getAllTicket(freeTickets, "ALL FREE"));
        reporter.append(Reporter.getAllTicket(ticketInSystem, "TICKET IN THE SYSTEM"));
        reporter.append("------------------------------------------------------------------------------------------\n");
        return reporter.toString();
    }
}

package com.epam.training.webservice.server;

import com.epam.training.webservice.server.webservices.impl.BookingWebServiceImpl;

import javax.xml.ws.Endpoint;

public class BookingWebServicePublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:1224/bookingservice", new BookingWebServiceImpl());
    }
}

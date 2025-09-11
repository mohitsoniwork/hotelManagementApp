package com.udacity.hotel.model;

import java.util.Date;

public final class ReservationFactory {
    public Reservation create(Customer customer, IRoom room, Date checkIn, Date checkOut) {
        return new Reservation(customer, room, checkIn, checkOut);
    }
}

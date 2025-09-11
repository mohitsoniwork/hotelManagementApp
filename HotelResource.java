package com.udacity.hotel.api;

import com.udacity.hotel.model.Customer;
import com.udacity.hotel.model.IRoom;
import com.udacity.hotel.model.Reservation;
import com.udacity.hotel.service.CustomerService;
import com.udacity.hotel.service.ReservationService;

import java.util.Collection;
import java.util.Date;


public final class HotelResource {

    private final CustomerService customerService;
    private final ReservationService reservationService;

 
    public HotelResource(CustomerService customerService,
                          ReservationService reservationService) {
        this.customerService = customerService;
        this.reservationService = reservationService;
    }

 
    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }


    public void createACustomer(String email, String firstName, String lasName) {
        customerService.addCustomer(email, firstName, lasName);
    }

  
    public IRoom getRoom(String roomNumber) {
        return reservationService.getARoom(roomNumber);
    }

   
    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate,
                                 Date checkOutDate) {

        Customer customer = getCustomer(customerEmail);
        return reservationService.reserveARoom(customer, room, checkInDate,
                checkOutDate);
    }


    public Collection<Reservation> getCustomersReservations(String customerEmail) {

        Customer customer = getCustomer(customerEmail);
        return reservationService.getCustomersReservation(customer);
    }

  
    public Collection<IRoom> findARoom(Date checkIn, Date checkOut) {
        return reservationService.findRooms(checkIn, checkOut);
    }
}

package com.udacity.hotel.api;

import com.udacity.hotel.model.Customer;
import com.udacity.hotel.model.IRoom;
import com.udacity.hotel.model.Reservation;
import com.udacity.hotel.service.CustomerService;
import com.udacity.hotel.service.ReservationService;

import java.util.*;


public final class AdminResource {

    private final CustomerService customerService;
    private final ReservationService reservationService;

  
    public AdminResource(CustomerService customerService,
                          ReservationService reservationService) {
        this.customerService = customerService;
        this.reservationService = reservationService;
    }

   
    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

   
    public void addRoom(List<IRoom> rooms) {

        for (IRoom newRoom: rooms) {
            reservationService.addRoom(newRoom);
        }
    }

 
    public Collection<IRoom> getAllRooms() {

        Map<String, IRoom> allRooms = reservationService.getRooms();
        return new ArrayList<>(allRooms.values());
    }

   
    public Collection<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

  
    public Set<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }
}

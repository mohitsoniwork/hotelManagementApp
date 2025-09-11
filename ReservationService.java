package com.udacity.hotel.service;

import com.udacity.hotel.model.Customer;
import com.udacity.hotel.model.IRoom;
import com.udacity.hotel.model.Reservation;
import com.udacity.hotel.model.ReservationFactory;

import java.util.*;


public final class ReservationService {

    private static ReservationService instance;

    private final Set<Reservation> reservations;
    private final Map<String, IRoom> rooms;
    private final ReservationFactory reservationFactory;

    private ReservationService(ReservationFactory reservationFactory) {
        reservations = new HashSet<>();
        rooms = new HashMap<>();
        this.reservationFactory = reservationFactory;
    }

  
    public static ReservationService getInstance(ReservationFactory reservationFactory) {
        if (instance == null) {
            instance = new ReservationService(reservationFactory);
        }

        return instance;
    }

  
    public Map<String, IRoom> getRooms() {
        return rooms;
    }

   
    public void addRoom(IRoom room) {
        if (rooms.containsKey(room.getRoomNumber())) {
            throw new IllegalArgumentException("Room number " + room.getRoomNumber() +
                    " already exists");
        } else {
            rooms.put(room.getRoomNumber(), room);
        }
    }

 
    public IRoom getARoom(String roomId) {
        if (rooms.containsKey(roomId)) {
            return rooms.get(roomId);
        } else {
            throw new IllegalArgumentException("There is no room with number " +
                    roomId);
        }
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate,
                                    Date checkOutDate) {
        Reservation newReservation = reservationFactory.create(customer, room, checkInDate,
                checkOutDate);
        if (reservations.contains(newReservation)) {
            throw new IllegalArgumentException("This room is already reserved for these " +
                    "days");
        }
        reservations.add(newReservation);
        return newReservation;
    }

   
    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        // Copy all rooms
        Map<String, IRoom> availableRooms = new HashMap<>(this.rooms);

        // Compare with dates of existing reservations
        for (Reservation aReservation: this.reservations) {
            DatesCheckResult checkResult = checkDates(aReservation, checkInDate,
                    checkOutDate);
            boolean isCheckInOK = checkResult.isCheckInOK();
            boolean isCheckOutOK = checkResult.isCheckOutOK();
            if (! isCheckInOK || ! isCheckOutOK) {
                // Remove the room from the list of available rooms
                availableRooms.remove(aReservation.getRoom().getRoomNumber());
            }
        }

        return new ArrayList<>(availableRooms.values());
    }

 
    DatesCheckResult checkDates(Reservation reservation, Date checkIn, Date checkOut) {
        boolean isCheckInOK = checkIn.before(reservation.getCheckInDate()) ||
                checkIn.compareTo(reservation.getCheckOutDate()) >= 0;
        boolean isCheckOutOK = checkOut.compareTo(reservation.getCheckInDate()) <= 0 ||
                checkOut.after(reservation.getCheckOutDate());
        return new DatesCheckResult(isCheckInOK, isCheckOutOK);
    }

   
    public Collection<Reservation> getCustomersReservation(Customer customer) {

        List<Reservation> customersReservations = new ArrayList<>();
        for (Reservation aReservation: this.reservations) {
            if (aReservation.getCustomer().equals(customer)) {
                customersReservations.add(aReservation);
            }
        }

        return customersReservations;
    }

    public Set<Reservation> getAllReservations() {
        return reservations;
    }

   
    record DatesCheckResult(boolean isCheckInOK, boolean isCheckOutOK) {}
}

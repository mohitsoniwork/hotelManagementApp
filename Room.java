package com.udacity.hotel.model;


public class Room implements IRoom {

    private final String roomNumber;
    private final Double roomPrice;
    private final RoomType roomType;

  
    public Room(String roomNumber, Double roomPrice, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.roomPrice = roomPrice;
        this.roomType = roomType;
    }

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

  
    @Override
    public String toString() {
        return "Room number: " + roomNumber + ", price: " + roomPrice +
                ", type: " + roomType + ".";
    }

    @Override
    public final boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Room other)) {
            return false;
        }
        return (roomNumber == null && other.getRoomNumber() == null) ||
                (roomNumber != null && roomNumber.equals(other.getRoomNumber()));
    }

    @Override
    public final int hashCode() {
        int result = 17;
        if (roomNumber != null) {
            result = 31 * result + roomNumber.hashCode();
        }
        return result;
    }
}

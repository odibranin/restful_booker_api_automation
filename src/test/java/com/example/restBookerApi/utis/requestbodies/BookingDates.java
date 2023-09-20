package com.example.restBookerApi.utis.requestbodies;

public class BookingDates {
    private String checkIn;
    private String checkOut;

    public BookingDates(String checkIn, String checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }
}

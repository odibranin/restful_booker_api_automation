package com.example.restBookerApi.utis.requestbodies;

public class BookingDates {
    private String checkin;
    private String checkout;

    public BookingDates(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Object getCheckin() {
        return checkin;
    }

    public Object getCheckout() {
        return checkout;
    }
}

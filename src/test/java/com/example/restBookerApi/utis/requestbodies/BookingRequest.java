package com.example.restBookerApi.utis.requestbodies;

import org.json.JSONObject;


public class BookingRequest {
    private String firstname;
    private String lastname;
    private int intFirstname;
    private int intLastname;
    private int totalPrice;
    private boolean depositPaid;
    private BookingDates bookingdates;
    private String additionalNeeds;
    public JSONObject requestBody;

    public BookingRequest(String firstname,
                          String lastname,
                          int intFirstname,
                          int intLastname,
                          int totalPrice,
                          boolean depositPaid,
                          BookingDates bookingdates,
                          String additionalNeeds
                        ) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.intFirstname = intFirstname;
        this.intLastname = intLastname;
        this.totalPrice = totalPrice;
        this.depositPaid = depositPaid;
        this.bookingdates = bookingdates;
        this.additionalNeeds = additionalNeeds;
        this.requestBody = createMainBody();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder  {
        private String firstname;
        private String lastname;
        private int intFirstName;
        private int intLastName;
        private int totalPrice;
        private boolean depositPaid;
        private BookingDates bookingdates;
        private String additionalNeeds;

    public Builder setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public Builder setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public Builder setFirstname(int firstname) {
        this.intFirstName = firstname;
        return this;
    }

    public Builder setLastname(int lastname) {
        this.intLastName = lastname;
        return this;
        }

        public Builder setTotalprice(int totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public Builder setDepositpaid(boolean depositPaid) {
        this.depositPaid = depositPaid;
        return this;
    }

    public Builder setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
        return this;
    }

    public Builder setAdditionalNeeds(String additionalNeeds) {
        this.additionalNeeds = additionalNeeds;
        return this;
    }

    public BookingRequest build() {
       BookingRequest bookingRequest = new BookingRequest(
                firstname,
                lastname,
                intFirstName,
                intLastName,
                totalPrice,
                depositPaid,
                bookingdates,
                additionalNeeds);
        bookingRequest.createMainBody();
        return bookingRequest;
        }
    }

    private JSONObject createMainBody() {
        JSONObject data = new JSONObject();
        data.put("firstname", this.firstname);
        data.put("lastname", this.lastname);
        data.put("totalprice", this.totalPrice);
        data.put("depositpaid", this.depositPaid);

        if (this.bookingdates != null) {
            JSONObject bookingDatesObject = new JSONObject();
            bookingDatesObject.put("checkin", this.bookingdates.getCheckin());
            bookingDatesObject.put("checkout", this.bookingdates.getCheckout());
            data.put("bookingdates", bookingDatesObject);
        }

        data.put("additionalneeds", this.additionalNeeds);
        this.requestBody = data;
        return data;
    }
}

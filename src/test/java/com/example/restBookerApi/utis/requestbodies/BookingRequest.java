package com.example.restBookerApi.utis.requestbodies;
import org.json.JSONObject;

public class BookingRequest {
    private final String firstName;
    private final String lastName;
    private final int intFirstName;
    private final int intLastName;
    private final int totalPrice;
    private final boolean depositPaid;
    private final BookingDates bookingDates;
    private final String additionalNeeds;
    public JSONObject requestBody;

    private BookingRequest(String firstname,
                          String lastName,
                          int intFirstName,
                          int intLastName,
                          int totalPrice,
                          boolean depositPaid,
                          BookingDates bookingDates,
                          String additionalNeeds
    ) {
        this.firstName = firstname;
        this.lastName = lastName;
        this.intFirstName = intFirstName;
        this.intLastName = intLastName;
        this.totalPrice = totalPrice;
        this.depositPaid = depositPaid;
        this.bookingDates = bookingDates;
        this.additionalNeeds = additionalNeeds;
        this.requestBody = createMainBody();
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private int intFirstName;
        private int intLastName;
        private int totalPrice;
        private boolean depositPaid;
        private BookingDates bookingDates;
        private String additionalNeeds;

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
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

        public Builder setTotalPrice(int totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder setDepositPaid(boolean depositPaid) {
            this.depositPaid = depositPaid;
            return this;
        }

        public Builder setBookingDates(BookingDates bookingdates) {
            this.bookingDates = bookingdates;
            return this;
        }

        public Builder setAdditionalNeeds(String additionalNeeds) {
            this.additionalNeeds = additionalNeeds;
            return this;
        }

        public BookingRequest build() {
            BookingRequest bookingRequest = new BookingRequest(
                    firstName,
                    lastName,
                    intFirstName,
                    intLastName,
                    totalPrice,
                    depositPaid,
                    bookingDates,
                    additionalNeeds);
            bookingRequest.createMainBody();
            return bookingRequest;
        }
    }

    private JSONObject createMainBody() {
        JSONObject data = new JSONObject();
        data.put("firstname", this.firstName);
        data.put("lastname", this.lastName);
        data.put("totalprice", this.totalPrice);
        data.put("depositpaid", this.depositPaid);

        if (this.bookingDates != null) {
            JSONObject bookingDatesObject = new JSONObject();
            bookingDatesObject.put("checkin", this.bookingDates.getCheckIn());
            bookingDatesObject.put("checkout", this.bookingDates.getCheckOut());
            data.put("bookingdates", bookingDatesObject);
        }

        data.put("additionalneeds", this.additionalNeeds);
        this.requestBody = data;
        return data;
    }
}

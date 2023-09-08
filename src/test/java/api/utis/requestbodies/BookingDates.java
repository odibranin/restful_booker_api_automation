package api.utis.requestbodies;

public class BookingDates {
    private Object checkin;
    private Object checkout;

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

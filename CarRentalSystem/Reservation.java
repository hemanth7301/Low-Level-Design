import java.sql.Date;

import Product.Vehicle;

public class Reservation {
    int reservationId;
    User user;
    Vehicle vehicle;
    Date bookingDate;
    Date reservedDateFrom;
    Date reservedDateTo;
    ReservationType reservationType;
    Location pickUpLocation;
    Location dropLocation;

    public int reserve(User user, Vehicle vehicle, ReservationType reservationType) {

        this.reservationId = 1234;
        this.user = user;
        this.vehicle = vehicle;
        this.reservationType = reservationType;
        return this.reservationId;
    }
}

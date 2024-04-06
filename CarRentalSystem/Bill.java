public class Bill {

    Reservation reservation;
    double billAmount;

    public Bill(Reservation reservation) {
        this.reservation = reservation;
        computeBill(reservation);
        System.out.println("Bill Generated");
    }

    public double computeBill(Reservation reservation) {
        this.billAmount = 100;
        return billAmount;
    }
}

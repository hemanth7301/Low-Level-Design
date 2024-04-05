public class Bill {

    Reservation reservation;
    double billAmount;
    boolean billPaid;

    public Bill(Reservation reservation, double billAmount, boolean billPaid) {
        this.reservation = reservation;
        this.billAmount = billAmount;
        this.billPaid = billPaid;
    }

    public int computBill() {
        return 100;
    }
}

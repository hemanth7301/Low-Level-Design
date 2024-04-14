package Main;

public class Invoice {
    int totalItemPrice;
    int totalTax;
    int totalFinalPrice;

    public void generateInvoice(int price, int percent) {
        this.totalItemPrice = price;
        this.totalTax = totalItemPrice * percent / 100;
        this.totalFinalPrice = totalItemPrice + totalTax;

    }
}

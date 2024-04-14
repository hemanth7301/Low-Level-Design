package Order;

import java.util.Map;

import Main.Address;
import Main.Invoice;
import Payment.Payment;
import Payment.PaymentMode;
import Payment.UPIPaymentMode;
import User.User;
import Warehouse.Warehouse;

public class Order {
    User user;
    Address address;
    Warehouse warehouse;
    Invoice invoice;
    Payment payment;
    OrderStatus orderStatus;
    Map<Integer, Integer> productCategoryAndCountMap;

    Order(User user, Warehouse warehouse) {
        this.user = user;
        this.productCategoryAndCountMap = user.getUserCartDetails().getCart();
        this.warehouse = warehouse;
        this.address = user.getAddress();
        invoice = new Invoice();
    }

    public void checkout() {
        boolean isPaymentSuccessful = makePayment(new UPIPaymentMode());
        if (isPaymentSuccessful) {
            warehouse.removeItemFromInvventory(productCategoryAndCountMap);
        }
    }

    public boolean makePayment(PaymentMode paymentMode) {
        payment = new Payment(paymentMode);
        return payment.makePayment();
    }

    public void generateInvoice() {
        invoice.generateInvoice(100, 5);
    }
}

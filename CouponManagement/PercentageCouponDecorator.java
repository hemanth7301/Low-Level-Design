public class PercentageCouponDecorator extends CouponDecorator {
    Product product;
    int discountPercent;

    PercentageCouponDecorator(Product product, int discountPercent) {
        this.discountPercent = discountPercent;
        this.product = product;
    }

    public double getPrice() {
        double price = product.getPrice();
        return price - (price * discountPercent) / 100;
    }
}

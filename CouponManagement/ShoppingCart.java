import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Product> products;

    ShoppingCart() {
        products = new ArrayList<>();
    }

    public void addToCart(Product product) {
        Product productAfterDiscount = new TypeCouponDecorator(new PercentageCouponDecorator(product, 25), 10,
                product.getProductType());
        products.add(productAfterDiscount);
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
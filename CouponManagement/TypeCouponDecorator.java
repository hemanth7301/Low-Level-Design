import java.util.ArrayList;
import java.util.List;

public class TypeCouponDecorator extends Product {
    Product product;
    int discountPercent;
    ProductType productType;
    static List<ProductType> eligibleProductTypes = new ArrayList<>();
    static {
        eligibleProductTypes.add(ProductType.CAP);
    }

    public TypeCouponDecorator(Product product, int discountPercent, ProductType productType) {
        this.product = product;
        this.discountPercent = discountPercent;
        this.productType = productType;
    }

    public double getPrice() {
        double price = product.getPrice();
        if (eligibleProductTypes.contains(productType)) {
            return price - (price * discountPercent) / 100;
        }
        return price;
    }
}

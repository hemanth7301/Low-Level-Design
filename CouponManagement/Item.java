public class Item extends Product {
    Item(String name, double originalPrice, ProductType productType) {
        super(name, originalPrice, productType);
    }

    public double getPrice() {
        return originalPrice;
    }
}

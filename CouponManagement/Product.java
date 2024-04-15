public abstract class Product {
    String name;
    double originalPrice;
    ProductType productType;

    Product() {
    }

    public Product(String name, double originalPrice, ProductType productType) {
        this.name = name;
        this.originalPrice = originalPrice;
        this.productType = productType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public abstract double getPrice();

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public ProductType getProductType() {
        return productType;
    }

}

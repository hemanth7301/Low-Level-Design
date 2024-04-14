package Product;

import java.util.ArrayList;
import java.util.List;

public class ProductCategory {
    int categoryID;
    String categoryName;
    List<Product> products;
    double price;

    public ProductCategory() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int count) {
        for (int i = 1; i <= count; i++) {
            products.remove(0);
        }
    }

    public int getcategoryID() {
        return categoryID;
    }

    public void setcategoryID(int catergotyID) {
        this.categoryID = catergotyID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

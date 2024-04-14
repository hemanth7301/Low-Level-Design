package Main;

import java.util.*;

import Product.Product;
import Product.ProductCategory;

public class Inventory {
    List<ProductCategory> productCategories;

    public Inventory() {
        productCategories = new ArrayList<>();
    }

    public List<ProductCategory> getProductCategories() {
        return productCategories;
    }

    public void addProductCategory(int categoryID, String categoryName, double price) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName(categoryName);
        productCategory.setcategoryID(categoryID);
        productCategory.setPrice(price);
        productCategories.add(productCategory);
    }

    public void addProduct(Product product, int categoryID) {
        ProductCategory categoryObject = null;
        for (ProductCategory category : productCategories) {
            if (category.getcategoryID() == categoryID) {
                categoryObject = category;
            }
        }
        if (categoryObject != null) {
            categoryObject.addProduct(product);
        }
    }

    public ProductCategory getProductCategoryFromID(int categoryID) {
        for (ProductCategory productCategory : productCategories) {
            if (productCategory.getcategoryID() == categoryID) {
                return productCategory;
            }
        }
        return null;
    }

    public void removeItems(Map<Integer, Integer> productCategoryAndCountMap) {

        for (Map.Entry<Integer, Integer> entry : productCategoryAndCountMap.entrySet()) {
            ProductCategory category = getProductCategoryFromID(entry.getKey());
            category.removeProduct(entry.getValue());
        }

    }

}

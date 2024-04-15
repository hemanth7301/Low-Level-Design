package Main;

import Order.Order;
import Product.Product;
import Product.ProductCategory;
import User.User;
import User.UserController;
import Warehouse.NearestWarehouseSelection;
import Warehouse.Warehouse;
import Warehouse.WarehouseController;

public class Main {

    public static void main(String args[]) {
        Main mainObj = new Main();
        WarehouseController warehouseController = new WarehouseController();
        warehouseController.addWarehouse(mainObj.addWarehouseAndItsInventory());
        UserController userController = new UserController();
        userController.addUser(createUser());

        ProductDeliverySystem productDeliverySystem = new ProductDeliverySystem(userController, warehouseController);

        runDeliveryFlow(productDeliverySystem, 1);
    }

    public Warehouse addWarehouseAndItsInventory() {

        Warehouse warehouse = new Warehouse();

        Inventory inventory = new Inventory();

        inventory.addProductCategory(0001, "CHIPS", 100);
        inventory.addProductCategory(0002, "DRINKS", 50);

        Product product1 = new Product();
        product1.setProductID(1);
        product1.setProductName("LAYS");

        Product product2 = new Product();
        product2.setProductID(2);
        product2.setProductName("BINGO");

        Product product3 = new Product();
        product3.setProductID(3);
        product3.setProductName("COKE");

        inventory.addProduct(product1, 0001);
        inventory.addProduct(product2, 0001);
        inventory.addProduct(product3, 0002);

        warehouse.setInventory(inventory);
        return warehouse;
    }

    public static User createUser() {
        User user = new User();
        user.setUserID(1);
        user.setUsername("Hemanth");
        user.setAddress(new Address("singhnagar", "vijayawada", "india", 520015));
        return user;
    }

    public static void runDeliveryFlow(ProductDeliverySystem productDeliverySystem, int userId) {

        User user = productDeliverySystem.getUser(userId);
        Warehouse warehouse = productDeliverySystem.getWarehouse(new NearestWarehouseSelection());
        Inventory inventory = productDeliverySystem.getInventory(warehouse);
        ProductCategory productCategoryIWantToOrder = null;
        for (ProductCategory productCategory : inventory.getProductCategories()) {
            if (productCategory.getCategoryName().equals("DRINKS")) {
                productCategoryIWantToOrder = productCategory;
            }
        }
        if (productCategoryIWantToOrder == null) {
            System.out.println("Stock Unavailable");
        } else {
            productDeliverySystem.addProductToCart(user, productCategoryIWantToOrder, 2);
            Order order = productDeliverySystem.placeOrder(user, warehouse);
            productDeliverySystem.checkout(order);
        }
    }

}

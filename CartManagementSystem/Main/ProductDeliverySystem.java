package Main;

import Order.Order;
import Order.OrderController;
import Product.ProductCategory;
import User.User;
import User.UserController;
import Warehouse.Warehouse;
import Warehouse.WarehouseController;
import Warehouse.WarehouseSelectionStrategy;

public class ProductDeliverySystem {
    OrderController orderController;
    UserController userController;
    WarehouseController warehouseController;

    public ProductDeliverySystem(UserController userController,
            WarehouseController warehouseController) {
        this.orderController = new OrderController();
        this.userController = userController;
        this.warehouseController = warehouseController;
    }

    public User getUser(int userId) {
        return userController.getUser(userId);
    }

    public Warehouse getWarehouse(WarehouseSelectionStrategy warehouseSelectionStrategy) {
        return warehouseController.selectWarehouse(warehouseSelectionStrategy);
    }

    public Inventory getInventory(Warehouse warehouse) {
        return warehouse.getInventory();

    }

    public void addProductToCart(User user, ProductCategory product, int count) {
        Cart cart = user.getUserCartDetails();
        cart.addItemInCart(product.getcategoryID(), count);
    }

    public Order placeOrder(User user, Warehouse warehouse) {
        return orderController.createNewOrder(user, warehouse);
    }

    public void checkout(Order order) {
        order.checkout();
    }

}

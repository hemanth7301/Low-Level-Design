package Order;

import java.util.*;

import User.User;
import Warehouse.Warehouse;

public class OrderController {
    List<Order> orders;
    Map<Integer, List<Order>> userIDVsOrders;

    public OrderController() {
        orders = new ArrayList<>();
        userIDVsOrders = new HashMap<>();
    }

    public Order createNewOrder(User user, Warehouse warehouse) {
        Order order = new Order(user, warehouse);
        orders.add(order);
        if (userIDVsOrders.containsKey(user.getUserID())) {
            List<Order> userOrders = userIDVsOrders.get(user.getUserID());
            userOrders.add(order);
            userIDVsOrders.put(user.getUserID(), userOrders);
        } else {
            List<Order> userOrders = new ArrayList<>();
            userOrders.add(order);
            userIDVsOrders.put(user.getUserID(), userOrders);

        }
        return order;
    }

    public void removeOrder(Order order) {

    }

    public void getOrderByCustomerId(int userId) {

    }

    public void getOrderByOrderId(int orderId) {

    }

}

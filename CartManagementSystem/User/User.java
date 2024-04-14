package User;

import java.util.*;

import Main.*;

public class User {
    int userID;
    String username;
    Address address;
    Cart cart;
    List<Integer> orderIds;

    public User() {
        this.orderIds = new ArrayList<>();
        this.cart = new Cart();
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Integer> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<Integer> orderIds) {
        this.orderIds = orderIds;
    }

    public Cart getUserCartDetails() {
        return cart;
    }

    public Address getAddress() {
        return address;
    }

    public int getUserID() {
        return userID;
    }

}
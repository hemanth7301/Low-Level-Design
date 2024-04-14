package Warehouse;

import java.util.Map;

import Main.Address;
import Main.Inventory;

public class Warehouse {
    Inventory inventory;
    Address address;

    public void setAddress(Address address) {
        this.address = address;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Address getAddress() {
        return address;
    }

    public void addItemToInventory(Map<Integer, Integer> productCategoryAndCountMap) {

    }

    public void removeItemFromInvventory(Map<Integer, Integer> productCategoryAndCountMap) {
        inventory.removeItems(productCategoryAndCountMap);
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}

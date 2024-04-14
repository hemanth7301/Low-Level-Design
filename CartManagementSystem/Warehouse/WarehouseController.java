package Warehouse;

import java.util.ArrayList;
import java.util.List;

public class WarehouseController {
    List<Warehouse> warehouses;
    WarehouseSelectionStrategy warehouseSelectionStrategy = null;

    public WarehouseController() {
        warehouses = new ArrayList<>();
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void addWarehouse(Warehouse warehouse) {
        warehouses.add(warehouse);
    }

    public WarehouseController(List<Warehouse> warehouses, WarehouseSelectionStrategy warehouseSelectionStrategy) {
        this.warehouses = warehouses;
        this.warehouseSelectionStrategy = warehouseSelectionStrategy;
    }

    public void removeWarehouse(Warehouse warehouse) {
        warehouses.remove(warehouse);
    }

    public Warehouse selectWarehouse(WarehouseSelectionStrategy warehouseSelectionStrategy) {
        this.warehouseSelectionStrategy = warehouseSelectionStrategy;
        return warehouseSelectionStrategy.selectNearestWarehouse(warehouses);
    }
}

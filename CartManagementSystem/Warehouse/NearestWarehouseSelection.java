package Warehouse;

import java.util.List;

public class NearestWarehouseSelection extends WarehouseSelectionStrategy {
    public Warehouse selectNearestWarehouse(List<Warehouse> warehouses) {
        return warehouses.get(0);
    }
}

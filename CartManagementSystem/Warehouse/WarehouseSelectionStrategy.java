package Warehouse;

import java.util.List;

public abstract class WarehouseSelectionStrategy {
    public abstract Warehouse selectNearestWarehouse(List<Warehouse> warehouses);
}

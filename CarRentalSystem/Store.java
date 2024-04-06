import java.util.ArrayList;
import java.util.List;

import Product.Vehicle;
import Product.VehicleType;

public class Store {
    int storeId;
    InventoryManagement inventoryManagement;
    Location Location;
    List<Reservation> reservations = new ArrayList<>();

    Store() {
        this.inventoryManagement = new InventoryManagement();
    }

    public List<Vehicle> getVehicles(VehicleType vehicleType) {
        return inventoryManagement.getVehicles();
    }

    public void setVehicles(List<Vehicle> vehicles) {
        inventoryManagement.setVehicles(vehicles);
    }

    public Reservation createReservation(User user, Vehicle vehicle, ReservationType reservationType) {
        Reservation reservation = new Reservation();
        reservation.reserve(user, vehicle, reservationType);
        reservations.add(reservation);
        return reservation;
    }

    public boolean completeReservation(int reservationId) {
        return true;
    }

}

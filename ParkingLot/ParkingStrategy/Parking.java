package ParkingStrategy;

import Vehicle.Vehicle;

public class Parking {
    ParkingStrategy parkingStrategy;

    public Parking(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    public void park(Vehicle vehicle) {
        parkingStrategy.park(vehicle);
    }
}

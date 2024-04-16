package ParkingStrategy;

import Vehicle.Vehicle;

public class ParkNearToExitGate implements ParkingStrategy {
    public void park(Vehicle vehicle) {
        System.out.println("Parked the vehicle near Exit");
    }
}

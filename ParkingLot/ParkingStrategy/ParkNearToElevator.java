package ParkingStrategy;

import Vehicle.Vehicle;

public class ParkNearToElevator implements ParkingStrategy {
    public void park(Vehicle vehicle) {
        System.out.println("Parked the vehicle near Elevator");
    }
}

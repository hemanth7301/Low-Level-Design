package Main;

import ParkingSpot.ParkingSpot;
import Vehicle.Vehicle;

public class Ticket {
    long entryTime;
    Vehicle vehicle;
    ParkingSpot parkingSpot;

    public Ticket(long entryTime, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

}

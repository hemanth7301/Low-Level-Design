package ParkingSpot;

import Vehicle.Vehicle;

public class ParkingSpot {
    int parkingSpotID;
    Vehicle vehicle;
    int parkingPrice;
    boolean isEmpty = true;

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        isEmpty = false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        isEmpty = true;
    }

    public void setParkingPrice() {
    };

    public int getParkingPrice() {
        return parkingPrice;
    }

    public int getParkingSpotID() {
        return parkingSpotID;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
}

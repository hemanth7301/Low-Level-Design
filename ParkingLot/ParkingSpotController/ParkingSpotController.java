package ParkingSpotController;

import java.util.*;

import ParkingSpot.ParkingSpot;
import Vehicle.Vehicle;

public abstract class ParkingSpotController {
    List<ParkingSpot> parkingSpots;

    ParkingSpotController(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public void findParkingSpot(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.isEmpty()) {
                parkVehicle(parkingSpot, vehicle);
                return;
            }
        }
    }

    public void addParkingSpot(ParkingSpot parkingSpot) {
        parkingSpots.add(parkingSpot);
    }

    public void parkVehicle(ParkingSpot parkingSpot, Vehicle vehicle) {
        parkingSpot.parkVehicle(vehicle);
    }

    public void removeVehicle(ParkingSpot parkingSpot) {
        parkingSpot.removeVehicle();
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }
}

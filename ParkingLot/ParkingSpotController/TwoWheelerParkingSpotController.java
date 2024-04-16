package ParkingSpotController;

import java.util.*;

import ParkingSpot.ParkingSpot;
import ParkingSpot.TwoWheelerParkingSpot;
import ParkingStrategy.ParkNearToElevator;
import ParkingStrategy.Parking;
import Vehicle.Vehicle;

public class TwoWheelerParkingSpotController extends ParkingSpotController {
    static List<ParkingSpot> twoWheelerParkingSpots = new ArrayList<>(500);
    static {
        for (int i = 0; i < 500; i++) {
            twoWheelerParkingSpots.add(new TwoWheelerParkingSpot());
        }
    }
    Parking parking = new Parking(new ParkNearToElevator());;

    TwoWheelerParkingSpotController() {
        super(twoWheelerParkingSpots);
    }

    public void findParkingSpot(Vehicle vehicle) {
        parking.park(vehicle);
        super.findParkingSpot(vehicle);
    }

}

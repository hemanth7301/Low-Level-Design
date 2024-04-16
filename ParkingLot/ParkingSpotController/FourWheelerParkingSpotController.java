package ParkingSpotController;

import java.util.*;

import ParkingSpot.FourWheelerParkingSpot;
import ParkingSpot.ParkingSpot;
import ParkingStrategy.ParkNearToExitGate;
import ParkingStrategy.Parking;
import Vehicle.Vehicle;

public class FourWheelerParkingSpotController extends ParkingSpotController {
    static List<ParkingSpot> fourWheelerParkingSpots = new ArrayList<>(200);
    static {
        for (int i = 0; i < 200; i++) {
            fourWheelerParkingSpots.add(new FourWheelerParkingSpot());
        }
    }
    Parking parking = new Parking(new ParkNearToExitGate());

    FourWheelerParkingSpotController() {
        super(fourWheelerParkingSpots);
    }

    public void findParkingSpot(Vehicle vehicle) {
        parking.park(vehicle);
        super.findParkingSpot(vehicle);
    }

}

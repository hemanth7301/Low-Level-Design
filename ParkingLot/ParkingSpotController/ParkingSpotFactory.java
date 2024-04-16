package ParkingSpotController;

import Vehicle.VehicleType;

public class ParkingSpotFactory {
    public ParkingSpotController getParkingSpotController(VehicleType vehicleType) {
        switch (vehicleType) {
            case TWO_WHEELER:
                return new TwoWheelerParkingSpotController();
            case FOUR_WHEELER:
                return new FourWheelerParkingSpotController();
            default:
                return null;
        }
    }
}

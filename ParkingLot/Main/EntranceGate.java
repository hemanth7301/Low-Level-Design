package Main;

import java.util.List;

import ParkingSpotController.ParkingSpotController;
import ParkingSpotController.ParkingSpotFactory;
import Vehicle.VehicleType;

public class EntranceGate {
    ParkingSpotFactory parkingSpotFactory;
    ParkingSpotController parkingSpotController;
    List<Ticket> tickets;

    EntranceGate() {
        parkingSpotFactory = new ParkingSpotFactory();
    }

    public ParkingSpotController getParkingSpotController(VehicleType vehicleType) {
        this.parkingSpotController = parkingSpotFactory.getParkingSpotController(vehicleType);
        return parkingSpotController;
    }
}

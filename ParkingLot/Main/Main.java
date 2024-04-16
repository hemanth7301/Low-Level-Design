package Main;

import ParkingSpotController.ParkingSpotController;
import Vehicle.Vehicle;
import Vehicle.VehicleType;

public class Main {
    public static void main(String[] args) {

        EntranceGate entranceGate = new EntranceGate();
        ParkingSpotController parkingSpotController;

        Vehicle vehicleOne = new Vehicle("AP16EG0298", VehicleType.TWO_WHEELER);
        parkingSpotController = entranceGate.getParkingSpotController(vehicleOne.getVehicleType());
        parkingSpotController.findParkingSpot(vehicleOne);

        System.out.println(parkingSpotController.getParkingSpots().get(0).getVehicle().getVehicleNumber());
        System.out.println("--------------------");

        Vehicle vehicleTwo = new Vehicle("TS01KG9999", VehicleType.FOUR_WHEELER);
        parkingSpotController = entranceGate.getParkingSpotController(vehicleTwo.getVehicleType());
        parkingSpotController.findParkingSpot(vehicleTwo);

        System.out.println(parkingSpotController.getParkingSpots().get(0).getVehicle().getVehicleNumber());
        System.out.println("--------------------");

        Vehicle vehicleThree = new Vehicle("KA09FE2222", VehicleType.TWO_WHEELER);
        parkingSpotController = entranceGate.getParkingSpotController(vehicleThree.getVehicleType());
        parkingSpotController.findParkingSpot(vehicleThree);

        System.out.println(parkingSpotController.getParkingSpots().get(1).getVehicle().getVehicleNumber());
        System.out.println("--------------------");
    }
}

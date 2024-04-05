package Product;

public class Vehicle {

    int vehicleId;
    String company;
    String model;
    int cc;
    int dailyRentCost;
    int hourlyRentCost;
    int kmDriven;
    int noOfSeats;
    VehicleType vehicleType;
    Status status;

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public int getDailyRentCost() {
        return dailyRentCost;
    }

    public void setDailyRentCost(int dailyRentCost) {
        this.dailyRentCost = dailyRentCost;
    }

    public int getHourlyRentCost() {
        return hourlyRentCost;
    }

    public void setHourlyRentCost(int hourlyRentCost) {
        this.hourlyRentCost = hourlyRentCost;
    }

    public int getKmDriven() {
        return kmDriven;
    }

    public void setKmDriven(int kmDriven) {
        this.kmDriven = kmDriven;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
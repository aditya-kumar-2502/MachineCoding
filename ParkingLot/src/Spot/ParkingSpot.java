package Spot;

import Vehicle.Vehicle;
import Vehicle.VehicleType;

public class ParkingSpot {
    private final SpotType spotType;
    private Vehicle currentVehicle;

    public ParkingSpot(SpotType spotType) {
        this.spotType = spotType;
    }

    public Boolean isAvailable() {
        return currentVehicle == null;
    }

    public boolean canFit(VehicleType vehicleType) {
        return switch (vehicleType) {
            case MOTORCYCLE -> (spotType == SpotType.SMALL);
            case CAR -> (spotType == SpotType.MEDIUM);
            case TRUCK -> (spotType == SpotType.LARGE);
        };
    }

    public Boolean park(Vehicle vehicle){
        if(!isAvailable() || !canFit(vehicle.getVehicleType())){
            System.out.println("Cannot park vehicle: " + vehicle.getLicensePlate());
            return false;
        }
        currentVehicle = vehicle;
        System.out.println("Parked vehicle: " + vehicle.getLicensePlate());
        return true;
    }

    public void unpark(){
        if(isAvailable()){
            System.out.println("No vehicle to unpark");
        }
        System.out.println("Unparked vehicle: " + currentVehicle.getLicensePlate());
        currentVehicle = null;
    }

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }
}

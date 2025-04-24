import Vehicle.Vehicle;

import java.util.List;

public class ParkingLot {
    private static ParkingLot instance;
    private final List<Level> levels;

    public ParkingLot(List<Level> levels){
        this.levels = levels;
    }

    public void park(Vehicle vehicle){
        for(Level level : levels) {
            if(level.park(vehicle)) {
                return;
            }
        }
        System.out.println("No available spots for vehicle: " + vehicle.getLicensePlate());
    }

    public void unpark(String licensePlate){
        for(Level level : levels) {
            level.unpark(licensePlate);
        }
    }

    public void displayAvailableSpots() {
        for (Level level : levels) {
            System.out.println("Level " + level.getLevelNumber() + ": " + level.availableSpots() + " spots available.");
        }
    }
}

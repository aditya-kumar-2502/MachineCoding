import Spot.ParkingSpot;
import Vehicle.Vehicle;

import java.util.List;

public class Level {
    private int levelNumber;
    private List<ParkingSpot> parkingSpots;

    public Level(int levelNumber, List<ParkingSpot> parkingSpots) {
        this.levelNumber = levelNumber;
        this.parkingSpots = parkingSpots;
    }

    public boolean park(Vehicle vehicle){
        for(ParkingSpot spot : parkingSpots) {
            if(spot.park(vehicle)) {
                System.out.println("Vehicle parked on level " + levelNumber);
                return true;
            }
        }
        return false;
    }

    public void unpark(String licensePlate){
        for(ParkingSpot spot: parkingSpots){
            if(!spot.isAvailable() && spot.getCurrentVehicle().getLicensePlate().equals(licensePlate)){
                spot.unpark();
                System.out.println("Vehicle unparked from level " + levelNumber);
                return;
            }
        }
    }

    public int availableSpots() {
        return (int) parkingSpots.stream().filter(ParkingSpot::isAvailable).count();
    }

    public String getLevelNumber() {
        return String.valueOf(levelNumber);
    }
}

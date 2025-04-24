import Spot.ParkingSpot;
import Spot.SpotType;
import Vehicle.Vehicle;
import Vehicle.VehicleFactory;
import Vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ParkingSpot> level1Spots = new ArrayList<>();
        for (int i = 0; i < 2; i++) level1Spots.add(new ParkingSpot(SpotType.SMALL));
        for (int i = 2; i < 5; i++) level1Spots.add(new ParkingSpot(SpotType.MEDIUM));
        for (int i = 5; i < 7; i++) level1Spots.add(new ParkingSpot(SpotType.LARGE));

        Level level1 = new Level(1, level1Spots);
        ParkingLot lot = new ParkingLot(List.of(level1));

        Vehicle car = VehicleFactory.createVehicle(VehicleType.CAR, "KA-01-AB-1234");
        Vehicle bike = VehicleFactory.createVehicle(VehicleType.MOTORCYCLE, "KA-02-CD-5678");

        lot.park(car);
        lot.park(bike);

        lot.displayAvailableSpots();

        lot.unpark("KA-01-AB-1234");
//        lot.displayAvailableSpots();
    }
}
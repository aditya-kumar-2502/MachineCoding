package Vehicle;

public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType type, String licensePlate) {
        return switch (type) {
            case MOTORCYCLE -> new Motorcycle(licensePlate);
            case CAR -> new Car(licensePlate);
            case TRUCK -> new Truck(licensePlate);
        };
    }
}
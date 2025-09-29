package src;

public class VehicleFactory {

    public Vehicle createVehicle(String type) {
        if (type == null) {
            return null;
        }

        switch (type.toUpperCase()) {
            case "CAR":
                return new Car();
            case "BIKE":
                return new Bike();
            case "TRUCK":
                return new Truck();
            default:
                return null;
        }
    }
}

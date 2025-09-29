import src.*;
public class Main {

    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();

        Vehicle car = factory.createVehicle("CAR");
        if (car != null) {
            car.start();
            car.stop();
        }

        Vehicle bike = factory.createVehicle("BIKE");
        if (bike != null) {
            bike.start();
            bike.stop();
        }

        Vehicle truck = factory.createVehicle("TRUCK");
        if (truck != null) {
            truck.start();
            truck.stop();
        }
    }
}

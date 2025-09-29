package src;

public class Car implements Vehicle {

    @Override
    public void start() {
        System.out.println("Car started. Ready for a comfortable ride.");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped. Parking mode activated.");
    }
}

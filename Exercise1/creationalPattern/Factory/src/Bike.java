package src;

public class Bike implements Vehicle {

    @Override
    public void start() {
        System.out.println("Bike started. Vroom vroom!");
    }

    @Override
    public void stop() {
        System.out.println("Bike stopped. Kickstand applied.");
    }
}

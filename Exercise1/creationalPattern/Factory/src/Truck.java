package src;

public class Truck implements Vehicle {

    @Override
    public void start() {
        System.out.println("Truck started. Heavy-duty transport mode.");
    }

    @Override
    public void stop() {
        System.out.println("Truck stopped. Cargo secured.");
    }
}

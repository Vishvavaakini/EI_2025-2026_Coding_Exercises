package src.core;

public class ConsoleRoverObserver implements RoverObserver {

    @Override
    public void onRoverEvent(RoverEvent event) {
        System.out.println("[Rover] " + event.message());
    }
}

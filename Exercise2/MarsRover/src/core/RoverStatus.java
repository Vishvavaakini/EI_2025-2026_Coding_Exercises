package src.core;

public record RoverStatus(Position position, Direction direction, String message) {
    @Override
    public String toString() {
        return "Rover is at " + position + " facing " + direction + ". " + message;
    }
}

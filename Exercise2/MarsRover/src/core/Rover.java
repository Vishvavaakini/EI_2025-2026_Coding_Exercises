package src.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import src.exception.OutOfBoundException;
import src.grid.Grid;

public class Rover {

    private Position position;
    private Direction direction;
    private final Grid grid;
    private final List<RoverObserver> observers = new ArrayList<>();
    private final Set<Position> encounteredObstacles = new HashSet<>();
    private String status = "Operational";

    public Rover(Position position, Direction direction, Grid grid) {
        if (!grid.isWithinBounds(position)) {
            throw new IllegalArgumentException("Starting position out of bounds");
        }
        this.position = position;
        this.direction = direction;
        this.grid = grid;
        notifyObservers(new RoverEvent("Initialized at " + position + " facing " + direction));
    }

    public void addObserver(RoverObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(RoverEvent event) {
        for (RoverObserver observer : observers) {
            observer.onRoverEvent(event);
        }
    }

    public void move() throws OutOfBoundException {
        Position newPos = position.move(direction);
        if (!grid.isWithinBounds(newPos)) {
            status = "Blocked: Out of bounds";
            throw new OutOfBoundException("Move out of bounds: " + newPos);

        }
        if (grid.isObstacle(newPos)) {
            status = "Blocked: Obstacle detected";
            encounteredObstacles.add(newPos);
            notifyObservers(new RoverEvent("Obstacle detected at " + newPos + ". Rover stopped."));

            return;
        }
        this.position = newPos;
        status = "Operational";
        notifyObservers(new RoverEvent("Moved to " + position));
    }

    public void turnLeft() {
        direction = direction.turnLeft();
        notifyObservers(new RoverEvent("Turned left. Now facing " + direction));
    }

    public void turnRight() {
        direction = direction.turnRight();
        notifyObservers(new RoverEvent("Turned right. Now facing " + direction));
    }

    public RoverStatus getStatus() {
        return new RoverStatus(position, direction, status);
    }

    public Set<Position> getEncounteredObstacles() {
        return new HashSet<>(encounteredObstacles);
    }
}

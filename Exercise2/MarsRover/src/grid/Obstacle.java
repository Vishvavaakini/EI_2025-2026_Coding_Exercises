package src.grid;

import src.core.Position;

public class Obstacle implements GridComponent {

    private final Position position;

    public Obstacle(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean isObstacle(Position pos) {
        return this.position.equals(pos);
    }

    @Override
    public void display() {
        System.out.println("Obstacle at (" + position.getX() + ", " + position.getY() + ")");
    }
}

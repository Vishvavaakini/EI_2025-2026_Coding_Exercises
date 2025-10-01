package src.grid;

import src.core.Position;

public interface GridComponent {

    boolean isObstacle(Position pos);

    void display();
}

package src.grid;

import java.util.logging.Logger;
import src.core.Direction;
import src.core.Position;

public class GridValidator {

    private static final Logger logger = Logger.getLogger(GridValidator.class.getName());

    public static int[] validateGridSize(int width, int height) {
        if (width <= 0 || height <= 0) {
            logger.warning("Invalid grid size. Defaulting to 5x5 grid.");
            return new int[]{5, 5};
        }
        return new int[]{width, height};
    }

    public static Direction validateDirection(String dirStr) {
        try {
            return Direction.valueOf(dirStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            logger.warning("Invalid direction input. Defaulting to North.");
            return Direction.N;
        }
    }

    public static Position validateStartPosition(Grid grid, Position pos) {
        if (!grid.isWithinBounds(pos) || grid.isObstacle(pos)) {
            // try (0,0) first
            if (!grid.isObstacle(new Position(0, 0))) {
                logger.warning("Invalid or blocked starting position. Defaulting to (0,0).");
                return new Position(0, 0);
            } else {
                logger.severe("No valid starting position available. Exiting.");
                throw new IllegalStateException("No valid starting position");
            }
        }
        return pos;

    }
}

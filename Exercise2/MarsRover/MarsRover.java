
import java.util.*;
import src.commands.*;
import src.core.*;
import src.exception.*;
import src.grid.*;

public class MarsRover {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter grid size (width height): ");
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        int[] validatedSize = GridValidator.validateGridSize(width, height);
        Grid grid = new Grid(validatedSize[0], validatedSize[1]);

        System.out.println("Enter number of obstacles: ");
        int obstacleCount = scanner.nextInt();
        for (int i = 0; i < obstacleCount; i++) {
            System.out.println("Obstacle " + (i + 1) + " position (x y): ");
            int ox = scanner.nextInt();
            int oy = scanner.nextInt();
            if (!grid.isWithinBounds(new Position(ox, oy))) {
                System.out.println("⚠️ Obstacle at (" + ox + "," + oy + ") is outside grid. Skipping.");
                continue;
            }
            grid.addTerrainFeature(new Obstacle(new Position(ox, oy)));
        }

        System.out.println("Enter starting position (x y direction[N/E/S/W]): ");
        int sx = scanner.nextInt();

        int sy = scanner.nextInt();
        String dirStr = scanner.next();
        Direction dir = GridValidator.validateDirection(dirStr);
        Position startPos = new Position(sx, sy);
        try {
            startPos = GridValidator.validateStartPosition(grid, startPos);
        } catch (IllegalStateException e) {
            System.err.println("ERROR: " + e.getMessage());
            System.out.println("No valid starting position available. Exiting program.");
            return;
        }

        Rover rover = new Rover(startPos, dir, grid);
        rover.addObserver(new ConsoleRoverObserver()); // Observer pattern
        System.out.println("Enter commands (e.g., MMLMR): ");
        String commandString = scanner.next().toUpperCase();

        for (char c : commandString.toCharArray()) {
            try {
                Command command = CommandFactory.create(c);
                command.execute(rover);
            } catch (OutOfBoundException e) {
                System.err.println("OutOfBound Error: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Error executing command " + c + ": " + e.getMessage());
            }
        }

        System.out.println(rover.getStatus());

        Set<Position> obstacles = rover.getEncounteredObstacles();
        if (!obstacles.isEmpty()) {
            System.out.print("Rover encountered obstacles at:");
            for (Position obs : obstacles) {
                System.out.print(" " + obs);
            }
            System.out.println();
        }
    }
}

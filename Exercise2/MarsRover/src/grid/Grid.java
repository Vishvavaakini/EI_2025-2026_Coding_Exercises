package src.grid;

import java.util.ArrayList;
import java.util.List;
import src.core.Position;

public class Grid implements GridComponent {

    private final int width;
    private final int height;
    private final List<GridComponent> terrainFeatures = new ArrayList<>();

    public Grid(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Grid size must be > 0");
        }
        this.width = width;
        this.height = height;
    }

    public boolean isWithinBounds(Position pos) {
        return pos.getX() >= 0 && pos.getX() < width
                && pos.getY() >= 0 && pos.getY() < height;
    }

    public void addTerrainFeature(GridComponent component) {
        terrainFeatures.add(component);
    }

    @Override
    public boolean isObstacle(Position pos) {
        return terrainFeatures.stream().anyMatch(f -> f.isObstacle(pos));
    }

    @Override
    public void display() {
        System.out.println("Grid (" + width + " x " + height + ")");
        for (GridComponent feature : terrainFeatures) {
            feature.display();
        }
    }
}

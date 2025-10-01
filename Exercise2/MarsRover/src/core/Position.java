package src.core;

public final class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        if (x < 0 || y < 0) throw new IllegalArgumentException("Negative coordinates not allowed");
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public Position move(Direction dir) {
        return switch (dir) {
            case N -> new Position(x, y + 1);
            case S -> new Position(x, y - 1);
            case E -> new Position(x + 1, y);
            case W -> new Position(x - 1, y);
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position p = (Position) o;
        return x == p.x && y == p.y;
    }

    @Override
    public int hashCode() {
        return x * 31 + y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

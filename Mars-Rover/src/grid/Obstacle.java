package grid;

public class Obstacle {
    private int x;
    private int y;

    public Obstacle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isAt(int x, int y) {
        return this.x == x && this.y == y;
    }
}

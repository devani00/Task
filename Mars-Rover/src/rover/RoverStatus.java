package rover;

public class RoverStatus {
    private int x;
    private int y;
    private char direction;

    public RoverStatus(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Rover is at (" + x + ", " + y + ") facing " + direction + ".";
    }
}

package rover;

import grid.Grid;

public class Rover {
    private int x;
    private int y;
    private char direction; // 'N', 'S', 'E', 'W'
    private Grid grid;

    public Rover(int x, int y, char direction, Grid grid) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.grid = grid;
    }

    public void move() {
        int newX = x, newY = y;
        switch (direction) {
            case 'N': newY++; break;
            case 'S': newY--; break;
            case 'E': newX++; break;
            case 'W': newX--; break;
        }

        if (grid.isWithinBounds(newX, newY) && !grid.isObstacleAt(newX, newY)) {
            x = newX;
            y = newY;
        }
    }

    public void turnLeft() {
        switch (direction) {
            case 'N': direction = 'W'; break;
            case 'S': direction = 'E'; break;
            case 'E': direction = 'N'; break;
            case 'W': direction = 'S'; break;
        }
    }

    public void turnRight() {
        switch (direction) {
            case 'N': direction = 'E'; break;
            case 'S': direction = 'W'; break;
            case 'E': direction = 'S'; break;
            case 'W': direction = 'N'; break;
        }
    }

    public RoverStatus getStatus() {
        return new RoverStatus(x, y, direction);
    }
}

import commands.*;
import grid.Grid;
import grid.Obstacle;
import rover.Rover;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Set up the grid and obstacles
        System.out.println("Enter grid size (width height): ");
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        Grid grid = new Grid(width, height);

        System.out.println("Enter number of obstacles: ");
        int numObstacles = scanner.nextInt();

        for (int i = 0; i < numObstacles; i++) {
            System.out.println("Enter obstacle position (x y): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            grid.addObstacle(new Obstacle(x, y));
        }

        // Step 2: Initialize the rover
        System.out.println("Enter rover starting position (x y) and direction (N/S/E/W): ");
        int roverX = scanner.nextInt();
        int roverY = scanner.nextInt();
        char direction = scanner.next().toUpperCase().charAt(0);

        Rover rover = new Rover(roverX, roverY, direction, grid);

        boolean continueRunning = true;
        while (continueRunning) {
            // Step 3: Get user input for the command
            System.out.println("Enter command (M for Move, L for Left, R for Right, Q to Quit): ");
            char command = scanner.next().toUpperCase().charAt(0);

            // Step 4: Execute the command
            Command roverCommand = null;

            switch (command) {
                case 'M':
                    roverCommand = new MoveCommand(rover);
                    break;
                case 'L':
                    roverCommand = new TurnLeftCommand(rover);
                    break;
                case 'R':
                    roverCommand = new TurnRightCommand(rover);
                    break;
                case 'Q':
                    continueRunning = false;
                    System.out.println("Exiting simulation.");
                    continue;
                default:
                    System.out.println("Invalid command! Please enter M, L, R, or Q.");
                    continue;
            }

            if (roverCommand != null) {
                roverCommand.execute();
                System.out.println(rover.getStatus()); // Step 5: Display current status
            }

            System.out.println();
        }

        scanner.close();
    }
}

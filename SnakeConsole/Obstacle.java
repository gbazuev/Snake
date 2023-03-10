package SnakeConsole;

import java.util.Random;

public class Obstacle {
    final char SYMBOL = '#';
    int number;
    int[][] coordinates;
    final String LEVEL = "EASY";

    public void generateObstacles(Field field) {
        Random random = new Random();
        if (LEVEL.equals("EASY")) number = field.SIZE * field.SIZE / 10;
        if (LEVEL.equals("MIDDLE")) number = field.SIZE * field.SIZE / 4;
        if (LEVEL.equals("HARD")) number = field.SIZE * field.SIZE / 2;

        coordinates = new int[number][2];
        for (int i = 0; i < number; i++) {
            field.countAvailableCells();
            coordinates[i] = field.availableCells[random.nextInt(field.availableCells.length)];
            field.gameField[coordinates[i][0]][coordinates[i][1]] = SYMBOL;
        }
    }

    public boolean checkCollision(Snake snake) {
        for (int i = 0; i < coordinates.length; i++) {
            if (snake.getHeadCoordinates()[0] == coordinates[i][0] &&
                    snake.getHeadCoordinates()[1] == coordinates[i][1]) {
                return true;
            }
        }
        return false;
    }

    public void printObstacles(Field field) {
        for (int i = 0; i < coordinates.length; i++)    {
            field.gameField[coordinates[i][0]][coordinates[i][1]] = SYMBOL;
        }
    }
}

package SnakeConsole;

import java.util.Random;

public class Fruit {
    Random random = new Random();
    final char SYMBOL = '*';
    int[] coordinates;

    public int[] getCoordinates() {
        return coordinates;
    }

    public void generateFruit(Field field) {
        int coordinatesPointer = random.nextInt(field.availableCells.length - 1);
        coordinates = field.availableCells[coordinatesPointer];
        field.gameField[coordinates[0]][coordinates[1]] = SYMBOL;
    }

    public void checkCollision(Snake snake, Field field) {
        if (snake.getHeadCoordinates()[0] == getCoordinates()[0] &&
        snake.getHeadCoordinates()[1] == getCoordinates()[1]) {
            deleteFruit(field);
            snake.length++;
            generateFruit(field);
            printFruit(field);
            snake.updateSnake();
        }
    }

    public void deleteFruit(Field field)    {
        field.gameField[getCoordinates()[0]][getCoordinates()[1]] = ' ';
    }

    public void printFruit(Field field) {
        field.gameField[getCoordinates()[0]][getCoordinates()[1]] = SYMBOL;
    }
}
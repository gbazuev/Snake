package SnakeGame;

import java.util.Scanner;

public class Motioner {
    final char startDirection = 'd';
    final int coordinatesRows = 2;
    int coordinatesCols = 0;
    char previousDirection = 'd';
    char direction;
    int movePointer;
    //Хранит направление головы змейки в определённых точках
    char[] changedDirections;

    //Хранит координаты точек, в которых голова змейки изменила своё направление
    int[][] changedCoordinates;
    int[] pointers;

    Motioner(Snake snake) {
        initializePointers(snake);
    }

    void move(Field field, Scanner scanner, Snake snake) {
        this.direction = scanner.next().charAt(0);

        if (this.movePointer == 0 || this.previousDirection != this.direction) {
            enlargingArrays(snake);
            this.changedDirections[coordinatesCols - 1] = previousDirection;

            //Та точка, где меняется направление - точка положения головы змейки
            this.changedCoordinates[coordinatesCols - 1] = snake.getHeadCoordinates();
        }

        else if (snake.coordinates[snake.coordinates.length - 1][0] == this.changedCoordinates[0][0] &&
                snake.coordinates[snake.coordinates.length - 1][1] == this.changedCoordinates[0][1]) {
            reducingArrays();
        }

        else if (this.previousDirection != this.direction) {
            enlargingArrays(snake);
            this.changedDirections[coordinatesCols - 1] = previousDirection;

            //Та точка, где меняется направление - точка положения головы змейки
            this.changedCoordinates[coordinatesCols - 1] = snake.getHeadCoordinates();
        }
        previousDirection = direction;
        updateHeadCoordinates(snake);
        updateBodyCoordinates(snake);
        this.movePointer++;
    }

    private void enlargingArrays(Snake snake) {
        char[] localDirections = new char[this.coordinatesCols + 1];
        for (int i = 0; i < this.coordinatesCols; i++) {
            localDirections[i] = this.changedDirections[i];
        }

        int[][] localCoordinates = new int[this.coordinatesCols + 1][this.coordinatesRows];
        for (int i = 0; i < this.coordinatesCols; i++) {
            localCoordinates[i] = this.changedCoordinates[i];
        }

        this.changedDirections = localDirections;
        this.changedCoordinates = localCoordinates;
        coordinatesCols++;
    }

    private void reducingArrays() {
        char[] localDirections = new char[this.coordinatesCols - 1];
        for (int i = 1; i < this.coordinatesCols; i++) {
            localDirections[i - 1] = this.changedDirections[i];
        }

        int[][] localCoordinates = new int[this.coordinatesCols - 1][this.coordinatesRows];
        for (int i = 1; i < this.coordinatesCols; i++) {
            localCoordinates[i - 1] = this.changedCoordinates[i];
        }

        this.changedDirections = localDirections;
        this.changedCoordinates = localCoordinates;
        updatePointers();
        coordinatesCols--;
    }

    private void
    updateBodyCoordinates(Snake snake) {
       for (int i = 1; i < snake.length; i++)   {
            if (this.changedDirections.length == 0) {
                int[] localDirectionPoint = this.changedCoordinates[i];
                int[] elementCoordinates = snake.coordinates[i];

            }
       }
    }

    private void updateHeadCoordinates(Snake snake) {
        if (direction == 'w' || direction == 'W') {
            snake.coordinates[0][0]--;
        } else if (direction == 'a' || direction == 'A') {
            snake.coordinates[0][1]--;
        } else if (direction == 's' || direction == 'S') {
            snake.coordinates[0][0]++;
        } else if (direction == 'd' || direction == 'D') {
            snake.coordinates[0][1]++;
        }
    }


    private void initializePointers(Snake snake) {
        this.pointers = new int[snake.length - 1];
        for (int i = 0; i < this.pointers.length; i++) {
            this.pointers[i] = 0;
        }
    }

    private void updatePointers() {
        if (this.changedDirections.length != 1) {
            this.pointers[0] = 0;
            for (int i = 1; i < this.pointers.length; i++) {
                this.pointers[i]--;
            }
            return;
        }
        for (int i = 0; i < this.pointers.length; i++) {
            this.pointers[i] = 0;
        }
    }

    private void moveBodyElement(Snake snake, char localDirection, int pointer) {
        if (localDirection == 'w' || localDirection == 'W') {
            snake.coordinates[pointer][0]--;
        } else if (localDirection == 'a' || localDirection == 'A') {
            snake.coordinates[pointer][1]--;
        } else if (localDirection == 's' || localDirection == 'S') {
            snake.coordinates[pointer][0]++;
        } else if (localDirection == 'd' || localDirection == 'D') {
            snake.coordinates[pointer][1]++;
        }
    }
}
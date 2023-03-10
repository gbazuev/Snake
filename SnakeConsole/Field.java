package SnakeConsole;

public class Field {
    final int SIZE = 15;
    char gameField[][];
    int[][] availableCells;

    void initializeField() {
        gameField = new char[SIZE][SIZE];
        availableCells = new int[SIZE * SIZE][2];
        clearField();
    }

    void printField() {
        System.out.println("\n\n");

        for (int up = 0; up < SIZE + 1; up++)  {
            System.out.print(" - ");
        }

        System.out.println();

        for (int cols = 0; cols < SIZE; cols++) {
            System.out.print("[");
            for (int rows = 0; rows < SIZE; rows++) {
                System.out.print(" " + gameField[cols][rows] + " ");
            }
            System.out.println("]");
        }

        for (int down = 0; down < SIZE + 1; down++)  {
            System.out.print(" - ");
        }
        System.out.println();
    }

    void printSnake(Snake snake) {
        for (int element = 0; element < snake.length; element++) {
            int[] coordinates = snake.getCoordinates(element);
            if (snake.isBeyondBorders(this))    {
                System.out.println("Game over");
                System.exit(1);
            }
            gameField[coordinates[0]][coordinates[1]] = snake.getSymbol(element);
        }
    }

    public void clearField() {
        for (int cols = 0; cols < SIZE; cols++) {
            for (int rows = 0; rows < SIZE; rows++) {
                gameField[cols][rows] = ' ';
            }
        }
    }

    public void countAvailableCells() {
        int localPointer = 0;
        for (int col = 0; col < SIZE; col++) {
            for (int row = 0; row < SIZE; row++) {
                if (gameField[row][col] == ' ') {
                    availableCells[localPointer] = new int[]{row, col};
                    localPointer++;
                }
            }
        }
    }

     void reduceAvailableCells() {
        int[][] localAvailableCells = new int[availableCells.length - 1][2];
        for (int col = 0; col < localAvailableCells.length; col++) {
            localAvailableCells[col] = availableCells[col];
        }
        availableCells = localAvailableCells;
    }
}
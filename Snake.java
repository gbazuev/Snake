package SnakeGame;

import java.util.Scanner;

public class Snake {
    final char headSymbol;
    final char bodySymbol;
    int length = 3;
    int[][] coordinates;

    Snake(Scanner scanner) {
        System.out.println("Please enter snake's head symbol: ");
        this.headSymbol = scanner.next().charAt(0);

        System.out.println("Please enter snake's body symbol: ");
        this.bodySymbol = scanner.next().charAt(0);
    }

    void placeSnake(char[][] gameField) {
        this.coordinates = new int[3][2];
        int headLocation = gameField.length / 2;
        gameField[headLocation][headLocation] = this.headSymbol;
        this.coordinates[0][0] = headLocation;
        this.coordinates[0][1] = headLocation;

        gameField[headLocation][headLocation - 1] = this.bodySymbol;
        this.coordinates[1][0] = headLocation;
        this.coordinates[1][1] = headLocation - 1;

        gameField[headLocation][headLocation - 2] = this.bodySymbol;
        this.coordinates[2][0] = headLocation;
        this.coordinates[2][1] = headLocation - 2;
    }


    void printSnake(char[][] field) {
        for (int i = 0; i < this.coordinates.length; i++) {
            if (i == 0) {
                field[this.coordinates[i][0]][this.coordinates[i][1]] = headSymbol;
            } else {
                field[this.coordinates[i][0]][this.coordinates[i][1]] = bodySymbol;
            }
        }
    }

    int[] getHeadCoordinates()  {
        return new int[] {this.coordinates[0][0], this.coordinates[0][1]};
    }
}

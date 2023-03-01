package SnakeGame;

import java.util.Scanner;

public class Field {
    char[][] gameField;

    Field(Scanner scanner, Snake snake) {
        System.out.print("Please enter field size: ");
        int size = validateFieldSize(scanner, scanner.nextInt());
        gameField = new char[size][size];
        initializeField();
        snake.placeSnake(this.gameField);
    }

    void initializeField()  {
        for (int cols = 0; cols < this.gameField.length; cols++) {
            for (int rows = 0; rows < this.gameField[0].length; rows++) {
                this.gameField[cols][rows] = ' ';
            }
        }
    }

    int validateFieldSize(Scanner scanner, int size)    {
        while (size < 6)    {
            System.out.print("You can't create game field with such small size! Try again: ");
            size = scanner.nextInt();
        }

        return size;
    }

    void printField()   {
        for (int i = 0; i < this.gameField.length; i++) {
            for (int j = 0; j < this.gameField[0].length; j++)  {
                System.out.print("[" + this.gameField[i][j] + "]");
            }
            System.out.println();
        }
    }

    void clear()    {
        for (int i = 0; i < this.gameField.length; i++) {
            for (int j = 0; j < this.gameField[0].length; j++)  {
                if (this.gameField[i][j] != ' ')    {
                    this.gameField[i][j] = ' ';
                }
            }
        }
    }
}
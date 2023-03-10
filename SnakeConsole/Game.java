package SnakeConsole;

import java.util.Scanner;

public class Game {
    Field field = new Field();
    Snake snake = new Snake(field);
    Obstacle obstacle = new Obstacle();
    Fruit fruit = new Fruit();
    Scanner scanner = new Scanner(System.in);
    char direction = 'D';

    void initialize() {

        field.initializeField();
        field.printSnake(snake);
        obstacle.generateObstacles(field);

        field.countAvailableCells();

        fruit.generateFruit(field);
        fruit.printFruit(field);

        field.printField();
    }

    void play() {
        move(snake, fruit, field);
        if (snake.isBeyondBorders(field)) {
            System.out.print("Game over! Snake is beyond the game borders!");
        }

        field.clearField();

        obstacle.printObstacles(field);
        field.printSnake(snake);
        field.countAvailableCells();

        fruit.printFruit(field);
        field.printField();

        if (snake.checkBitten()) {
            System.out.print("Game over! The snake bit itself");
            System.exit(1);
        }

        if (obstacle.checkCollision(snake)) {
            System.out.println("Game over! The snake crashed into an obstacle");
            System.exit(1);
        }

    }

    private void move(Snake snake, Fruit fruit, Field field) {
        validateDirection(scanner.next().toUpperCase().charAt(0));
        snake.updateBodyCoordinates(snake);

        snake.updateHeadCoordinates(snake, direction);
        fruit.checkCollision(snake, field);
    }

    private void validateDirection(char localDirection) {
            while ((localDirection == 'W' && direction == 'S') ||
                    (localDirection == 'S' && direction == 'W') ||
                    (localDirection == 'A' && direction == 'D') ||
                    (localDirection == 'D' && direction == 'A'))    {
                System.out.print("Incorrect! Try again: ");
                localDirection = scanner.next().toUpperCase().charAt(0);
            }
            direction = localDirection;
        }
}

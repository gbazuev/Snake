package SnakeGame;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Snake snake = new Snake(scanner);
        Field field = new Field(scanner, snake);
        Motioner motioner = new Motioner(snake);

        field.printField();
        while (true)    {
            motioner.move(field, scanner, snake);
            field.clear();
            snake.printSnake(field.gameField);
            field.printField();
        }
    }
}

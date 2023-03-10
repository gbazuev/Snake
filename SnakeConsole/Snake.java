package SnakeConsole;

public class Snake {
    final char HEAD = 'X';
    final char BODY = '0';
    int length;
    int[][] coordinates;

    Snake(Field field) {
        coordinates = new int[3][2];
        length = 3;

        setHeadCoordinates(new int[]{field.SIZE / 2, field.SIZE / 2});

        //Устанавливаем координаты частей тела
        for (int element = 1; element < length; element++) {
            setCoordinates(new int[]{field.SIZE / 2, field.SIZE / 2 - element}, element);
        }
    }

    public int[] getCoordinates(int pointer) {
        return coordinates[pointer];
    }

    public void setCoordinates(int[] outputCoordinates, int pointer) {
        coordinates[pointer] = outputCoordinates;
    }

    public int[] getHeadCoordinates() {
        return coordinates[0];
    }

    public void setHeadCoordinates(int[] outputCoordinates) {
        coordinates[0] = outputCoordinates;
    }

    public char getSymbol(int pointer) {
        return pointer == 0 ? HEAD : BODY;
    }

    public void updateSnake() {
        int[][] localCoordinates = new int[length][2];
        for (int cols = 0; cols < coordinates.length; cols++) {
            for (int rows = 0; rows < coordinates[0].length; rows++) {
                localCoordinates[cols][rows] = coordinates[cols][rows];
            }
        }
        localCoordinates[length - 1] = getCoordinates(length - 2);
        coordinates = localCoordinates;
    }

    public boolean checkBitten() {
        for (int i = 1; i < coordinates.length; i++) {
            if (getHeadCoordinates()[0] == getCoordinates(i)[0] &&
            getHeadCoordinates()[1] == getCoordinates(i)[1])    {
                return true;
            }
        }
        return false;
    }

    public boolean isBeyondBorders(Field field) {
        return getHeadCoordinates()[0] == field.SIZE ||
                getHeadCoordinates()[1] == field.SIZE ||
                getHeadCoordinates()[0] < 0 ||
                getHeadCoordinates()[1] < 0;
    }

    public void updateHeadCoordinates(Snake snake, char direction) {
        int headCol = snake.getHeadCoordinates()[0], headRow = snake.getHeadCoordinates()[1];
        switch (direction) {
            case 'W' -> snake.setHeadCoordinates(new int[]{--headCol, headRow});
            case 'A' -> snake.setHeadCoordinates(new int[]{headCol, --headRow});
            case 'S' -> snake.setHeadCoordinates(new int[]{++headCol, headRow});
            case 'D' -> snake.setHeadCoordinates(new int[]{headCol, ++headRow});
        }
    }

    public void updateBodyCoordinates(Snake snake) {
        for (int current = snake.length - 1; current > 0; current--) {
            snake.setCoordinates(snake.getCoordinates(current - 1), current);
        }
    }
}

package model;

public class SnakesAndLaddersController {

    private Gameboard gameboard;

    public SnakesAndLaddersController() {
        gameboard = new Gameboard();
    }

    public void createGameboard(int rows, int columns) {
        gameboard.setHead(null);
        gameboard.setTail(null);
        createGameboard(rows, columns, 1);
    }

    private void createGameboard(int rows, int columns, int counter) {
        Box newBox = new Box(counter);

        gameboard.addLast(newBox);
        if (counter == rows * columns) {
            return;
        } else {
            createGameboard(rows, columns, ++counter);
        }

    }

    public String printGameboard() {
        return gameboard.print();
    }

}
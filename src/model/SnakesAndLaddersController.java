package model;

public class SnakesAndLaddersController {

    private Gameboard gameboard;
    private Ranking ranking;

    public SnakesAndLaddersController() {
        gameboard = new Gameboard();
        ranking = new Ranking();
    }

    public void createGameboard(int rows, int columns, int snakes, int ladders) {
        gameboard.setHead(null);
        gameboard.setTail(null);
        gameboard.setRows(rows);
        gameboard.setColums(columns);
        gameboard.setLadders(ladders);
        gameboard.setSnakes(snakes);
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

    public String printGameboardInOrder() {
        return gameboard.printInOrderWithValues();
    }

    public String printListo() {
        return gameboard.printGameboard();
    }

    public String printRanking() {
        if (ranking.printInDescendingOrder().equals("[]")) {
            return "El ranking esta vacio";
        } else {
            return ranking.printInDescendingOrder();
        }
    }
}
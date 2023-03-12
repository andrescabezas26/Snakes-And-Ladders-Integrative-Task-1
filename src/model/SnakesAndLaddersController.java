package model;

public class SnakesAndLaddersController {

    private Gameboard gameboard;
    private Ranking ranking;

    public SnakesAndLaddersController() {
        gameboard = new Gameboard();
        ranking = new Ranking();
    }

    public void createGameboard(int rows, int columns, int snakes, int ladders) {
        // Para crear otro tablero, se regeneran nuevamente todos los valores de este
        gameboard.setHead(null);
        gameboard.setTail(null);
        gameboard.setRows(rows);
        gameboard.setColums(columns);
        gameboard.setLadders(ladders);
        gameboard.setSnakes(snakes);
        createGameboard(rows, columns, 1);
        gameboard.searchBox(1).setPlayer1(new Player("*"));
        gameboard.searchBox(1).setPlayer2(new Player("$"));
        gameboard.searchBox(1).setPlayer3(new Player("%"));
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
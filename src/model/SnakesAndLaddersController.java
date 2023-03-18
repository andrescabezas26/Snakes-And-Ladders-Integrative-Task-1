package model;

import java.util.Random;

public class SnakesAndLaddersController {

    private Gameboard gameboard;
    private Ranking ranking;
    private Random r;

    public SnakesAndLaddersController() {
        gameboard = new Gameboard();
        ranking = new Ranking();
        r = new Random();
    }

    public void createGameboard(int rows, int columns, int snakes, int ladders, String symbolPlayer1,
            String symbolPlayer2, String symbolPlayer3) {
        // Para crear otro tablero, se regeneran nuevamente todos los valores de este
        gameboard.setHead(null);
        gameboard.setTail(null);
        gameboard.setRows(rows);
        gameboard.setColums(columns);
        gameboard.setLadders(ladders);
        gameboard.setSnakes(snakes);
        createGameboard(rows, columns, 1);
        gameboard.searchBox(1).setPlayer1(new Player(symbolPlayer1));
        gameboard.searchBox(1).setPlayer2(new Player(symbolPlayer2));
        gameboard.searchBox(1).setPlayer3(new Player(symbolPlayer3));
        gameboard.createLadders();
        gameboard.createSnakes();
    }

    public String playGame(int numDice, int counter, String namePlayer) {
        gameboard.searchBox(counter);
        Player player = gameboard.searchPlayerBox(namePlayer, counter);
        if (counter == 1) {
            gameboard.searchBox(player.getActualBox()).getPlayer1().setName("");
            player.setActualBox(player.getActualBox() + numDice);
            gameboard.searchBox(player.getActualBox()).setPlayer1(player);
            gameboard.searchBox(player.getActualBox()).getPlayer1().setName(namePlayer);

        } else if (counter == 2) {
            gameboard.searchBox(player.getActualBox()).getPlayer1().setName("");
            player.setActualBox(player.getActualBox() + numDice);
            gameboard.searchBox(player.getActualBox()).setPlayer1(player);
            gameboard.searchBox(player.getActualBox()).getPlayer1().setName(namePlayer);
        } else {
            gameboard.searchBox(player.getActualBox()).getPlayer1().setName("");
            player.setActualBox(player.getActualBox() + numDice);
            gameboard.searchBox(player.getActualBox()).setPlayer1(player);
            gameboard.searchBox(player.getActualBox()).getPlayer1().setName(namePlayer);
        }

        return "El jugador " + player.getName() + " ha jugado su turno" + "\n" + printGameboard();

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

    public String printSnakeLadder() {
        return gameboard.printSnakeLadder();
    }

    public int throwDice() {
        int result = r.nextInt(5) + 1;
        return result;

    }
}
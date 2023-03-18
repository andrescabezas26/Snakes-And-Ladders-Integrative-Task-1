/**
 * This class is the controller of the game, it has the gameboard and the ranking, it has the methods
 * to create the gameboard, play the game, print the gameboard, print the ranking, print the snakes and
 * ladders, and throw the dice
 */
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

    /**
     * It creates a gameboard with the given parameters
     * 
     * @param rows          number of rows
     * @param columns       number of columns
     * @param snakes        number of snakes
     * @param ladders       number of ladders
     * @param symbolPlayer1 The symbol that represents the first player.
     * @param symbolPlayer2 The symbol that will be used to represent the second
     *                      player.
     * @param symbolPlayer3 String
     */
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

    /**
     * A method that allows the player to play the game, it receives the number of
     * the dice, the
     * // counter of the player and the name of the player, it returns a string with
     * the message that the
     * // player has played his turn and the gameboard.
     * 
     * @param numDice
     * @param counter
     * @param namePlayer
     * @return
     * @throws CloneNotSupportedException
     */
    public String playGame(int numDice, int counter, String namePlayer) throws CloneNotSupportedException {
        gameboard.searchBox(counter);
        Player copyPlayer = (Player) gameboard.searchPlayerBox(namePlayer, counter).clone();
        int previousBox = copyPlayer.getActualBox();
        int sizeGameboard = gameboard.getColums() * gameboard.getRows();
        if (counter == 1) {
            if (verifyCanWin(copyPlayer)) {
                if (numDice > sizeGameboard - copyPlayer.getActualBox()) {
                    return "The player has to throw the dice with the exact number for win";
                }
            }

            copyPlayer.setActualBox(copyPlayer.getActualBox() + numDice);
            gameboard.searchBox(copyPlayer.getActualBox()).setPlayer1(copyPlayer);
            gameboard.searchBox(previousBox).getPlayer1().setName("");
            previousBox = copyPlayer.getActualBox();
            copyPlayer.setName(namePlayer);

            if (gameboard.searchBox(copyPlayer.getActualBox()).verifyIfIsLadderOrSnake() == 1) {
                if (gameboard.searchBox(copyPlayer.getActualBox()).conditionLadder()) {
                    Player copyPlayerForLadderOrSnake = (Player) copyPlayer.clone();
                    int ladderValue = gameboard.searchBox(copyPlayer.getActualBox()).getSnakeOrLadder().getValue();
                    copyPlayerForLadderOrSnake.setActualBox(ladderValue);
                    gameboard.searchBox(ladderValue).setPlayer1(copyPlayerForLadderOrSnake);
                    gameboard.searchBox(previousBox).getPlayer1().setName("");

                }

            } else if (gameboard.searchBox(copyPlayer.getActualBox()).verifyIfIsLadderOrSnake() == -1) {
                if (gameboard.searchBox(copyPlayer.getActualBox()).conditionSnake()) {
                    Player copyPlayerForLadderOrSnake = (Player) copyPlayer.clone();
                    int ladderValue = gameboard.searchBox(copyPlayer.getActualBox()).getSnakeOrLadder().getValue();
                    copyPlayerForLadderOrSnake.setActualBox(ladderValue);
                    gameboard.searchBox(ladderValue).setPlayer1(copyPlayerForLadderOrSnake);
                    gameboard.searchBox(previousBox).getPlayer1().setName("");

                }
            }

        } else if (counter == 2) {
            if (verifyCanWin(copyPlayer)) {
                if (numDice > sizeGameboard - copyPlayer.getActualBox()) {
                    return "The player has to throw the dice with the exact number for win";
                }
            }

            copyPlayer.setActualBox(copyPlayer.getActualBox() + numDice);
            gameboard.searchBox(copyPlayer.getActualBox()).setPlayer2(copyPlayer);
            gameboard.searchBox(previousBox).getPlayer2().setName("");
            previousBox = copyPlayer.getActualBox();
            copyPlayer.setName(namePlayer);

            if (gameboard.searchBox(copyPlayer.getActualBox()).verifyIfIsLadderOrSnake() == 1) {
                if (gameboard.searchBox(copyPlayer.getActualBox()).conditionLadder()) {
                    Player copyPlayerForLadderOrSnake = (Player) copyPlayer.clone();
                    int ladderValue = gameboard.searchBox(copyPlayer.getActualBox()).getSnakeOrLadder().getValue();
                    copyPlayerForLadderOrSnake.setActualBox(ladderValue);
                    gameboard.searchBox(ladderValue).setPlayer2(copyPlayerForLadderOrSnake);
                    gameboard.searchBox(previousBox).getPlayer2().setName("");

                }

            } else if (gameboard.searchBox(copyPlayer.getActualBox()).verifyIfIsLadderOrSnake() == -1) {
                if (gameboard.searchBox(copyPlayer.getActualBox()).conditionSnake()) {
                    Player copyPlayerForLadderOrSnake = (Player) copyPlayer.clone();
                    int ladderValue = gameboard.searchBox(copyPlayer.getActualBox()).getSnakeOrLadder().getValue();
                    copyPlayerForLadderOrSnake.setActualBox(ladderValue);
                    gameboard.searchBox(ladderValue).setPlayer2(copyPlayerForLadderOrSnake);
                    gameboard.searchBox(previousBox).getPlayer2().setName("");

                }
            }
        } else {
            if (verifyCanWin(copyPlayer)) {
                if (numDice > sizeGameboard - copyPlayer.getActualBox()) {
                    return "The player has to throw the dice with the exact number for win";
                }
            }

            copyPlayer.setActualBox(copyPlayer.getActualBox() + numDice);
            gameboard.searchBox(copyPlayer.getActualBox()).setPlayer3(copyPlayer);
            gameboard.searchBox(previousBox).getPlayer3().setName("");
            previousBox = copyPlayer.getActualBox();
            copyPlayer.setName(namePlayer);

            if (gameboard.searchBox(copyPlayer.getActualBox()).verifyIfIsLadderOrSnake() == 1) {
                if (gameboard.searchBox(copyPlayer.getActualBox()).conditionLadder()) {
                    Player copyPlayerForLadderOrSnake = (Player) copyPlayer.clone();
                    int ladderValue = gameboard.searchBox(copyPlayer.getActualBox()).getSnakeOrLadder().getValue();
                    copyPlayerForLadderOrSnake.setActualBox(ladderValue);
                    gameboard.searchBox(ladderValue).setPlayer3(copyPlayerForLadderOrSnake);
                    gameboard.searchBox(previousBox).getPlayer3().setName("");

                }

            } else if (gameboard.searchBox(copyPlayer.getActualBox()).verifyIfIsLadderOrSnake() == -1) {
                if (gameboard.searchBox(copyPlayer.getActualBox()).conditionSnake()) {
                    Player copyPlayerForLadderOrSnake = (Player) copyPlayer.clone();
                    int ladderValue = gameboard.searchBox(copyPlayer.getActualBox()).getSnakeOrLadder().getValue();
                    copyPlayerForLadderOrSnake.setActualBox(ladderValue);
                    gameboard.searchBox(ladderValue).setPlayer3(copyPlayerForLadderOrSnake);
                    gameboard.searchBox(previousBox).getPlayer3().setName("");

                }
            }
        }

        return "The player " + namePlayer + " has played his turn" + "\n" + printGameboard() + "\n";

    }

    /**
     * Verifying if the player can win with a turn.
     */
    public boolean verifyCanWin(Player player) {
        int sizeGameboard = gameboard.getColums() * gameboard.getRows();
        if (player.getActualBox() >= sizeGameboard - 6) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Verifying if the player has won the game.
     */
    public boolean verifyIsHasWin() {
        if (gameboard.getTail().getPlayer1().getName() != "" || gameboard.getTail().getPlayer2().getName() != ""
                || gameboard.getTail()
                        .getPlayer3().getName() != "") {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return String
     */
    public String messageOfWin() {

        if (gameboard.getTail().getPlayer1().getName() != "") {
            return "The player " + gameboard.getTail().getPlayer1().getName() + " has won the game";
        } else if (gameboard.getTail().getPlayer2().getName() != "") {
            return "The player " + gameboard.getTail().getPlayer2().getName() + " has won the game";
        } else if (gameboard.getTail().getPlayer3().getName() != "") {
            return "The player " + gameboard.getTail().getPlayer3().getName() + " has won the game";
        }

        return "";

    }

    /**
     * //
     * createGameboard(rows, columns, counter) {
     * Box newBox = new Box(counter);
     * 
     * gameboard.addLast(newBox);
     * if (counter == rows * columns) {
     * return;
     * } else {
     * createGameboard(rows, columns, ++counter);
     * }
     * 
     * }
     * 
     * @param rows    number of rows in the gameboard
     * @param columns the number of columns in the gameboard
     * @param counter the number of boxes created so far
     */
    private void createGameboard(int rows, int columns, int counter) {
        Box newBox = new Box(counter);

        gameboard.addLast(newBox);
        if (counter == rows * columns) {
            return;
        } else {
            createGameboard(rows, columns, ++counter);
        }

    }

    /**
     * Trigger of the method prinGameboard
     */
    public String printGameboard() {
        return gameboard.printGameboard();
    }

    /**
     * Trigger of the method printInDescendingOrder
     */
    public String printRanking() {
        if (ranking.printInDescendingOrder().equals("[]")) {
            return "El ranking esta vacio";
        } else {
            return ranking.printInDescendingOrder();
        }
    }

    /**
     * This function prints the snake and ladder positions on the gameboard
     * 
     * @return The printSnakeLadder method is being returned.
     */
    public String printSnakeLadder() {
        return gameboard.printSnakeLadder();
    }

    /**
     * The function throwDice() returns a random number between 1 and 6
     * 
     * @return The result of the random number generator.
     */
    public int throwDice() {
        int result = r.nextInt(5) + 1;
        return result;

    }
}
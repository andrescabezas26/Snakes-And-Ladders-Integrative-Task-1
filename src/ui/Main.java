/**
 * Main: The main class
 */
package ui;

import java.util.Scanner;
import model.SnakesAndLaddersController;

public class Main {

    public Scanner reader;
    public SnakesAndLaddersController controller;

    /**
     * @param args
     * @throws CloneNotSupportedException
     */
    public static void main(String[] args) throws CloneNotSupportedException {

        Main SnakesAndLadders = new Main();
        SnakesAndLadders.hello();
        SnakesAndLadders.mainMenu();
        SnakesAndLadders.bye();
    }

    public Main() {
        reader = new Scanner(System.in);
        controller = new SnakesAndLaddersController();
    }

    /**
     * Description: Print a message of welcome
     */
    public void hello() {
        System.out.println("\nWelcome to VideoGame...");
    }

    /**
     * Description: Print a message of goodbye
     */
    public void bye() {
        System.out.println("\n Exiting of the program... Thanks for use me  ");
    }

    /**
     * Description: Allows select the option of the main menu
     * 
     * @throws CloneNotSupportedException
     */
    public void mainMenu() throws CloneNotSupportedException {

        int optionMenu = 0;
        boolean exit = false;
        do {
            System.out.println(
                    "\n----------\nMain Menu\n---------- Choose a option:\n 0) Exit of program\n 1) Play"
                            + "\n 2) See Rankig"
                            + "\n-------------------");
            optionMenu = validateIntegerOption();

            switch (optionMenu) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    play();
                    break;
                case 2:
                    System.out.println(seeRanking());
                    break;
                default:
                    System.out.println("------------------\nValue incorrect!");
                    break;
            }

        } while (exit == false);
    }

    /**
     * @return
     */
    private String seeRanking() {
        return controller.printRanking();
    }

    /**
     * @throws CloneNotSupportedException
     */
    private void play() throws CloneNotSupportedException {
        System.out.println("Enter the number of rows (horizontally)");
        int rows = validateIntegerOption();
        while (rows == -1 || rows <= 1) {
            reader.next();
            System.out.println(
                    "This section does not accept letters, decimals, negative numbers or the value 1. Write a valid data");
            rows = validateIntegerOption();
        }
        System.out.println("Enter the number of columns (vertically)");
        int columns = validateIntegerOption();
        while (columns == -1 || columns <= 1) {
            reader.next();
            System.out.println(
                    "This section does not accept letters, decimals, negative numbers or the value 1. Write a valid data");
            columns = validateIntegerOption();
        }

        System.out.println("Enter the number of snakes");
        int snakes = validateIntegerOption();
        while (snakes == -1 || snakes < 0) {
            reader.next();
            System.out.println(
                    "This section does not accept letters, decimals, negative numbers. Write a valid data");
            snakes = validateIntegerOption();
        }

        System.out.println("Enter the number of ladders");
        int ladders = validateIntegerOption();
        while (ladders == -1 || ladders < 0) {
            reader.next();
            System.out.println(
                    "This section does not accept letters, decimals, negative numbers. Write a valid data");
            ladders = validateIntegerOption();
        }

        while (ladders + snakes > Math.floor(((rows * columns) - 4) / 2)) {
            System.out
                    .println("The number of ladders and snakes can not be more than "
                            + Math.floor(((rows * columns) - 4) / 2));

            System.out.println("Enter the number of snakes");
            snakes = validateIntegerOption();
            while (snakes == -1 || snakes < 0) {
                reader.next();
                System.out.println(
                        "This section does not accept letters, decimals, negative numbers. Write a valid data");
                snakes = validateIntegerOption();
            }
            System.out.println("Enter the number of ladders");
            ladders = validateIntegerOption();
            while (ladders == -1 || ladders < 0) {
                reader.next();
                System.out.println(
                        "This section does not accept letters, decimals, negative numbers. Write a valid data");
                ladders = validateIntegerOption();
            }
        }

        System.out.println("Choose the symbol of the player 1");
        String symbolPlayer1 = chooseSymbolPlayer();

        System.out.println("Choose the symbol of the player 2");
        String symbolPlayer2 = chooseSymbolPlayer();

        while (symbolPlayer1.equals(symbolPlayer2)) {
            System.out.println("The same symbols cannot be chosen for the players");
            symbolPlayer2 = chooseSymbolPlayer();

        }

        System.out.println("Choose the symbol of the player 3");
        String symbolPlayer3 = chooseSymbolPlayer();

        while (symbolPlayer2.equals(symbolPlayer3) || symbolPlayer1.equals(symbolPlayer3)) {
            System.out.println("The same symbols cannot be chosen for the players");
            symbolPlayer3 = chooseSymbolPlayer();

        }

        controller.createGameboard(rows, columns, snakes, ladders, symbolPlayer1, symbolPlayer2, symbolPlayer3);
        long startTime = System.currentTimeMillis();
        System.out.println("The gameboard is: ");
        System.out.println(controller.printGameboard());
        System.out.println("\n");

        int counter = 1;
        boolean hasWon = false;

        while (counter <= 3 && hasWon == false) {
            if (counter == 1) {
                int numDice = playMenu(symbolPlayer1);
                System.out.println("The player " + symbolPlayer1 + " has rolled " + numDice + " on the dice");
                System.out.println(controller.playGame(numDice, counter, symbolPlayer1));
                counter++;
                hasWon = controller.verifyIsHasWin();

            } else if (counter == 2) {
                int numDice = playMenu(symbolPlayer2);
                System.out.println("The player " + symbolPlayer2 + " has rolled " + numDice + " on the dice");
                System.out.println(controller.playGame(numDice, counter, symbolPlayer2));
                counter++;
                hasWon = controller.verifyIsHasWin();

            } else {
                int numDice = playMenu(symbolPlayer3);
                System.out.println("The player " + symbolPlayer3 + " has rolled " + numDice + " on the dice");
                System.out.println(controller.playGame(numDice, counter, symbolPlayer3));
                counter = 1;
                hasWon = controller.verifyIsHasWin();
            }

        }
        System.out.println(controller.messageOfWin());

        long endTime = System.currentTimeMillis();

        long totalTime = (endTime - startTime) / 1000;
        long scorePlayer = (600 - totalTime) / 6;

        System.out.println("The total time is: " + totalTime + " seconds");
        System.out.println("The score of the player is: " + scorePlayer);
        System.out.println("Writte the name of the winner example: AND");
        String winner = reader.next();
        while (winner.toCharArray().length > 3) {
            System.out.println("Maximum character limit: 3");
            winner = reader.next();
        }
        controller.addScore(winner, totalTime);

    }

    /**
     * validateIntegerOption: This method checks if a number is an integer
     * 
     * @return option - int: Returns the entered number if it is an integer or
     *         returns -1 if it is not an integer
     */
    public int validateIntegerOption() {
        int option = 0;

        if (reader.hasNextInt()) {
            option = reader.nextInt();
        } else {
            reader.nextLine();
            option = -1;
        }

        return option;
    }

    /**
     * A method that allows the user choose the option to play
     */
    private int playMenu(String symbolPlayer) {
        int optionMenuPlayer = 0;
        boolean exit = false;
        int dice = 0;
        do {
            System.out.println(
                    "Player " + symbolPlayer + " is your turn:" +
                            "\nChoose a option: \n 1) Throw dice"
                            + "\n 2) See snakes and ladders"
                            + "\n-------------------");
            optionMenuPlayer = validateIntegerOption();

            switch (optionMenuPlayer) {

                case 1:
                    dice = controller.throwDice();
                    exit = true;
                    break;
                case 2:
                    System.out.println(controller.printSnakeLadder());
                    break;
                default:
                    System.out.println("------------------\nValue incorrect!");
                    break;
            }
        } while (exit == false);

        return dice;
    }

    /**
     * A method that allows the user to choose a symbol for the player.
     */
    private String chooseSymbolPlayer() {
        int optionMenuPlayer = 0;
        boolean exit = false;
        String symbol = "";
        do {
            System.out.println(
                    "Symbols players " +
                            "\nChoose a option: \n 1) *"
                            + "\n 2) !"
                            + "\n 3) O"
                            + "\n 4) X"
                            + "\n 5) %"
                            + "\n 6) $"
                            + "\n 7) #"
                            + "\n 8) +"
                            + "\n 9) &"
                            + "\n-------------------");
            optionMenuPlayer = validateIntegerOption();

            switch (optionMenuPlayer) {

                case 1:
                    symbol = "*";
                    exit = true;
                    break;
                case 2:
                    symbol = "!";
                    exit = true;
                    break;
                case 3:
                    symbol = "O";
                    exit = true;
                    break;
                case 4:
                    symbol = "X";
                    exit = true;
                    break;
                case 5:
                    symbol = "%";
                    exit = true;
                    break;
                case 6:
                    symbol = "$";
                    exit = true;
                    break;
                case 7:
                    symbol = "#";
                    exit = true;
                    break;
                case 8:
                    symbol = "+";
                    exit = true;
                    break;
                case 9:
                    symbol = "&";
                    exit = true;
                    break;

                default:
                    System.out.println("------------------\nValue incorrect!");
                    break;
            }

        } while (exit == false);

        return symbol;

    }

}

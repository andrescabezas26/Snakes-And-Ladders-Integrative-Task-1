package ui;

import java.util.Scanner;
import model.SnakesAndLaddersController;
import java.util.InputMismatchException;

public class Main {

    public Scanner reader;
    public SnakesAndLaddersController controller;

    public static void main(String[] args) {

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
     */
    public void mainMenu() {

        int optionMenu = 0;
        boolean exit = false;
        do {
            try {
                System.out.println(
                        "\n----------\nMain Menu\n---------- Choose a option:\n 0) Exit of program\n 1) Play"
                                + "\n 2) See Rankig"
                                + "\n-------------------");
                optionMenu = reader.nextInt();

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
            } catch (Exception InputMismatchException) {
                System.out.println("Write a valid option!");
                reader.next();
            }

        } while (exit == false);
    }

    private String seeRanking() {
        return controller.printRanking();
    }

    private void play() {
        System.out.println("Enter the number of rows (horizontally)");
        int rows = validateIntegerOption();
        while (rows == -1 || rows <= 0) {
            reader.next();
            System.out.println(
                    "This section does not accept letters, decimals, negative numbers or the value 0. Write a valid data");
            rows = validateIntegerOption();
        }
        System.out.println("Enter the number of columns (vertically)");
        int columns = validateIntegerOption();
        while (columns == -1 || columns <= 0) {
            reader.next();
            System.out.println(
                    "This section does not accept letters, decimals, negative numbers or the value 0. Write a valid data");
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

        // System.out.println(controller.printGameboard());
        // System.out.println(controller.printGameboardInOrder());

        System.out.println(controller.printGameboard());
        long startTime = System.currentTimeMillis();
        reader.nextInt();
        long endTime = System.currentTimeMillis();

        long totalTime = (endTime - startTime) / 1000;

        System.out.println("The total time is: " + totalTime + " seconds");

        System.out.println(controller.printSnakeLadder());

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

    private String chooseSymbolPlayer() {
        int optionMenu = 0;
        boolean exit = false;
        String symbol = "";
        do {
            try {
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
                optionMenu = reader.nextInt();

                switch (optionMenu) {

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
            } catch (Exception InputMismatchException) {
                System.out.println("Write a valid option!");
                reader.next();
            }
        } while (exit == false);

        return symbol;

    }

}

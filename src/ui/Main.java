package ui;

import java.util.Scanner;

import model.SnakesAndLaddersController;

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
        } while (exit == false);
    }

    private String seeRanking() {
        return controller.printRanking();
    }

    private void play() {
        System.out.println("Enter the number of rows (horizontally)");
        int rows = reader.nextInt();
        System.out.println("Enter the number of columns (vertically)");
        int columns = reader.nextInt();

        System.out.println("Enter the number of snakes");
        int snakes = reader.nextInt();
        System.out.println("Enter the number of ladders");
        int ladders = reader.nextInt();

        controller.createGameboard(rows, columns, snakes, ladders);

        // System.out.println(controller.printGameboard());
        // System.out.println(controller.printGameboardInOrder());

        System.out.println(controller.printGameboard());

        System.out.println(controller.printSnakeLadder());

    }
}
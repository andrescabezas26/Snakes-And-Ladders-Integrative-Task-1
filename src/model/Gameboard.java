/**
 * This class is the gameboard, it has the methods to create the gameboard, the snakes and the ladders,
 * it also has the methods to print the gameboard and the snakes and ladders
 */
package model;

import java.util.Random;

public class Gameboard {

    private int rows;
    private int colums;
    private int snakes;
    private int ladders;
    private Box head;
    private Box tail;
    private Random r;

    public Gameboard() {
        r = new Random();
    }

    /**
     * @param node
     */
    public void addLast(Box node) {
        if (this.head == null) {
            this.tail = node;
            this.head = node;
            this.tail.setNext(this.head);
            this.head.setPrevious(this.tail);
        } else {
            this.tail.setNext(node);
            node.setPrevious(this.tail);
            this.tail = node;
            this.tail.setNext(this.head);
            this.head.setPrevious(this.tail);
        }
    }

    /**
     * create the snakes
     */
    public void createSnakes() {
        createSnakes(snakes);
    }

    /**
     * createSnakes: Create snakes for the game
     * 
     * @param snake int = The num of snakes that will be generated
     */
    private void createSnakes(int snake) {
        if (snake == 0) {
            return;
        }
        int numBox1 = r.nextInt(((rows * colums) - 2)) + 2;
        Box box1 = searchBox(numBox1);
        numBox1 = vefiryBoxLaddersAndSnakes(box1, numBox1);
        int numBox2 = vefirySecondRandomBox(numBox1, numBox1);
        searchBox(numBox1).setSnakeOrLadderValue(intToLetter(snake));
        searchBox(numBox1).setSnakeOrLadder(searchBox(numBox2));
        searchBox(numBox2).setSnakeOrLadderValue(intToLetter(snake));
        searchBox(numBox2).setSnakeOrLadder(searchBox(numBox1));
        createSnakes(--snake);
    }

    /**
     * 
     */
    public void createLadders() {
        createLadders(ladders);
    }

    /**
     * createLadders: Create ladders for the game
     * 
     * @param ladder int = The num of ladder that will be generated
     */
    private void createLadders(int ladder) {
        if (ladder == 0) {
            return;
        }
        int numBox1 = r.nextInt(((rows * colums) - 2)) + 2;
        Box box1 = searchBox(numBox1);
        numBox1 = vefiryBoxLaddersAndSnakes(box1, numBox1);
        int numBox2 = vefirySecondRandomBox(numBox1, numBox1);
        searchBox(numBox1).setSnakeOrLadderValue(ladder + "");
        searchBox(numBox1).setSnakeOrLadder(searchBox(numBox2));
        searchBox(numBox2).setSnakeOrLadderValue(ladder + "");
        searchBox(numBox2).setSnakeOrLadder(searchBox(numBox1));
        createLadders(--ladder);
    }

    /**
     * vefiryBoxLaddersAndSnakes: Verify if the snakeOrLadder is empty in the box
     * and return the value of the box, else generate
     * another random and call the method again.
     * 
     * @param box1   : Box = The box that will be verified
     * @param random : int = The num of the box the box that will be verified
     * @return int = The value of the box that is empty
     */
    private int vefiryBoxLaddersAndSnakes(Box box1, int random) {
        if (box1.getSnakeOrLadder() == null) {
            return random;
        }
        random = r.nextInt(((rows * colums) - 2)) + 2;
        box1 = searchBox(random);
        return vefiryBoxLaddersAndSnakes(box1, random);
    }

    /**
     * verifySecondRandomBox: This method verify that the second box generated is
     * empty and his row is different to the box1, finally verify if is empty too
     * then return the value of the box, else generate another value and call the
     * same method
     * 
     * @param random        : int = The value of the ner box that will be verified
     * @param firstBoxValue : int = The value of the first box
     * @return int = The value of the box that is empty
     */
    private int vefirySecondRandomBox(int random, int firstBoxValue) {
        if (getRow(random) != getRow(firstBoxValue) && random != firstBoxValue) {
            Box box = searchBox(random);
            if (vefiryBoxLaddersAndSnakes(box, random) == random) {
                return random;
            } else {
                random = r.nextInt((rows * colums) - 2) + 2;
                return vefirySecondRandomBox(random, firstBoxValue);
            }
        } else {
            random = r.nextInt(((rows * colums) - 2)) + 2;
            return vefirySecondRandomBox(random, firstBoxValue);
        }
    }

    /**
     * getRow: Get the row of the box
     * 
     * @param num : int = The value of the box
     * @return : int = The row of the box
     */
    private int getRow(int num) {
        double num1 = (double) num;
        double columns1 = (double) colums;
        return (int) Math.ceil(num1 / columns1);
    }

    /**
     * intToLetter: Uses the ASCII code to get the value of a num in the alphabet
     * 
     * @param num : The num that will be converted
     * @return String = The letter of the alphabet
     */
    private String intToLetter(int num) {
        char letter = (char) (64 + num);
        return letter + "";
    }

    /**
     * @return
     */
    public String printGameboard() {
        return "\n" + printGameboard(colums, rows, colums * rows, "", "");
    }

    /**
     * @param column
     * @param row
     * @param counter
     * @param tmpMsj
     * @param msj
     * @return
     */
    private String printGameboard(int column, int row, int counter, String tmpMsj, String msj) {
        // Se ejecutara hasta que el counter sea 0
        if (counter == 0) {
            return msj + tmpMsj;
        }
        // Aqui se guardara el numero de la casilla y los jugadores en ella
        String players = counter + searchBox(counter).getPlayer1().getName()
                + searchBox(counter).getPlayer2().getName() + searchBox(counter).getPlayer3().getName();
        // Si es par es de una forma
        if (row % 2 == 0) {

            if (column == 0) {
                return printGameboard(this.colums, --row, counter, tmpMsj, msj + "\n");
            } else {

                msj += "[" + players + "] ";
            }
            // Si es impar es de otra forma
        } else {
            if (column == 0) {
                return printGameboard(this.colums, --row, counter, "", msj + tmpMsj + "\n");
            } else {
                // Para que la primera casilla no quede con un espacio antes del corchete
                if (column == 1) {
                    tmpMsj = "[" + players + "]" + tmpMsj;
                } else {
                    tmpMsj = " [" + players + "]" + tmpMsj;
                }
            }
        }
        return printGameboard(--column, row, --counter, tmpMsj, msj);

    }

    /**
     * @return
     */
    public String printSnakeLadder() {
        return "\n" + printSnakeLadder(colums, rows, colums * rows, "", "");
    }

    /**
     * @param column
     * @param row
     * @param counter
     * @param tmpMsj
     * @param msj
     * @return
     */
    private String printSnakeLadder(int column, int row, int counter, String tmpMsj, String msj) {
        // Se ejecutara hasta que el counter sea 0
        if (counter == 0) {
            return msj + tmpMsj;
        }
        Boolean isEmpty = searchBox(counter).getSnakeOrLadder() == null;
        String SnaAndLad = searchBox(counter).getSnakeOrLadderValue();
        // Si es par es de una forma
        if (row % 2 == 0) {

            if (column == 0) {
                return printSnakeLadder(this.colums, --row, counter, tmpMsj, msj + "\n");
            } else {

                if (Boolean.TRUE.equals(isEmpty)) {
                    msj += "[ ] ";
                } else {

                    msj += "[" + SnaAndLad + "] ";
                }
            }
            // Si es impar es de otra forma
        } else {

            if (column == 0) {
                return printSnakeLadder(this.colums, --row, counter, "", msj + tmpMsj + "\n");
            } else {
                // Para que la primera casilla no quede con un espacio antes del corchete
                if (column == 1) {
                    if (Boolean.TRUE.equals(isEmpty)) {
                        tmpMsj = "[ ]" + tmpMsj;
                    } else {

                        tmpMsj = "[" + SnaAndLad + "]" + tmpMsj;
                    }
                } else {
                    if (Boolean.TRUE.equals(isEmpty)) {
                        tmpMsj = " [ ]" + tmpMsj;
                    } else {

                        tmpMsj = " [" + SnaAndLad + "]" + tmpMsj;
                    }
                }
            }
        }
        return printSnakeLadder(--column, row, --counter, tmpMsj, msj);

    }

    /**
     * @param goal
     * @param current
     * @return
     */
    private Box searchBox(int goal, Box current) {
        // Caso base
        if (current == null) {
            return null;
        }

        // caso borde
        if (goal == head.getValue() && current.equals(this.head)) {
            return this.head;
        }

        if (goal == tail.getValue() && current.equals(this.tail)) {
            return this.tail;
        }
        if (goal == current.getValue()) {
            return current;
        }

        if (current == this.tail && goal != this.tail.getValue()) {
            return null;
        }

        return searchBox(goal, current.getNext());
    }

    /**
     * @param goal
     * @param counter
     * @return
     */
    public Player searchPlayerBox(String goal, int counter) {
        return searchPlayerBox(goal, this.head, counter);
    }

    /**
     * @param goal
     * @param current
     * @param counter
     * @return
     */
    private Player searchPlayerBox(String goal, Box current, int counter) {

        // Caso base
        if (current == null) {
            return null;
        }

        if (counter == 1) {

            if (goal == head.getPlayer1().getName() && current.equals(this.head)) {
                return this.head.getPlayer1();
            }

            if (goal == tail.getPlayer1().getName() && current.equals(this.tail)) {
                return this.tail.getPlayer1();
            }
            if (goal == current.getPlayer1().getName()) {
                return current.getPlayer1();
            }

            if (current == this.tail && goal != this.tail.getPlayer1().getName()) {
                return null;
            }

            return searchPlayerBox(goal, current.getNext(), counter);

        } else if (counter == 2) {
            if (goal == head.getPlayer2().getName() && current.equals(this.head)) {
                return this.head.getPlayer2();
            }

            if (goal == tail.getPlayer2().getName() && current.equals(this.tail)) {
                return this.tail.getPlayer2();
            }
            if (goal == current.getPlayer2().getName()) {
                return current.getPlayer2();
            }

            if (current == this.tail && goal != this.tail.getPlayer2().getName()) {
                return null;
            }

            return searchPlayerBox(goal, current.getNext(), counter);

        } else {
            if (goal == head.getPlayer3().getName() && current.equals(this.head)) {
                return this.head.getPlayer3();
            }

            if (goal == tail.getPlayer3().getName() && current.equals(this.tail)) {
                return this.tail.getPlayer3();
            }
            if (goal == current.getPlayer3().getName()) {
                return current.getPlayer3();
            }

            if (current == this.tail && goal != this.tail.getPlayer3().getName()) {
                return null;
            }

            return searchPlayerBox(goal, current.getNext(), counter);
        }

    }

    /**
     * @param goal
     * @return
     */
    public Box searchBox(int goal) {
        return searchBox(goal, this.head);
    }

    /**
     * @return int return the rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * @param rows the rows to set
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * @return int return the colums
     */
    public int getColums() {
        return colums;
    }

    /**
     * @param colums the colums to set
     */
    public void setColums(int colums) {
        this.colums = colums;
    }

    /**
     * @return int return the snakes
     */
    public int getSnakes() {
        return snakes;
    }

    /**
     * @param snakes the snakes to set
     */
    public void setSnakes(int snakes) {
        this.snakes = snakes;
    }

    /**
     * @return int return the ladders
     */
    public int getLadders() {
        return ladders;
    }

    /**
     * @param ladders the ladders to set
     */
    public void setLadders(int ladders) {
        this.ladders = ladders;
    }

    /**
     * @return Box return the head
     */
    public Box getHead() {
        return head;
    }

    /**
     * @param head the head to set
     */
    public void setHead(Box head) {
        this.head = head;
    }

    /**
     * @return Box return the tail
     */
    public Box getTail() {
        return tail;
    }

    /**
     * @param tail the tail to set
     */
    public void setTail(Box tail) {
        this.tail = tail;
    }

}

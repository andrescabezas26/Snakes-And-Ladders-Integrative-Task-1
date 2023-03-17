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

    public void createSnakes() {
        createSnakes(snakes);
    }

    private void createSnakes(int snake) {
        if (snake == 0) {
            return;
        }

        int numBox1 = r.nextInt(((rows * colums) / 2 - 1)) + 2;
        Box box1 = searchBox(numBox1);
        numBox1 = vefiryLaddersAndSnakes(box1, numBox1, 1);
        int numBox2 = vefirySecondRandomBox(numBox1, numBox1);

        searchBox(numBox1).setSnake(intToLetter(snake));
        searchBox(numBox2).setSnake(intToLetter(snake));
        snake--;
        createSnakes(snake);
    }

    public void createLadders() {
        createLadders(ladders);
    }

    private void createLadders(int ladder) {
        if (ladder == 0) {
            return;
        }
        int numBox1 = r.nextInt(((rows * colums) / 2 - 1)) + 2;
        Box box1 = searchBox(numBox1);
        numBox1 = vefiryLaddersAndSnakes(box1, numBox1, 1);
        int numBox2 = vefirySecondRandomBox(numBox1, numBox1);
        searchBox(numBox1).setLadder(ladder + "");
        searchBox(numBox2).setLadder(ladder + "");
        ladder--;
        createLadders(ladder);
    }

    private int vefiryLaddersAndSnakes(Box box1, int random, int option) {
        if (box1.getLadder().isEmpty() && box1.getSnake().isEmpty()) {
            return random;
        }
        if (option == 1) {
            random = r.nextInt(((rows * colums) / 2 - 1)) + 2;
        }
        random = r.nextInt(((rows * colums) - 2)) + 2;
        box1 = searchBox(random);
        return vefiryLaddersAndSnakes(box1, random, option);
    }

    private int vefirySecondRandomBox(int random, int higher) {
        if (random > higher + colums) {
            Box box = searchBox(random);
            if (vefiryLaddersAndSnakes(box, random, 2) == random) {
                return random;
            } else {
                random = r.nextInt((rows * colums) - 2) + 2;
                return vefirySecondRandomBox(random, higher);
            }
        } else {
            random = r.nextInt(((rows * colums) - 2)) + 2;
            return vefirySecondRandomBox(random, higher);
        }
    }

    private String intToLetter(int num) {
        char letter = (char) (64 + num);
        return letter + "";
    }

    public String printGameboard() {
        return "\n" + printGameboard(colums, rows, colums * rows, "", "");
    }

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

    public String printSnakeLadder() {
        return "\n" + printSnakeLadder(colums, rows, colums * rows, "", "");
    }

    private String printSnakeLadder(int column, int row, int counter, String tmpMsj, String msj) {
        // Se ejecutara hasta que el counter sea 0
        if (counter == 0) {
            return msj + tmpMsj;
        }
        Boolean isEmpty = searchBox(counter).getSnake().isEmpty() && searchBox(counter).getLadder().isEmpty();
        String SnaAndLad = searchBox(counter).getSnake() + searchBox(counter).getLadder();
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

        return searchBox(goal, current.getNext());
    }

    // Trigger
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

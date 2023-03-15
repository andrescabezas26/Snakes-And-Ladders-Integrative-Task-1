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
        if (this.head == null && this.tail == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
    }

    public void createSnakes() {

    }

    private void createSnakes(int snake, Box current) {
        if (snake == 0) {
            return;
        }

        int box1 = r.nextInt(((rows*colums)-2))+2;
        if (searchBox(box1) != null) {
            if (searchBox(box1).getLadder().equals("") && searchBox(box1).getSnake().equals("")) {
                
            }
        }
    }

    public String printGameboard() {
        return "\n" + printGameboard(colums, rows, colums * rows, "", "");
    }

    private String printGameboard(int column, int row, int counter, String tmpMsj, String msj) {
        // Se ejecutara hasta que el counter sea 0
        if (counter == 0) {
            return msj + tmpMsj;
        }
        // Si es par es de una forma
        if (row % 2 == 0) {

            if (column == 0) {
                return printGameboard(this.colums, --row, counter, tmpMsj, msj + "\n");
            } else {

                msj += "[" + counter + searchBox(counter).getPlayer1().getName()
                        + searchBox(counter).getPlayer2().getName() + searchBox(counter).getPlayer3().getName()
                        + "] ";

            }
            // Si es impar es de otra forma
        } else {

            if (column == 0) {
                return printGameboard(this.colums, --row, counter, "", msj + tmpMsj + "\n");
            } else {
                // Para que la primera casilla no quede con un espacio antes del corchete
                if (column == 1) {
                    tmpMsj = "[" + counter + searchBox(counter).getPlayer1().getName()
                            + searchBox(counter).getPlayer2().getName() + searchBox(counter).getPlayer3().getName()
                            + "]" + tmpMsj;
                } else {
                    tmpMsj = " [" + counter + searchBox(counter).getPlayer1().getName()
                            + searchBox(counter).getPlayer2().getName() + searchBox(counter).getPlayer3().getName()
                            + "]" + tmpMsj;
                }

            }
        }
        return printGameboard(--column, row, --counter, tmpMsj, msj);

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

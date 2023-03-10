package model;

public class Gameboard {

    private int rows;
    private int colums;
    private int snakes;
    private int ladders;
    private Box head;
    private Box tail;

    public Gameboard() {
    }

    public Box getHead() {
        return head;
    }

    public void setHead(Box head) {
        this.head = head;
    }

    public Box getTail() {
        return tail;
    }

    public void setTail(Box tail) {
        this.tail = tail;
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

    public String print() {
        return print(this.head, "");
    }

    private String print(Box current, String msj) {
        if (this.head == null && this.tail == null) {
            return "La lista esta vacia";
        } else if (current == this.tail) {
            return msj += " " + current.getValue();
        }
        msj += " " + current.getValue();
        return print(current.getNext(), msj);
    }

    public String printGameboard() {
        return printGameboard(rows, colums, colums * rows, "");
    }

    private String printGameboard(int row, int column, int counter, String msj) {
        if (counter == 0) {
            return msj;
        }

        msj += counter + " ";
        return printGameboard(row, column, --counter, msj);

    }

    private String printInOrderWithValues(Box currentStart, Box end, String msj) {

        if (currentStart == null && end == null) {
            return "No se encontraron los nodos, por favor verifique";
        }

        if (currentStart.getValue() == end.getValue()) {
            return msj += " " + currentStart.getValue();

        }

        msj += " " + currentStart.getValue();
        return print(currentStart.getNext(), msj);
    }

    public String printInOrderWithValues() {
        return printInOrderWithValues(searchBox(10), searchBox(15), "");
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

}

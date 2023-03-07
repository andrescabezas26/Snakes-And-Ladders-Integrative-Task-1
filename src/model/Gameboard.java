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

}

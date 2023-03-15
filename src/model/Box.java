package model;

public class Box {

    private int value;
    private Box next;
    private Box previous;
    private String snake;
    private String ladder;
    private Player player1;
    private Player player2;
    private Player player3;

    public Box(int value) {
        this.value = value;
        this.next = null;
        this.snake = "";
        this.ladder = "";
        this.player1 = new Player("");
        this.player2 = new Player("");
        this.player3 = new Player("");
    }

    public Box getNext() {
        return next;
    }

    public void setNext(Box next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * @return Player return the player1
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * @param player1 the player1 to set
     */
    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    /**
     * @return Player return the player2
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * @param player2 the player2 to set
     */
    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    /**
     * @return Player return the player3
     */
    public Player getPlayer3() {
        return player3;
    }

    /**
     * @param player3 the player3 to set
     */
    public void setPlayer3(Player player3) {
        this.player3 = player3;
    }

    /**
     * @return String return the snake
     */
    public String getSnake() {
        return snake;
    }

    /**
     * @param snake the snake to set
     */
    public void setSnake(String snake) {
        this.snake = snake;
    }

    /**
     * @return String return the ladder
     */
    public String getLadder() {
        return ladder;
    }

    /**
     * @param ladder the ladder to set
     */
    public void setLadder(String ladder) {
        this.ladder = ladder;
    }


    /**
     * @return Box return the previous
     */
    public Box getPrevious() {
        return previous;
    }

    /**
     * @param previous the previous to set
     */
    public void setPrevious(Box previous) {
        this.previous = previous;
    }

}

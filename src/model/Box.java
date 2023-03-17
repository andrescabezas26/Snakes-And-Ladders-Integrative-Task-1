package model;

public class Box {

    private int value;
    private Box next;
    private Box previous;
    private Box snakeOrLadder;
    private String snakeOrLadderValue;
    private Player player1;
    private Player player2;
    private Player player3;

    public Box(int value) {
        this.value = value;
        this.next = null;
        this.previous = null;
        this.snakeOrLadderValue="";
        this.player1 = new Player("");
        this.player2 = new Player("");
        this.player3 = new Player("");
    }

    private int verifyIfisLadderOrSnake(){
        char[] value=snakeOrLadderValue.toCharArray();
        if(Character.isDigit(value[0])){
            return 1;
        }
        return -1;
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

    /**
     * @return Box return the snakeOrLadder
     */
    public Box getSnakeOrLadder() {
        return snakeOrLadder;
    }

    /**
     * @param snakeOrLadder the snakeOrLadder to set
     */
    public void setSnakeOrLadder(Box snakeOrLadder) {
        this.snakeOrLadder = snakeOrLadder;
    }

    /**
     * @return String return the snakeOrLadderValue
     */
    public String getSnakeOrLadderValue() {
        return snakeOrLadderValue;
    }

    /**
     * @param snakeOrLadderValue the snakeOrLadderValue to set
     */
    public void setSnakeOrLadderValue(String snakeOrLadderValue) {
        this.snakeOrLadderValue = snakeOrLadderValue;
    }

}

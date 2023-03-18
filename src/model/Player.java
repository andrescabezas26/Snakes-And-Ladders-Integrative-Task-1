/**
 * This class is a model of a player in the game
 */
package model;

public class Player implements Cloneable {

    private String name;
    private long score;
    private Player next;
    private int actualBox;

    public Player(String name) {
        this.name = name;
        this.actualBox = 1;
    }

    @Override
    // A method that allows the object to be cloned.
    public Object clone() throws CloneNotSupportedException {
        return (Player) super.clone();
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public long getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(long score) {
        this.score = score;
    }

    /**
     * @return
     */
    public Player getNext() {
        return next;
    }

    /**
     * @param next
     */
    public void setNext(Player next) {
        this.next = next;
    }

    /**
     * @return int return the actualBox
     */
    public int getActualBox() {
        return actualBox;
    }

    /**
     * @param actualBox the actualBox to set
     */
    public void setActualBox(int actualBox) {
        this.actualBox = actualBox;
    }

}
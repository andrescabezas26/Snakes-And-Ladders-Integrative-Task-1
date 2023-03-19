/**
 * Score is a class that represents a score of a player in a game.
 */
package model;

public class Score {

    private String namePlayer;
    private long value;
    private Score right;
    private Score left;
    
    public Score(String namePlayer, long value) {
        this.namePlayer = namePlayer;
        this.value = value;
    }
    
    /**
     * @return String return the namePlayer
     */
    public String getNamePlayer() {
        return namePlayer;
    }

    /**
     * @param namePlayer the namePlayer to set
     */
    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    /**
     * @return long return the value
     */
    public long getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(long value) {
        this.value = value;
    }


    /**
     * @return Score return the right
     */
    public Score getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(Score right) {
        this.right = right;
    }

    /**
     * @return Score return the left
     */
    public Score getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(Score left) {
        this.left = left;
    }
    @Override
    public String toString(){
        return namePlayer+"\t" + value;
    }

}

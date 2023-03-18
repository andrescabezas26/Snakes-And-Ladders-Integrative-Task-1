package model; 


public class Player {
    
    private String name;
    private long score;
    private Player next;
    private int actualBox;
    
    
    public Player(String name) {
        this.name = name;
        this.actualBox = 1;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getScore() {
        return score;
    }
    public void setScore(long score) {
        this.score = score;
    }
    public Player getNext() {
        return next;
    }
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
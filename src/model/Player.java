package model; 


public class Player {
    
    private String name;
    private long score;
    private Player next;
    
    public Player(String name) {
        this.name = name;
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
}
package model; 


public class Player {
    
    private String name;
    private long score;
    private Player right;
    private Player left;
    
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
    public Player getRight() {
        return right;
    }
    public void setRight(Player right) {
        this.right = right;
    }
    public Player getLeft() {
        return left;
    }
    public void setLeft(Player left) {
        this.left = left;
    }
}
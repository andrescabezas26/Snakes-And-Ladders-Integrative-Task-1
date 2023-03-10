package model;

public class Score {
    private String namePlayer;
    private Player player;
    private Score right;
    private Score left;
    private long score;

    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public Score getRight() {
        return right;
    }
    public void setRight(Score right) {
        this.right = right;
    }
    public Score getLeft() {
        return left;
    }
    public void setLeft(Score left) {
        this.left = left;
    }
    public String getNamePlayer() {
        return namePlayer;
    }
    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }
    public long getScore() {
        return score;
    }
    public void setScore(long score) {
        this.score = score;
    }
    
}

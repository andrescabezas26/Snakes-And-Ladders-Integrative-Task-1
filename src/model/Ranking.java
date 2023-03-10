package model;

public class Ranking {

    private Player root;

    public void insertScore(Player score){
        if(root==null){
            root=score;
        }else{
            insertScore(score, root);
        }
    }

    private void insertScore(Player score, Player current){
		
		if(score.getScore() < current.getScore()){
			if(current.getLeft() == null){
				current.setLeft(score); 
			}
			else{
				insertScore(score, current.getLeft()); 
			}
		}
		
		else if(score.getScore() > current.getScore()){
			if(current.getRight() == null){
				current.setRight(score); 
			}
			else{
				insertScore(score, current.getRight()); 
			}
		}
		else{
			
		}
	}

    public String printInDescendingOrder(){
		return "[" + printInDescendingOrder(root) + "]"; 
	}

	private String printInDescendingOrder(Player current){
		if(current == null){
			return ""; 
		}

		return printInDescendingOrder(current.getLeft()) + " " + current.getScore() + " " + printInDescendingOrder(current.getRight()); 
	}
}

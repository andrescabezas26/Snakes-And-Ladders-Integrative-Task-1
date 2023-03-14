package model;

public class Ranking {

    private Score root;

    public void insertScore(Score score){
        if(root==null){
            root=score;
        }else{
            insertScore(score, root);
        }
    }

    private void insertScore(Score score, Score current){
		
		if(score.getValue() < current.getValue()){
			if(current.getLeft() == null){
				current.setLeft(score); 
			}
			else{
				insertScore(score, current.getLeft()); 
			}
		}
		
		else if(score.getValue() > current.getValue()){
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

	private String printInDescendingOrder(Score current){
		if(current == null){
			return ""; 
		}

		return printInDescendingOrder(current.getLeft()) + " " + current.getValue() + " " + printInDescendingOrder(current.getRight()); 
	}
}

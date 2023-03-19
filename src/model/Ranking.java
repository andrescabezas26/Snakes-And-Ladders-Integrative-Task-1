/**
 * The class Ranking is a binary search tree that stores Score objects.
 */
package model;

public class Ranking {

    private Score root;

    /**
     * @param score
     */
    public void insertScore(Score score){
        if(root==null){
            root=score;
        }else{
            insertScore(score, root);
        }
    }

    /**
     * @param score
     * @param current
     */
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

    /**
     * @return
     */
    public String printInDescendingOrder(){
		return printInDescendingOrder(root); 
	}

	
	/**
	 * @param current
	 * @return
	 */
	private String printInDescendingOrder(Score current){
		if(current == null){
			return ""; 
		}

		return printInDescendingOrder(current.getRight()) + "" + current.toString() + "\n" + printInDescendingOrder(current.getLeft()); 
	}
}

/**
 * @author Guoguo Lu <guoguol>
 * @section AAA
 */

// YOU MAY NOT IMPORT ANY ADDITIONAL
// CLASSES OR PACKAGES
import java.util.*;

public class BinaryTrees {
	
	public static boolean allDecreasing(TreeNode<Integer> t){
		if (t == null) throw new NullPointerException();
		if (t.left != null && t.right != null) {
			if (t.data.compareTo(t.left.data) > 0
					&& t.data.compareTo(t.right.data) > 0)
				return allDecreasing(t.left) && allDecreasing(t.right);
			else return false;
		}
		else if (t.left != null && t.right == null) {
			if (t.data.compareTo(t.left.data) > 0)
				return allDecreasing(t.left);
			else return false;
		}
		else if (t.left == null && t.right != null) {
			if (t.data.compareTo(t.right.data) > 0)
				return allDecreasing(t.right);
			else return false;
		}
		else if (t.left == null && t.right == null) {
			return true;
		}
		return false;
	}
	
	public static int countLeavesAtLevel(TreeNode<Integer> t, int level){
		if (t == null) throw new NullPointerException();
		if (level > 0) {
			if (t.left == null && t.right == null) return 0;
			if (t.left != null && t.right == null) return countLeavesAtLevel(t.left, level-1);
			if (t.left == null && t.right != null) return countLeavesAtLevel(t.right, level-1);
			if (t.left != null && t.right != null) 
			return countLeavesAtLevel(t.left, level-1) + 
					countLeavesAtLevel(t.right, level-1);
		}
		if (t.left == null && t.right == null) return 1;
		return countLeavesAtLevel(t.left, 0) + 
				countLeavesAtLevel(t.right, 0); // remove this line when you are done with this method
	}

	public static List<Integer> interiorNodesList(TreeNode<Integer> t){
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (t.left != null && t.right != null) {
			list.add(t.data);
			list.addAll(interiorNodesList(t.left));
			list.addAll(interiorNodesList(t.right));
		}
		if (t.left != null && t.right == null) {
			list.addAll(interiorNodesList(t.left));
		}
		if (t.left == null && t.right != null) {
			list.addAll(interiorNodesList(t.right));
		}
	    return list;
	}	

	public static boolean isPerfect(TreeNode<Integer> t){
	    int numOfLevels = numOfLevels(t);
	    int sum = 1;
		for (int i = 0; i < numOfLevels; i++) {
			sum *= 2;
		}
		if (sum-1 == numOfNodes(t)) return true;
		return false;
	}
	
	public static int numOfLevels(TreeNode<Integer> t) {
		if (t == null) return 0;
		if (t.left != null && t.right == null) {
			return 1 + numOfLevels(t.left);
		}
		if (t.left == null && t.right != null) {
			return 1 + numOfLevels(t.right);
		}
		if (t.left != null && t.right != null) {
			return 1 + Math.max(numOfLevels(t.left), numOfLevels(t.right));
		}
		else {
			return 1;
		}
	}
	
	public static int numOfNodes(TreeNode<Integer> t) {
		if (t == null) throw new NullPointerException();
		if (t.left == null && t.right == null) return 1;
		return	1+((t.left != null)? numOfNodes(t.left):0) 
				+ ((t.right != null)? numOfNodes(t.right):0);
	}
	
	public static boolean isSubset(TreeNode<String> t1, TreeNode<String> t2){
	    if (t1 == null || t2 == null) throw new NullPointerException();
	    if (t1.data.equals(t2.data)) {
	    	if(checkSubset(t1, t2)) return true;
	    }
	    if (t1.left != null && t1.right != null) {
	    	return isSubset(t1.left, t2) || isSubset(t1.right, t2);
	    }
	    else if (t1.left != null && t1.right == null) {
	    	return isSubset(t1.left, t2);
	    }
	    else if (t1.left == null && t1.right != null) {
	    	return isSubset(t1.right, t2);
	    }
	    
	    return false;
	}

	private static boolean checkSubset(TreeNode<String> t1, TreeNode<String> t2) {
		
    	System.out.println("Found matched node: "+t1.data);
    	if (t1.left != null && t2.left != null
    			&& t1.right != null && t2.right != null) {
    		return isSubset(t1.left, t2.left) && isSubset(t1.right, t2.right);
    	}
    	else if (t1.left != null && t2.left != null && t2.right == null) {
    		return isSubset(t1.left, t2.left);
    	}
    	else if (t2.left == null && t1.right != null && t2.right != null) {
    		return isSubset(t1.right, t2.right);
    	}
    	else if (t2.left == null && t2.right == null) {
    		System.out.println("returned true");
    		return true;
    	}
    	else return false;
	}

	public static TreeNode<String> insertAfter(TreeNode<String> t, String target, String newString){
	    return null; // remove this line when you are done with this method
	}	

	public static boolean areEqual(TreeNode<String> t1, TreeNode<String> t2){
	    return false; // remove this line when you are done with this method
	}

	public static TreeNode<String> createTree(int n, String s){
	    return null; // remove this line when you are done with this method
	}	

	public static TreeNode<Integer> mirror(TreeNode<Integer> t){
	    return null; // remove this line when you are done with this method
	}
}
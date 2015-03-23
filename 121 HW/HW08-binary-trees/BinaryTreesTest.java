
public class BinaryTreesTest {

	public static TreeNode<Integer> buildDecreaseTree(TreeNode<Integer> node, boolean oddLevel) {
		if (node.data > 4) {
			if (oddLevel) {
				node.left = new TreeNode<Integer>(node.data-1);
				node.right = new TreeNode<Integer>(node.data-2);
			}
			else {
				node.right = new TreeNode<Integer>(node.data-4);
				node.left = new TreeNode<Integer>(node.data-2);
			}
			buildDecreaseTree(node.left, !oddLevel);
			buildDecreaseTree(node.right, !oddLevel);
		}
		return node;
	}
	
	public static TreeNode<Integer> buildMirroredTree(TreeNode<Integer> rootNode) {

		rootNode.right = new TreeNode<Integer>(4);
		rootNode.left = new TreeNode<Integer>(4);
		
		rootNode.left.left = new TreeNode<Integer>(6);
		rootNode.right.right = new TreeNode<Integer>(6);
		
		rootNode.left.right = new TreeNode<Integer>(3);
		rootNode.right.left = new TreeNode<Integer>(3);
		
		rootNode.left.left.left = new TreeNode<Integer>(5);
		rootNode.right.right.right = new TreeNode<Integer>(5);
		
		rootNode.left.left.right = new TreeNode<Integer>(2);
		rootNode.right.right.left = new TreeNode<Integer>(2);
		
		rootNode.left.right.left = new TreeNode<Integer>(5);
		rootNode.right.left.right = new TreeNode<Integer>(5);
		
		rootNode.left.right.right = new TreeNode<Integer>(5);
		rootNode.right.left.left = new TreeNode<Integer>(5);
		
		return rootNode;
	}
	
	public static TreeNode<String> buildAnotherTree(TreeNode<String> rootNode) {

		rootNode.right = new TreeNode<String>("4");
		rootNode.left = new TreeNode<String>("4");
		
		rootNode.left.left = new TreeNode<String>("6");
		rootNode.right.right = new TreeNode<String>("6");
		
		rootNode.left.right = new TreeNode<String>("3");
		rootNode.right.left = new TreeNode<String>("3");
		
		rootNode.left.left.left = new TreeNode<String>("5");
		rootNode.right.right.right = new TreeNode<String>("5");
		
		rootNode.left.right.right = new TreeNode<String>("5");
		rootNode.right.left.left = new TreeNode<String>("5");
		
		return rootNode;
	}
	
	public static TreeNode<String> buildAnotherAnotherTree(TreeNode<String> rootNode) {

		//rootNode.right = new TreeNode<String>("3");
		rootNode.left = new TreeNode<String>("1");
		
		//rootNode.left.left = new TreeNode<String>("6");
		//rootNode.right.right = new TreeNode<String>("6");
		
		//rootNode.left.right = new TreeNode<String>("3");
		//rootNode.right.left = new TreeNode<String>("3");
		
		return rootNode;
	}
	
	public static void main(String[] args) {
		TreeDisplay<String> screen = new TreeDisplay<String>();
		
		TreeNode<Integer> tree1 = new TreeNode<Integer>(10);
		buildDecreaseTree(tree1, true);
		
		TreeNode<Integer> tree2 = new TreeNode<Integer>(10);
		buildMirroredTree(tree2);
		
		TreeNode<String> tree3 = new TreeNode<String>("10");
		buildAnotherTree(tree3);
		
		TreeNode<String> tree4 = new TreeNode<String>("4");
		buildAnotherAnotherTree(tree4);
		
		//screen.setRoot(tree1);
		//screen.setRoot(tree2);
		screen.setRoot(tree4);
		
		System.out.println("Tree3 is subtree of tree2?"+BinaryTrees.isSubset(tree3, tree4));
		//System.out.println("Tree 1 all decreasing:"+BinaryTrees.allDecreasing(tree1));
		//System.out.println("Tree 2 all decreasing:"+BinaryTrees.allDecreasing(tree2));
		//System.out.println("Tree 1 is perfect:"+BinaryTrees.isPerfect(tree1));
		//System.out.println("Tree 1 number of nodes:"+BinaryTrees.numOfNodes(tree1));
		//System.out.println("Tree 1 number of levels:"+BinaryTrees.numOfLevels(tree1));
		//System.out.println("Tree 1 leaves number at root:"+BinaryTrees.countLeavesAtLevel(tree1, 0));
		//System.out.println("Tree 1 leaves number at level 3: "+BinaryTrees.countLeavesAtLevel(tree1, 3));
		//for (int i: BinaryTrees.interiorNodesList(tree1)) {
		//	System.out.println(i);
		//}
	}

}

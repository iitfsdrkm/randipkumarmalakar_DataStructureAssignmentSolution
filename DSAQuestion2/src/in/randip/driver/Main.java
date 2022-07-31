package in.randip.driver;

import in.randip.service.BSTtoRightSkewedTree;

public class Main {

	public static void main(String[] args) {
		int order;

		BSTtoRightSkewedTree tree = new BSTtoRightSkewedTree();

		/* To hard code values uncomment below lines and comment the tree.insert(N) statement below 
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left = new Node(55);
		 */

		// Insert data to the tree
		tree.insert(50);
		tree.insert(30);
		tree.insert(60);		
		tree.insert(10);
		tree.insert(55);

		System.out.println("Level order traversal of the Binary Search Tree before skew operation ");
		tree.levelOrder(tree.root); 
		System.out.println("\n");

		// Below code for debug purpose
		/*
		System.out.println("Level order traversal");
		tree.levelOrder(tree.root);  
		System.out.println("");
		System.out.println("In order traversal");
		tree.inorderTraversal(tree.root);
		System.out.println("\nROOT data=>" + tree.root.data);
		System.out.println("");
		System.out.println(tree.root.data);
		 */


		// set order to 0 (zero) for ascending order of skewed tree
		// set order to 1 (one) for descending order of skewed tree
		order=0;
		tree.convertBSTToSkewed(tree.root,order);

		// Below commented code for debug purpose
		//System.out.println("============ Skewed operation done =============");
		//System.out.println("\nROOT Node data=>" + tree.root.data);
		//System.out.println("\nHEAD Node data=>" + tree.headNode.data);


		System.out.println("Output (Right Skewed traversal after skew operation)");
		tree.traverseRightSkewed(tree.headNode); //tree.headNode is representing the top of the skewed tree
		System.out.println("\n");

		/* For debug purpose - Level order traversal of the skewed tree
		System.out.println("Output (Level order traversal of the Skewed tree)");
		tree.levelOrder(tree.headNode);  //tree.headNode is representing the top of the skewed tree
		System.out.println();
		 */

	}

}

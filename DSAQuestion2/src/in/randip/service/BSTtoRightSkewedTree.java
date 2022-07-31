package in.randip.service;

import java.util.LinkedList;
import java.util.Queue;

public class BSTtoRightSkewedTree {

	//Represent a node of binary tree  
	public static class Node{  
		public int data;  
		Node left;  
		Node right;  

		public Node(int data){  
			//Assign data to the new node, set left and right children to null  
			this.data = data;  
			this.left = null;  
			this.right = null;  
		}  
	}  

	//Represent the root of binary tree  
	public static Node root; 
	static Node prevNode = null;
	public Node headNode = null;

	public BSTtoRightSkewedTree(){  
		root = null;

	}  

	//insert() will add new node to the binary search tree  
	public void insert(int data) {  
		//Create a new node  
		Node newNode = new Node(data);  

		//Check whether tree is empty  
		if(root == null){  
			root = newNode;  
			return;  
		}  
		else {  
			//current node point to root of the tree  
			Node current = root, parent = null;  

			while(true) {  
				//parent keep track of the parent node of current node.  
				parent = current;  

				//If data is less than current's data, node will be inserted to the left of tree  
				if(data < current.data) {  
					current = current.left;  
					if(current == null) {  
						parent.left = newNode;  
						return;  
					}  
				}  
				//If data is greater than current's data, node will be inserted to the right of tree  
				else {  
					current = current.right;  
					if(current == null) {  
						parent.right = newNode;  
						return;  
					}  
				}  
			}  
		}  
	}  



	// Inorder traversal on binary search tree  
	public void inorderTraversal(Node node) {  

		//Check whether tree is empty  
		if(root == null){  
			System.out.println("Tree is empty");  
			return;  
		}  
		else {  

			if(node.left!= null)  
				inorderTraversal(node.left);  
			System.out.print(node.data + " ");  
			if(node.right!= null)  
				inorderTraversal(node.right);  

		}  
	}

	public void levelOrder(Node root) {
		Queue<Node> queue1 = new LinkedList<Node>();
		queue1.add(root);
		while (!queue1.isEmpty()) {
			Node tempNode = queue1.poll();
			System.out.print(tempNode.data + " ");
			// enqueue left node
			if (tempNode.left != null) {
				queue1.add(tempNode.left);
			}
			// enqueue right node
			if (tempNode.right != null) {
				queue1.add(tempNode.right);
			}
		}
	}

	// Direct traversal of the right skewed tree using node.right pointer	
	public void traverseRightSkewed(Node root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		traverseRightSkewed(root.right);	
	}


	//static void convertBSTToSkewed(Node root, int order) {
	public void convertBSTToSkewed(Node root, int order) {

		// Base Case
		if(root == null) {
			return;
		}

		// Check the order in which the skewed tree to converted
		if(order > 0) {
			convertBSTToSkewed(root.right, order);
		}
		else {
			convertBSTToSkewed(root.left, order);
		}
		Node rightNode = root.right;
		Node leftNode = root.left;

		// if the root Node of the skewed tree is not defined
		if(headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		}
		else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		// recurse for the left / right subtree based on order
		if (order > 0) {
			convertBSTToSkewed(leftNode, order);
		}
		else {
			convertBSTToSkewed(rightNode, order);
		}
	}




}







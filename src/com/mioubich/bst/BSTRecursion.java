package com.mioubich.bst;

public class BSTRecursion {

	Node root;
	
	class Node{
		int value;
		Node left;
		Node right;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	private void printInOrder(Node node) {
		if(node != null) {
			printInOrder(node.left);
			System.out.println(node.value);
			printInOrder(node.right);
		}
	}
	
	public void printInOrder() {
		printInOrder(root);
	} 
	
	private Node insert(Node currentNode, int value) {
		if(currentNode == null) {
			return new Node(value);
		}
		
		if(value < currentNode.value) {
			currentNode.left = insert(currentNode.left, value);
		}
		else {
			currentNode.right = insert(currentNode.right, value);
		}
		return currentNode;
	}
	
	public void insert(int value) {
		if(root == null)
			root = new Node(value);
		insert(root, value);
	}
	
	private boolean contains(Node currentNode, int value){
		if(currentNode == null)
			return false;
		if(currentNode.value == value)
			return true;
		
		if(value < currentNode.value)
			return contains(currentNode.left, value);
		else
			return contains(currentNode.right, value);
	}
	
	public boolean contains(int value) {
		return contains(root, value);
	}
	
	private int min(Node currentNode) {
		 if(currentNode.left == null)
			 return currentNode.value;
		 return min(currentNode.left);
	}
	
	public int min() {
		return min(root);
	}
	
	private int max(Node currentNode) {
		 if(currentNode.right == null)
			 return currentNode.value;
		 return min(currentNode.right);
	}
	
	public int max() {
		return max(root);
	}
}

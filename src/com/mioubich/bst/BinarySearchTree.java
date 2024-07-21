package com.mioubich.bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTree {

	Node root;
	
	class Node{
		Integer value;
		Node left;
		Node right;
		
		public Node(Integer value) {
			this.value = value;
		}
	}
	
	private void preOrderPrint(Node node) {
		if(node != null) {
			System.out.println(node.value);
			printInOrder(node.left);
			printInOrder(node.right);
		}
	}
	
	public void preOrderPrint() {
		preOrderPrint(root);
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
	
	private void printPostOrder(Node node){
		if(node != null) {
			printInOrder(node.left);
			printInOrder(node.right);
			System.out.println(" " + node.value);
		}
	}
	
	public void printPostOrder() {
		printPostOrder(root);
	}
	
	public boolean insert(Integer value) {
		Node newNode = new Node(value);
		
		if( root == null) {
			root = newNode;
			return true;
		}
		Node temp = root;
		
		while(true) {
			if(temp.value == value)
				return false;
			if(value > temp.value) {
				if(temp.right == null) {
					temp.right = newNode;
					return true;
				}
				temp = temp.right;
			}
			else {
				if(temp.left == null) {
					temp.left = newNode;
					return true;
				}
				temp = temp.left;
			}
		}
	}
	
	public boolean contains(Integer value) {
		Node temp = root;
		
		while(temp != null) {
			if(value < temp.value)
				temp = temp.left;
			else if(value > temp.value)
				temp = temp.right;
			else
				return true;
		}
		return false;
	}
	
	public boolean isBstValid() {
		List<Integer> inOrderList = new ArrayList<>();
		//populate the inOrderList
		helper(root, inOrderList);
		
		Integer prevValue = inOrderList.get(0);
		for(int i=1; i<inOrderList.size(); i++) {
			if(prevValue >= inOrderList.get(i)) 
				return false;
			prevValue = inOrderList.get(i);
		}
		return true;
	}
	
	private void helper(Node node, List<Integer> list) {
		if(node != null) {
			helper(node.left, list);
			list.add(node.value);
			helper(node.right, list);
		}
	}
}

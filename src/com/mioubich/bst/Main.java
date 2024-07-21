package com.mioubich.bst;

public class Main {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(9);
		bst.insert(11);
		bst.insert(7);
		bst.insert(1);
		bst.insert(13);

//		bst.printPostOrder();

		// ---------- BSTRecursion -----------//
		BSTRecursion bstr = new BSTRecursion();
		bstr.insert(21);
		bstr.insert(17);
		bstr.insert(30);
		bstr.insert(5);
		bstr.insert(19);
		bstr.insert(25);
		bstr.insert(10);
		
		bstr.printInOrder();
		
		System.out.println("BST contains number 21: " + bstr.contains(21));
		System.out.println("Min value: " + bstr.min());
		
		System.out.println("Is it valide BST? -> " + bst.isBstValid());

	}

}

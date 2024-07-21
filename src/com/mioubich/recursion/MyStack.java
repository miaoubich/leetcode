package com.mioubich.recursion;

import java.util.Stack;

public class MyStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		myStack(stack);
	}

	public static void myStack(Stack<Integer> stack) {
		if(stack.isEmpty())
			return;
		System.out.println(stack.pop());
		myStack(stack);
	}
}

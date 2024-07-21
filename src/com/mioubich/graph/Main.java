package com.mioubich.graph;

public class Main {

	public static void main(String[] args) {
		Graph graph = new Graph();
		
		graph.createVertex("A");
		graph.createVertex("B");
		graph.createEdge("A", "B");
		graph.createVertex("C");
		graph.createEdge("A", "C");
		graph.print();
		
		graph.createVertex("D");
		graph.createEdge("D", "A");
		graph.createEdge("D", "B");
		graph.createEdge("D", "C");
		graph.print();
		
//		graph.removeEdge("A", "B");
		
//		graph.removeVertex("D");
//		graph.print();
		
		graph.depthFirstSearch("A");
	}

}

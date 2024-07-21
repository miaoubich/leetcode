package com.mioubich.graph;

public class MainMatrix {

	public static void main(String[] args) {
		GraphMatrix graph = new GraphMatrix(5);
		
		graph.addVertex("A");//index 0
		graph.addVertex("B");// 1
		graph.addVertex("C");// 2
		graph.addVertex("D");// 3
		graph.addVertex("E");// 4
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(4, 2);
		graph.addEdge(4, 0);	
		
		graph.print();
		
		System.out.println("\nDFS:");
		graph.depthFirstSearch(2);
		
		char[][] matrix = {
							{'0','1','0','0','0'}, 
							{'0','0','1','0','1'}, 
							{'0','0','0','1','1'}, 
							{'0','0','0','0','0'}, 
							{'1','0','1','0','0'}
						  };
		System.out.println("Number of islands is: " + graph.numIslands(matrix));
	}

}

package com.mioubich.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Building a graph using Matrix Pattern
public class GraphMatrix {

	private int[][] matrix;
	List<String> vertices;
	
	public GraphMatrix(int size) {
		matrix = new int[size][size];
	}
	
	public void print() {
		System.out.println(" " + " A B C D E");
		for(int i=0; i<matrix.length; i++) {
			switch(i) {
			case 0:{
					System.out.print("A ");
					break;
					}
			case 1:{
				System.out.print("B ");
				break;
				}
			case 2:{
				System.out.print("C ");
				break;
				}
			case 3:{
				System.out.print("D ");
				break;
				}
			case 4:{
				System.out.print("E ");
				break;
				}
			}
			for(int j=0; j<matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public Node addVertex(String value) {
		return new Node(value);
	}
	
	public void addEdge(int vertex1Index, int vertex2Index) {
		matrix[vertex1Index][vertex2Index] = 1;
	}
	
	public boolean checkEdge(int vertex1Index, int vertex2Index) {
		return (matrix[vertex1Index][vertex2Index] == 1)? true:false;
	}
	
	public void depthFirstSearch(int startVertexIndex) {
		boolean[] visited = new boolean[matrix.length];
		dfsHelper(startVertexIndex, visited);
	}
	
	private void dfsHelper(int startVertexIndex, boolean[] visited) {
		vertices = new ArrayList<>(Arrays.asList("A","B","C","D","E"));
		
		if(visited[startVertexIndex]) {
			return;
		}
		else {
			visited[startVertexIndex] = true;
			System.out.println(vertices.get(startVertexIndex));
		}
		for(int i=0; i<matrix[startVertexIndex].length; i++) {
			if(matrix[startVertexIndex][i] == 1) {
				dfsHelper(i, visited);
			}
		}
	}
	
	public int numIslands(char[][] grid) {
		int islandsCount = 0;
		
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length; j++) {
				if(grid[i][j] == '1') {
					islandsCount += 1;
					callBFS(grid, i, j);
				}
			}
		}
		return islandsCount;
	}

	private void callBFS(char[][] grid, int i, int j) {
		if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] == '0')
			return;
		
		grid[i][j] = '0';//if we find '1' we convert it to '0'
		callBFS(grid, i+1, j);//up
		callBFS(grid, i-1, j);//down
		callBFS(grid, i, j+1);//right
		callBFS(grid, i, j-1);//left
	}
}

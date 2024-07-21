package com.mioubich.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

//Building a graph using AjdacencyList Pattern
public class Graph {

	private Map<String, List<String>> graph;

	public Graph() {
		graph = new HashMap<>();
	}

	public void print() {
		System.out.println(graph);
	}

	public boolean createVertex(String value) {
		if (!graph.containsKey(value)) {
			graph.put(value, new ArrayList<>());
			return true;
		}
		return false;
	}

	public boolean createEdge(String vertex1, String vertex2) {
		if (graph.containsKey(vertex1) && graph.containsKey(vertex2)) {
			graph.get(vertex1).add(vertex2);
			graph.get(vertex2).add(vertex1);
			return true;
		}
		return false;
	}
	
	public boolean removeEdge(String vertex1, String vertex2) {
		if(graph.containsKey(vertex1) && graph.containsKey(vertex2) && 
		   graph.get(vertex1).contains(vertex2) && 
		   graph.get(vertex2).contains(vertex1)) {
			graph.get(vertex1).remove(vertex2);
			graph.get(vertex2).remove(vertex1);
			return true;
		}
		return false;
	}
	
	public boolean removeVertex(String vertex) {
		if(graph.containsKey(vertex)) {
			for(String otherVertex: graph.get(vertex)) {
				graph.get(otherVertex).remove(vertex);
			}
			graph.remove(vertex);
			return true;
		}
		return false;
	}
	
	public void depthFirstSearch(String startVertex) {
		Set<String> visited = new HashSet<>();
		
		Stack<String> stack = new Stack<>();
		stack.push(startVertex);
		
		while(!stack.isEmpty()) {
			String vertex = stack.pop();
			
			if(!visited.contains(vertex)) {
				visited.add(vertex);
				System.out.print(vertex + " ");
				
				List<String> adjList = graph.get(vertex);
				for(String neighborVertex: adjList) {
					if(!visited.contains(neighborVertex)) {
						stack.push(neighborVertex);
					}
				}
			}
		}
		
		
	}
}

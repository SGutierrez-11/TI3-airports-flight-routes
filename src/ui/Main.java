package ui;

import collections.WeightedGraph;

public class Main {
	private static WeightedGraph<Integer> graph;
	
	public static void main(String[] args) {
		
		graph = new WeightedGraph<>(3);
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		
		
		graph.addEdge(1, 2, 4, true);
		graph.addEdge(1, 3, 2, true);
		graph.addEdge(2, 1, 5, true);
		graph.addEdge(2, 3, 3, true);
		graph.addEdge(3, 1, 6, true);
		graph.addEdge(3, 2, 7, true);
		
		int[][] matrix=graph.minimunDistancesList();
		for(int i=0; i<3;i++) {
			for(int j=0;j<3;j++) {
				
				System.out.print("["+matrix[i][j]+"]");
			}
		}
	}
}

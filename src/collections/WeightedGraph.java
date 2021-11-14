package collections;

import java.util.PriorityQueue;

public class WeightedGraph<T> {
		
		//private int vertex;
		
		private LinkedList<Edge<T>> adjancencyList;
		
		private PriorityQueue<Vertex<T>> queue;
		
		private Vertex<T>[] vertexList;
		
		private int vertex;
		
		public WeightedGraph(int vertex) {
			
			//this.vertex = vertex;
			
			adjancencyList = new LinkedList<Edge<T>>();
			
			this.vertex = vertex;
			
			queue = new PriorityQueue<Vertex<T>>(vertex);
			
			vertexList = new Vertex[vertex];
			
		}
		/*
		 static class Graph {
		 int vertices;
		 collections.LinkedList<T>

		 Graph(int vertices) {
		 this.vertices = vertices;
		 adjacencylist = new LinkedList[vertices];
		 //initialize adjacency lists for all the vertices
		 for (int i = 0; i <vertices ; i++) {
		 adjacencylist[i] = new LinkedList<>();
		 }
		 }

		 public void addEgde(int source, int destination, int weight) {
		 Edge edge = new Edge(source, destination, weight);
		 adjacencylist[source].addFirst(edge); //for directed graph
		 }

		 public void printGraph(){
		 for (int i = 0; i <vertices ; i++) {
		 LinkedList<Edge> list = adjacencylist[i];
		 for (int j = 0; j <list.size() ; j++) {
		 System.out.println("vertex-" + i + " is connected to " +
		 list.get(j).destination + " with weight " + list.get(j).weight);
		 }
		 }
		 }
		 }
		 public static void main(String[] args) {
		 int vertices = 6;
		 Graph graph = new Graph(vertices);
		 graph.addEgde(0, 1, 4);
		 graph.addEgde(0, 2, 3);
		 graph.addEgde(1, 3, 2);
		 graph.addEgde(1, 2, 5);
		 graph.addEgde(2, 3, 7);
		 graph.addEgde(3, 4, 2);
		 graph.addEgde(4, 0, 4);
		 graph.addEgde(4, 1, 4);
		 graph.addEgde(4, 5, 6);
		 graph.printGraph();
		 }
		}
		 */

		public LinkedList<Edge<T>> getAdjancencyList() {
			return adjancencyList;
		}

		public void setAdjancencyList(LinkedList<Edge<T>> adjancencyList) {
			this.adjancencyList = adjancencyList;
		}

		public PriorityQueue<Vertex<T>> getQueue() {
			return queue;
		}

		public void setQueue(PriorityQueue<Vertex<T>> queue) {
			this.queue = queue;
		}

		public int getVertex() {
			return vertex;
		}

		public void setVertex(int vertex) {
			this.vertex = vertex;
		}
		
}

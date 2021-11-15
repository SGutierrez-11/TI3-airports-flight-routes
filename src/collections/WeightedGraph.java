package collections;

import java.util.PriorityQueue;

public class WeightedGraph<T> {
		
		//private int vertex;
		
		private LinkedList<Edge<T>> adjancencyList;
		
		//private PriorityQueue<Vertex<T>> queue;
		
		private Vertex<T>[] vertexList;
		
		private int vertex;
		
		public WeightedGraph(int vertex) {
			
			//this.vertex = vertex;
			
			adjancencyList = new LinkedList<Edge<T>>();
			
			this.vertex = vertex;
			
			//queue = new PriorityQueue<Vertex<T>>(vertex);
			
			vertexList = new Vertex[vertex];
			
		}
		public void addVertex(T element) {
			
			boolean out = false;
			Vertex<T> tmp;
			for(int i =0; i < vertexList.length && !out;i++) {
			tmp = new Vertex<T>(element, i);	
				if(vertexList[i]==null) {
					
					vertexList[i] = tmp;
					out = true;
				}
				
			}
			
			
		}
		public void addEdge(int origin, int destination, int weight, boolean twoDirection) {
		
			Vertex<T> originVertex = null;
			
			Vertex<T> destinationVertex = null;
			
			for(int i=0; i < vertexList.length;i++) {
				
				if(vertexList[i].getIdentificator()==origin) {
					
					originVertex = vertexList[i];
					
				}
				if(vertexList[i].getIdentificator()==destination) {
					
					destinationVertex = vertexList[i];
					
				}
				
				
			}
			if(originVertex==null||destinationVertex==null) {
				
			}else {
			Edge<T> tmpEdge = new Edge<T>(originVertex, destinationVertex, weight, twoDirection);
			LinkedList<Edge<T>> next = new LinkedList<Edge<T>>(tmpEdge);
			adjancencyList.setNext(next);
			}
			
		}
		public int[][] minimunDistancesList() {
			
			int [][] matrix = new int[vertex][vertex];
			
			int [][] minDistances = new int[vertex][vertex];
			
			LinkedList<Edge<T>> tmp = adjancencyList;
			
			while(tmp!=null) {
				
				matrix[tmp.getObject().source.getIdentificator()][tmp.getObject().destination.getIdentificator()] = tmp.getObject().weight;
				if(tmp.getObject().doubleDirected==true) {
					
					matrix[tmp.getObject().destination.getIdentificator()][tmp.getObject().source.getIdentificator()] = tmp.getObject().weight;
				}
				tmp = tmp.getNext();
			}
			for(int i=0; i < vertex;i++) {
				
				for(int j=0; j<vertex;j++) {
					
					if(i==j) {
						matrix[i][j]= 0;
					}else {
					
					if(matrix[i][j]==0) {
						
						matrix[i][j] = Integer.MAX_VALUE;
						
						}
					}
				}
			}	
			minDistances = matrix;
			for(int k=0; k < vertex;k++) {
				
				for(int i=0; i < vertex;i++) {
					
					
					for(int j=0; j < vertex;j++) {
						
						if(minDistances[i][j]>(minDistances[i][k]+minDistances[k][j])) {
							
							minDistances[i][j] = (minDistances[i][k]+minDistances[k][j]);
						}
						
					}
				}
				
				
			}	
				
				
			
			
			
			return minDistances;
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

		/*
		public PriorityQueue<Vertex<T>> getQueue() {
			return queue;
		}

		public void setQueue(PriorityQueue<Vertex<T>> queue) {;adi
			this.queue = queue;
		}
*/
		public int getVertex() {
			return vertex;
		}

		public void setVertex(int vertex) {
			this.vertex = vertex;
		}
		
}

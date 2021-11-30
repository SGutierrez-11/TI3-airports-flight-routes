package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class WeightedGraph<T> {
		
		//private int vertex;
		
		private LinkedList<Edge<T>> adjancencyList;
		private List<Edge<T>> adjacency;

		//private PriorityQueue<Vertex<T>> queue;
		
		private Vertex<T>[] vertexList;
		
		private int vertex;
		
		public WeightedGraph(int vertex) {
			
			//this.vertex = vertex;
			
			adjancencyList = new LinkedList<Edge<T>>();
			
			this.vertex = vertex;
			
			//queue = new PriorityQueue<Vertex<T>>(vertex);
			
			vertexList = new Vertex[vertex];

			adjacency = new ArrayList<Edge<T>>();
			
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
			adjacency.add(tmpEdge);
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

		public LinkedList<Edge<T>> getAdjancencyList() {

			return adjancencyList;
		}

	public List<Edge<T>> getAdjacency() {
		return adjacency;
	}

	public void setAdjacency(List<Edge<T>> adjacency) {
		this.adjacency = adjacency;
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



		public String BFS(Vertex<T> element) {

			for(int i=0; i < vertexList.length;i++){

				if (vertexList[i] == element) {

				} else {

					vertexList[i].setColor("WHITE");
					vertexList[i].setDistance(Integer.MAX_VALUE);
					vertexList[i].setPredescesor(null);
				}
			}
			element.setColor("GRAY");
			element.setDistance(0);
			element.setPredescesor(null);
			Queue<Vertex<T>> queue = new Queue<Vertex<T>>();
			queue.add(element);
			while (queue.isEmpty()==false){

				Vertex<T> u = queue.remove();

					
				}
			}

		}
		}
}

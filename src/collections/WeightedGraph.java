package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class WeightedGraph<T> {
		
		//private int vertex;
		
		private LinkedListOwn<Edge<T>> adjancencyList;
		//private List<Vertex<T>> adjacency;

		//private PriorityQueue<Vertex<T>> queue;
		
		private Vertex<T>[] vertexList;
		
		private int time = 0;
		private int vertex;
		
		public WeightedGraph(int vertex) {
			
			//this.vertex = vertex;
			
			adjancencyList = new LinkedListOwn<Edge<T>>();
			
			this.vertex = vertex;
			
			//queue = new PriorityQueue<Vertex<T>>(vertex);
			
			vertexList = new Vertex[vertex];

			//adjacency = new ArrayList<Vertex<T>>();
			
		}
		public void addVertex(T element) {  //Unit test 
			
			boolean out = false;
			Vertex<T> tmp;
			for(int i =0; i < vertexList.length && !out;i++) {
			tmp = new Vertex<T>(element, i,vertex);	
				if(vertexList[i]==null) {
					
					vertexList[i] = tmp;
					out = true;
				}
				
			}
			
			
		}

		

		public int getVertexPos(T element) {
			
			int pos = 0;
			boolean out = false;
			for(int i=0; i < vertex && out==false;i++) {
				
				if(vertexList[i].getElement().equals(element)) {
					
					pos = i;
					out = true;
				}
				
				
			}
			return pos;
			
		}
		
		public void addEdge(T origin, T destination, int weight, boolean twoDirection) {

		
			Vertex<T> originVertex = null;
			
			Vertex<T> destinationVertex = null;
			
			for(int i=0; i < vertexList.length;i++) {
				
				if(vertexList[i].getElement()==origin) {
					
					originVertex = vertexList[i];
					//System.out.println(originVertex.getIdentificator());
					
				}
				if(vertexList[i].getElement()==destination) {
					
					destinationVertex = vertexList[i];
					//System.out.println(destinationVertex.getIdentificator());
				}
				
				
			}
			if(originVertex==null||destinationVertex==null) {
				System.out.println("Esta entrando aqui ");
				
			}else {
			Edge<T> tmpEdge = new Edge<T>(originVertex, destinationVertex, weight, twoDirection);
			
			LinkedListOwn<Edge<T>> next = new LinkedListOwn<Edge<T>>(tmpEdge);
			
			originVertex.addAdjVert(destinationVertex);
			//destinationVertex.addAdjVert(originVertex);
			
			if(adjancencyList.getObject()==null) {
				adjancencyList =next;
			}else {
			adjancencyList.setNext(next);
			//adjacency.add(tmpEdge);
			}
			
			}
		}
		public int[][] minimunDistancesList() { //Unit test
			
			int [][] matrix = new int[vertex][vertex];
			
			int [][] minDistances = new int[vertex][vertex];
			
			LinkedListOwn<Edge<T>> tmp = adjancencyList;

			
			
			while(tmp!=null) {
				
				
				
				
				matrix[tmp.getObject().source.getIdentificator()][tmp.getObject().destination.getIdentificator()] = tmp.getObject().weight;
				//System.out.println(tmp.getObject().source.getIdentificator() + " " + tmp.getObject().destination.getIdentificator() + " " + tmp.getObject().weight);
					
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
					 //System.out.print(matrix[i][j] + " ");	
				}
				//System.out.println();
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

		public LinkedListOwn<Edge<T>> getAdjancencyList() {

			return adjancencyList;
		}
/*
	public List<Edge<T>> getAdjacency() {
		return adjacency;
	}

	public void setAdjacency(List<Edge<T>> adjacency) {
		this.adjacency = adjacency;
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
		*/
		public int getVertex() {
			return vertex;
		}

		public void setVertex(int vertex) {
			this.vertex = vertex;
		}


		public void BFS(Vertex<T> element) { 

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
			//Queue<Vertex<T>> queue = new Queue<Vertex<T>>();
			//Queue<Vertex<T>> queue = new java.util.LinkedList<Vertex<T>>();
			Queue<Vertex<T>> queue = new LinkedList<Vertex<T>>();
			queue.add(element);
			while (queue.isEmpty()==false){

				Vertex<T> u = queue.remove();
				
				for (Vertex<T>v:u.getAdjan()) {
					if(v!=null) {
						v.setColor("GRAY");
						v.setDistance(u.getDistance()+1);
						v.setPredescesor(u);
						queue.add(v);
					}
				}
				u.setColor("BLACK");
				}

			}
		
		
		public void DFS(){

			for (Vertex<T> u:vertexList) {
				u.setColor("WHITE");
				u.setPredescesor(null);
			}
			time = 0;
			for (Vertex<T> u:vertexList) {

				if(u.getColor().equals("WHITE")){
					DFS_VISIT(u);

				}

			}

		}
		public void DFS_VISIT(Vertex<T> u){
			time = time+1;
			u.setDistance(time);
			u.setColor("GRAY");
			for (Vertex<T>v:vertexList) {
				if(v.getColor().equals("WHITE")){
					v.setPredescesor(u);
					DFS_VISIT(v);
				}

			}
			u.setColor("BLACK");
			time = time+1;
			u.setF(time);
		}
		public void Dijkstra(Vertex<T> source){

			source.setDistance(0);

			PriorityQueue<Vertex<T>> q = new PriorityQueue<Vertex<T>>();

			for (Vertex<T> v:vertexList) {

				if(v!=source){
					v.setDistance(Integer.MAX_VALUE);
					v.setPredescesor(null);

					q.add(v);

					while(q.isEmpty()==false){

						Vertex<T> u = q.remove();


					}
				}
			}

		}

	public void setAdjancencyList(LinkedListOwn<Edge<T>> adjancencyList) {
		this.adjancencyList = adjancencyList;
	}

	public Vertex<T>[] getVertexList() {
		return vertexList;
	}

	public void setVertexList(Vertex<T>[] vertexList) {
		this.vertexList = vertexList;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
}


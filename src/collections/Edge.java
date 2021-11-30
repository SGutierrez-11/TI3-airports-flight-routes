package collections;

public class Edge<T> {
	
	
	Vertex<T> source;
	Vertex<T> destination;
	int weight;
	

	boolean doubleDirected;

	public Edge(Vertex<T> source, Vertex<T> destination, int weight, boolean doubleDirected) {
		
		this.source = source;
		this.destination = destination;
		this.weight = weight;
		this.doubleDirected = doubleDirected;
	}
	
	public int getWeight() {
		return weight;
	}
}

package collections;

public class Edge<T> {
	
	
		 T source;
		 T destination;
		 int weight;
		 boolean doubleDirected;

		 public Edge(T source, T destination, int weight, boolean doubleDirected) {
		 this.source = source;
		 this.destination = destination;
		 this.weight = weight;
		 this.doubleDirected = doubleDirected;
		 }
}

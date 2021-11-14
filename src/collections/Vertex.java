package collections;

public class Vertex<T>{

	private T element;
	
	private int identificator;
	
	private LinkedList<Edge<T>> edgesList; 
	
	private int distance;
	
	private String color;
	
	public Vertex(T element, int identificator){
		
		this.setElement(element);
		this.setIdentificator(identificator);
		setEdgesList(new LinkedList<Edge<T>>());
		setDistance(Integer.MAX_VALUE);
		setColor("");
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public int getIdentificator() {
		return identificator;
	}

	public void setIdentificator(int identificator) {
		this.identificator = identificator;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public LinkedList<Edge<T>> getEdgesList() {
		return edgesList;
	}

	public void setEdgesList(LinkedList<Edge<T>> edgesList) {
		this.edgesList = edgesList;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}

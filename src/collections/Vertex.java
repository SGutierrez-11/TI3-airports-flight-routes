package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Vertex<T> {

	private T element;

	private int identificator;
	
	private Vertex<T>[] adjan;

	private LinkedList<Edge<T>> edgesList;

	//private List<Edge<T>> edgesList;

	private int distance;

	private String color;

	private Vertex<T> predescesor;

	private int f;

	public Vertex(T element, int identificator, int maxSize) {

		this.setElement(element);
		this.setIdentificator(identificator);
		setEdgesList(new LinkedList<Edge<T>>());
		//setDistance(Integer.MAX_VALUE);
		color = "";
		predescesor = null;
		//edgesList = new ArrayList<Edge<T>>();
		adjan = new Vertex[maxSize];
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
	/*
	public List<Edge<T>> getEdgesList() {
		return edgesList;
	}

	public void setEdgesList(List<Edge<T>> edgesList) {
		this.edgesList = edgesList;
	}
*/
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

	public void setPredescesor(Vertex<T> predescesor) {
		this.predescesor = predescesor;
	}

	public Vertex<T> getPredescesor() {
		return predescesor;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	public void addAdjVert(Vertex<T> element) {
		
		
		boolean out = false;
		for(int i=0; i < adjan.length && out==false;i++) {
			
			if(adjan[i]==null) {
				
				adjan[i] = element;
				out = true;
				
			}
			
			
		}
		
		
	}
	
	
	
	public Vertex<T>[] getAdjan() {
		return adjan;
	}

	public void setAdjan(Vertex<T>[] adjan) {
		this.adjan = adjan;
	}
	
}
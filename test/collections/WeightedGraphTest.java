package collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WeightedGraphTest {
	
	private WeightedGraph<Integer> graph;
	
	public void setupStage1() {
		
	}
	
	public void setupStage2() {
		graph = new WeightedGraph<Integer>(5);
	}
	
	public void setupStage3() {
		graph = new WeightedGraph<Integer>(3);
	}
	
	@Test
	public void addVertexTest1() {
		setupStage1();
		
		WeightedGraph<Integer> gp = new WeightedGraph<>(0);
		
		gp.addVertex(1);
		
		assertEquals(gp.getVertex(), 0);
		
	}
	
	@Test
	public void addVertexTest2() {
		setupStage2();
		
		
		graph.addVertex(1);
		
		assertEquals(graph.getVertexList()[0].getElement(),(Integer) 1);
		
	}
	
	@Test
	public void addVertexTest3() {
		setupStage2();
		
		
		graph.addVertex(1);
		graph.addVertex(2);
		
		assertEquals(graph.getVertexList()[0].getElement(),(Integer) 1);
		assertEquals(graph.getVertexList()[1].getElement(),(Integer) 2);
	}
	
	@Test
	public void addVertexTest4() {
		setupStage2();
		
		
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		
		assertEquals(graph.getVertexList()[0].getElement(),(Integer) 1);
		assertEquals(graph.getVertexList()[1].getElement(),(Integer) 2);
		assertEquals(graph.getVertexList()[2].getElement(),(Integer) 3);
		assertEquals(graph.getVertexList()[3].getElement(),(Integer) 4);
		assertEquals(graph.getVertexList()[4].getElement(),(Integer) 5);
		
	}
	
	@Test
	public void addEdgeTest1() {
		setupStage1();
		
		WeightedGraph<Integer> gp = new WeightedGraph<>(2);
		
		gp.addVertex(1);
		gp.addVertex(2);
		gp.addEdge(1, 0, 0, true);
		
		assertEquals(gp.getAdjancencyList().getObject().getWeight(), 0);
		
	}
	
	@Test
	public void addEdgeTest2() {
		setupStage2();
	
		
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		graph.addEdge(1, 2, 4, true);
		
		assertEquals(graph.getAdjancencyList().getObject().getWeight(), 4);
		
	}
	
	@Test
	public void addEdgeTest3() {
		setupStage2();
	
		
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		graph.addEdge(1, 2, 4, true);
		graph.addEdge(3, 4, 8, true);
		
		
		assertEquals(graph.getAdjancencyList().getObject().getWeight(), 4);
		assertEquals(graph.getAdjancencyList().getNext().getObject().getWeight(), 8);
		
	}
	
	@Test
	public void minimunDistancesTest1() {
		setupStage3();
	
		
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		
		
		graph.addEdge(1, 2, 4, true);
		graph.addEdge(1, 3, 2, true);
		graph.addEdge(2, 1, 5, true);
		graph.addEdge(2, 3, 3, true);
		graph.addEdge(3, 1, 6, true);
		graph.addEdge(3, 2, 7, true);
		
		int[][] matrix = {{-10,2147483637,2147483631},{2147483637,-12,-18},{2147483631,-18,-24}};
		
		
		
		assertEquals(graph.minimunDistancesList(), matrix);
		
	}
	
	@Test
	public void BFStest1() {
		setupStage2();
	
		
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		graph.addEdge(1, 2, 2, true);
		graph.addEdge(2, 3, 2, true);
		graph.addEdge(3, 4, 2, true);
		graph.addEdge(4, 5, 2, true);
		
		graph.BFS(graph.getVertexList()[1]);
		
		assertEquals(graph.getVertexList()[1].getColor(), "BLACK");
	}
	
	@Test
	public void DijkstraTest1() {
	}
	
	
}

package collections;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WeightedGraphTest {
	
	private WeightedGraph<Integer> graph;
	
	public void setupStage1() {
		
	}
	
	public void setupStage2() {
		graph = new WeightedGraph<>(5);
	}
	
	public void setupStage3() {
		graph = new WeightedGraph<>(3);
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
		gp.addEdge(gp.getVertexPos(1), gp.getVertexPos(2), 3, true);
		
		assertEquals(gp.getAdjancencyList().getObject().getWeight(), 3);
		
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
		graph.addEdge(graph.getVertexPos(1), graph.getVertexPos(2), 4, true);
		graph.addEdge(graph.getVertexPos(3), graph.getVertexPos(4), 8, true);
		graph.addEdge(graph.getVertexPos(4), graph.getVertexPos(5), 3, true);
		graph.addEdge(graph.getVertexPos(2), graph.getVertexPos(4), 2, true);
		
		
		assertEquals(graph.getAdjancencyList().getObject().getWeight(), 4);
		assertEquals(graph.getAdjancencyList().getNext().getObject().getWeight(), 8);
		assertEquals(graph.getAdjancencyList().getNext().getNext().getObject().getWeight(), 3);
		assertEquals(graph.getAdjancencyList().getNext().getNext().getNext().getObject().getWeight(),2);
	}
	
	@Test
	public void minimunDistancesTest1() {
		setupStage3();
	
		
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		
		
		graph.addEdge(graph.getVertexPos(1), graph.getVertexPos(2), 4, false);
		graph.addEdge(graph.getVertexPos(1), graph.getVertexPos(3), 2, false);
		graph.addEdge(graph.getVertexPos(2), graph.getVertexPos(1), 5, false);
		graph.addEdge(graph.getVertexPos(2), graph.getVertexPos(3), 3, false);
		graph.addEdge(graph.getVertexPos(3), graph.getVertexPos(1), 6, false);
		graph.addEdge(graph.getVertexPos(3), graph.getVertexPos(2), 7, false);
		
		int[][] matrix = {{0,4,2},{5,0,3},{6,7,0}};
		
		assertArrayEquals(graph.minimunDistancesList(),matrix);
		
	}
	
	@Test
	public void BFStest1() {
		setupStage2();
	
		
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		graph.addEdge(graph.getVertexPos(1), graph.getVertexPos(2), 4, true);
		graph.addEdge(graph.getVertexPos(3), graph.getVertexPos(4), 8, true);
		graph.addEdge(graph.getVertexPos(4), graph.getVertexPos(5), 3, true);
		graph.addEdge(graph.getVertexPos(2), graph.getVertexPos(4), 2, true);
		
		graph.BFS(graph.getVertexList()[1]);
		
		assertEquals(graph.getVertexList()[1].getColor(), "BLACK");
	}
	
	@Test
	public void BFStest2() {
		setupStage2();
	
		
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		graph.addEdge(graph.getVertexPos(1), graph.getVertexPos(2), 4, true);
		graph.addEdge(graph.getVertexPos(3), graph.getVertexPos(4), 8, true);
		graph.addEdge(graph.getVertexPos(4), graph.getVertexPos(5), 3, true);
		graph.addEdge(graph.getVertexPos(2), graph.getVertexPos(4), 2, true);
		
		graph.BFS(graph.getVertexList()[1]);
		
		assertEquals(graph.getVertexList()[3].getColor(), "BLACK");
		assertEquals(graph.getVertexList()[1].getColor(), "BLACK");
		assertEquals(graph.getVertexList()[2].getColor(), "WHITE");
	}
	
	
}

package model;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class AgencyTest {
	
	private Agency agency;
	
	public void setupStage1() {
		
	}
	
	public void setupStage2() {
		
		agency = new Agency();
		
	}
	
	@Test
	public void findBestWayTest() throws IOException {
		setupStage1();
		
		Agency a = new Agency();
		 
		a.importData("../TI3-airports-flight-routes/data/cost1");
		
		
		assertEquals(a.findBestWay("BOG", "CLO"),"El Precio Minimo entre: BOG-CLO Con Origen en BOG Y Destino en CLO Es 100000");
	}
	
	@Test
	public void findBestWayTest1() throws IOException {
		setupStage2();
		
		
		 
		agency.importData("../TI3-airports-flight-routes/data/cost1");
		
		
		assertEquals(agency.findBestWay("CLO", "BAQ"),"El Precio Minimo entre: CLO-BAQ Con Origen en CLO Y Destino en BAQ Es 85000");
	}
	
	@Test
	public void findBestWayReturnTest1() throws IOException {
		setupStage2();
		
		
		 
		agency.importData("../TI3-airports-flight-routes/data/cost1");
		
		
		assertEquals(agency.findBestWayReturn("CLO", "BAQ"),85000);
	}
	
	
	@Test
	public void findBestWayReturnTest2() throws IOException {
		setupStage2();
		
		
		 
		agency.importData("../TI3-airports-flight-routes/data/cost1");
		
		
		assertEquals(agency.findBestWayReturn("BOG", "CLO"),100000);
	}
	
	@Test
	public void importDataTest() throws IOException {
		setupStage2();
		 
		agency.importData("../TI3-airports-flight-routes/data/cost1");
		
		assertEquals(agency.getTravel().getVertexList()[0].getElement(),"CLO");
	}
	
}

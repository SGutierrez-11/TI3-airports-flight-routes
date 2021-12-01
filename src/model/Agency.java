package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import collections.WeightedGraph;

public class Agency {
	
	private WeightedGraph<String> travel;
	
	//private WeightedGraph<String> returnTravel;
	
	String [] cityOrder;
	
	public Agency() {
		
		
	}
	
	
	public WeightedGraph<String> getTravel() {
		return travel;
	}


	public void setTravel(WeightedGraph<String> travel) {
		this.travel = travel;
	}


	public void importData(String localPath)throws IOException {
		
		System.out.println(localPath);
		
		BufferedReader br = new BufferedReader(new FileReader(localPath));
		
		
		String line = br.readLine();
		
		String[] cities = line.split(" ");
		
		cityOrder = cities;
		
		WeightedGraph<String> tmp = new WeightedGraph<String>(cities.length);
		
		travel = tmp;
		line = br.readLine();
		for(int i=0; i < cities.length;i++) {
			
			travel.addVertex(cities[i]);
			
			
		}
		
		System.out.println("Antes del While");
		//line = br.readLine();
		while(line!=null) {
			
			
			String[] tmpText = line.split(" ");
			
			travel.addEdge( travel.getVertexPos(tmpText[0]),travel.getVertexPos(tmpText[1]), Integer.parseInt(tmpText[2]), false);
			System.out.println("Pasa del add edge/itera");
			line = br.readLine();
		}
		br.close();
		System.out.println("Termina el import");
	}
	
	public String findBestWay(String origin, String destiny) {		
		
		int[][] minimunDistances = travel.minimunDistancesList();
		
		for(int i=0; i < cityOrder.length;i++) {
			
			for(int j=0; j< cityOrder.length;j++) {
				
				System.out.print(minimunDistances[i][j] + " ");	
				}
			System.out.println();
			}
			
			
		
		int x = 0;
		
		int y=0;
		for(int i=0;i < cityOrder.length;i++) {
			
			
			if(cityOrder[i].equals(origin)) {
				
				x = i;
				
			}
			
		}
		for(int i=0;i < cityOrder.length;i++) {
			
			
			if(cityOrder[i].equals(destiny)) {
				
				y = i;
				
			}
			
		}
		String text = "El Precio Minimo entre: " + origin + "-" + destiny + " Con Origen en " + origin + " Y Destino en " + destiny + " Es " + minimunDistances[x][y];
		return text;
		
	}
	
	public int findBestWayReturn(String origin, String destiny) {		
		
		int[][] minimunDistances = travel.minimunDistancesList();
		
		for(int i=0; i < cityOrder.length;i++) {
			
			for(int j=0; j< cityOrder.length;j++) {
				
				System.out.print(minimunDistances[i][j] + " ");	
				}
			System.out.println();
			}
			
			
		
		int x = 0;
		
		int y=0;
		for(int i=0;i < cityOrder.length;i++) {
			
			
			if(cityOrder[i].equals(origin)) {
				
				x = i;
				
			}
			
		}
		for(int i=0;i < cityOrder.length;i++) {
			
			
			if(cityOrder[i].equals(destiny)) {
				
				y = i;
				
			}
			
		}
		
		
		
		
		return minimunDistances[x][y];		
	}
	
	
	
	
}

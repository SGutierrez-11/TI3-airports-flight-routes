package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import collections.WeightedGraph;

public class Agency {
	
	private WeightedGraph<String> travel;
	
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
		
		BufferedReader br = new BufferedReader(new FileReader(localPath));
		
		String line = br.readLine();
		
		String[] cities = line.split(" ");
		
		cities = cityOrder;
		
		WeightedGraph<String> tmp = new WeightedGraph<String>(cities.length);
		
		travel = tmp;
		line = br.readLine();
		for(int i=0; i < cities.length;i++) {
			
			travel.addVertex(cities[i]);
			
			
		}
		
		
		while(line!=null) {
			
			String[] tmpText = line.split(" ");
			
			travel.addEdge( travel.getVertexPos(tmpText[0]) , travel.getVertexPos(tmpText[1]), Integer.parseInt(tmpText[2]), false);
		}
		br.close();
		
	}
	
	public void findBestWay(String origin, String destiny) {
	
		
		int[][] minimunDistances = travel.minimunDistancesList();
		
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
		System.out.println("El Precio Minimo entre: " + origin + "-" + destiny + " Con Origen en " + origin + " Y Destino en " + destiny + " Es" + minimunDistances[x][y]);
		
		
	}
	
	
}

package com.betacom.car.process;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ProcessSequential {

	public List<String> leggiFile() {
		
		String filePath = "C:\\Users\\Ho\\eclipse-workspace\\Betacom\\projectCar\\src\\datiExport.txt";
		
		List<String> r = readRecord(filePath);
		
		for(String i : r) {
			System.out.println(i);
		}
		
		return readRecord(filePath);
		
	}
	
	private List<String> readRecord(String path){
		
		List<String> r = new ArrayList<String>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(path))){
			
			String line = reader.readLine();

			while(line != null) {
				r.add(line);
				line = reader.readLine();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return r;
		
	}

	
}

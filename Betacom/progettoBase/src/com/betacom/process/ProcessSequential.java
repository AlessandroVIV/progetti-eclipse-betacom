package com.betacom.process;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProcessSequential {

	public boolean execute() {
		
		System.out.println("Inizia ProcessSequential\n");
		
		// I file sequenziali
		
		// Definisco il file path da leggere
		String filePath1 = "C:\\Users\\Ho\\eclipse-workspace\\Betacom\\progettoBase\\src\\testSequential.txt";
		
		// Definisco un altro file path per la scrittura
		String filePath2 = "C:\\Users\\Ho\\eclipse-workspace\\Betacom\\progettoBase\\src\\records.txt";

		// Chiamo il metodo "readRecord"
		List<String> r = readRecord(filePath1);
		
		for(String i : r) {
			System.out.println(i);
		}
		
		// Ora scrivo un file
		List<String> records = new ArrayList<String>();
		
		records.add("Record 1");
		records.add("Record 2");
		records.add("Record 3");
		records.add("Record 4");
		records.add("Record 5");
		records.add("Record 6");
		records.add("Record 7");
		records.add("Record 8");
		records.add("Record 9");
		
		// Specifico il boolean a seconda se mi serve scrivere o leggere
		System.out.println("\nRecords scritti: " + writeFile(filePath2, records, false));
		
		return true;
		
	}
	
	// Prima funzione
	// Read sequential file - Creo la funzione per leggere il file
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
	
	// Dichiaro la funzione per scrivere 
	private int writeFile(String path, List<String> records) {
		
		int num = 0;
		
		File f = new File(path);
		
		if(f.exists()) {
			//System.out.println("File" + path + "esiste");
			f.delete();
		}
		
		FileWriter o = null;
		
		try {
			o = new FileWriter(f);
			
			for(String rec : records) {
				o.write(rec + "\n");
				num++;
			}
			
			o.flush();
			o.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return num;
		
	}
	
	// Creo uno metodo a seconda se voglio fare lettura o scrittura
	private int writeFile(String path, List<String> records, boolean mode) {
		
		int num = 0;
		BufferedWriter o = null;
		
		try {
			
			FileWriter f = new FileWriter(path, mode);
			o = new BufferedWriter(f);
			
			for(String rec : records) {
				o.write(rec);
				o.newLine();
				num++;
			}
			
			o.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
 		
		return num;

	}
	
}
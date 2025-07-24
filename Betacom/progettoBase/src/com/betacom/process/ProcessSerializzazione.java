package com.betacom.process;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.betacom.objects.Address;

public class ProcessSerializzazione {

	public boolean execute() {
		
		System.out.println("Inizia ProcessSerializzazione\n");
		
		Address address = new Address();
		
		address.setCity("Torino");
		address.setName("Vincenzo Gigioni");
		address.setStreet("Via dei Luigi");
		
		try {
			FileOutputStream fout = new FileOutputStream("C:\\Users\\Ho\\eclipse-workspace\\Betacom\\progettoBase\\src\\address.txt");
			
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			oos.writeObject(address);
			oos.flush();
			oos.close();
			
			System.out.println("\nOggetto creato!");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		
		return true;
		
	}
	
}
package com.betacom.process;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.betacom.objects.Address;

public class ProcessDeserializzazione {

	public boolean execute() {
		
		System.out.println("Inizia ProcessDeserializzazione\n");
		
		// Address object è il client object. Il package deve essere uguale a quello del client
		Address address;
		
		try {
			
			FileInputStream fim = new FileInputStream("C:\\Users\\Ho\\eclipse-workspace\\Betacom\\progettoBase\\src\\address.txt");
			ObjectInputStream ois = new ObjectInputStream(fim); 
			
			try {
				
				address = (Address) ois.readObject();
				
				System.out.println(address);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
		
	}
	
}

package com.betacom;

import com.betacom.process.ProcessCollection;

public class MainCollection {

	public static void main(String[] args) {
		
		if(new ProcessCollection().execute()) {
			System.out.println("\nFine normale del processo");
		}
		else {
			System.out.println("Errore nel processo");
		}
		
	}

}

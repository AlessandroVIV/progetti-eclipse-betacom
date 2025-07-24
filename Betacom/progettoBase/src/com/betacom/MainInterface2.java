package com.betacom;

import com.betacom.process.ProcessInterface2;

public class MainInterface2 {

	public static void main(String[] args) {

		if(new ProcessInterface2().execute()) {
			System.out.println("\nFine normale del processo");
		} else {
			System.out.println("Errore nel processo");
		}
		
	}
	
}

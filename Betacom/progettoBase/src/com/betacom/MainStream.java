package com.betacom;

import com.betacom.process.ProcessStream;

public class MainStream {

	public static void main(String[] args) {
			
		if(new ProcessStream().execute()) {
			System.out.println("\nFine normale del programma");
		} else {
			System.out.println("Errore nel programma");
		}

	}

}

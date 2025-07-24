package com.betacom;

import com.betacom.process.ProcessFattoriale;

public class projectFattoriale {

	public static void main(String[] args) {
		
		if(new ProcessFattoriale().execute()) {
			System.out.println("\nFine del programma");
		}else {
			System.out.println("\nErrore nel programma");
		}
		
	}
	
}

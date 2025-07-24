package com.betacom;

import com.betacom.process.ProcessDeserializzazione;

public class MainDeserializzazione {

	public static void main(String[] args) {
		
		if(new ProcessDeserializzazione().execute()) {
			System.out.println("\nFine del programma");
		}else {
			System.out.println("\nErrore nel programma");
		}

	}

}

package com.betacom;

import com.betacom.process.ProcessSerializzazione;

public class MainSerializzazione {

	public static void main(String[] args) {

		if(new ProcessSerializzazione().execute()) {
			System.out.println("\nFine del programma");
		}else {
			System.out.println("\nErrore nel programma");
		}

	}

}

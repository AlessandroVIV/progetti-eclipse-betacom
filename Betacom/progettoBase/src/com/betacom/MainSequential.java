package com.betacom;

import com.betacom.process.ProcessSequential;

public class MainSequential {

	public static void main(String[] args) {

		if(new ProcessSequential().execute()) {
			System.out.println("\nFine del programma");
		}else {
			System.out.println("\nErrore nel programma");
		}
		
	}

}

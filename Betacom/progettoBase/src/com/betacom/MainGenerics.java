package com.betacom;

import com.betacom.process.ProcessGenerics;

public class MainGenerics {

	public static void main(String[] args) {
		
		if(new ProcessGenerics().execute()) {
			System.out.println("\nFine del programma");
		}else {
			System.out.println("\nErrore nel programma");
		}

	}

}

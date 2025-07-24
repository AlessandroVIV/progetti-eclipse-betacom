package com.betacom;

import com.betacom.process.ProcessInner;

public class MainInner {

	public static void main(String[] args) {
		
		if(new ProcessInner().execute()) {
			System.out.println("\nFine del programma");
		}else {
			System.out.println("\nErrore nel programma");
		}

	}

}

package com.betacom.jdbc;

import com.betacom.jdbc.process.ProcessJDBC;

public class MainJDBC {

	public static void main(String[] args) {
		
		if(new ProcessJDBC().execute()) {
			System.out.println("\nFine del programma");
		}else {
			System.out.println("\nErrore nel programma");
		}

	}

}

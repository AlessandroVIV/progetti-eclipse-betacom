package com.betacom;

import com.betacom.process.ProcessJson;

public class MainJson {

	public static void main(String[] args) {

		if(new ProcessJson().execute()) {
			System.out.println("\nFine del programma");
		}else {
			System.out.println("\nErrore nel programma");
		}
		
	}

}

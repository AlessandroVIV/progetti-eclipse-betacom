package com.betacom;

import com.betacom.process.ProcessReflection;

public class MainReflection {

	public static void main(String[] args) {

		if(new ProcessReflection().execute()) {
			System.out.println("\nFine normale del processo");
		} else {
			System.out.println("\nErrore nel processo");
		}
		
	}

}

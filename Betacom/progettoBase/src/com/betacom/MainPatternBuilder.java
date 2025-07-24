package com.betacom;

import com.betacom.objects.Negozio;

public class MainPatternBuilder {

	public static void main(String[] args) {
		     
		System.out.println("Inizia MainPatternBuilder");

		Negozio negozio = new Negozio.Builder()
				.codice(25)
				.proprietario("Mister Bean")
				.indirizzo("Via Appia 32, Roma")
				.inCentroCommerciale(true)
				.build();
		
		System.out.println("\nNegozio: " + negozio);
		
	}

}

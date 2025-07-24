package com.betacom;

import org.w3c.dom.css.CSSImportRule;

import com.betacom.objects.Impiegati;

public class MainEreditarieta {

	public static void main(String[] args) {

		System.out.println("Inizia MainEreditarieta");
		
		Impiegati imp = new Impiegati("Paola", "Verdi", false, 1500L);
		
		System.out.println(imp);
		
		imp = new Impiegati();
		imp.setCognome("Bianco");
		imp.setNome("Luigi");
		imp.setSesso(true);
		imp.setSalary(2000L);
		
		System.out.println(imp);
	}

}

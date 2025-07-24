package com.betacom.process;

import com.betacom.objects.Inner;
//import com.betacom.objects.Inner2;

public class ProcessInner {

	public boolean execute() {
		
		System.out.println("Inizia ProcessInner\n");
		
		Inner inner = new Inner();
		
		inner.setClassePadre("Sono nella classe padre");
		
		inner.setNumero(3);
		
		System.out.println("Classe Inner: " + inner.getClassePadre() + ", numero: " + inner.getNumero() + "\n");
		
		// Creo la nuova istanza del figlio e stampo uno dei suoi metodi
		
		Inner.Figlio figlio = inner.setInstanceFiglio();
		
		figlio.setNumeroFiglio(44);
		
		System.out.println("Valore del padre e del figlio: " + figlio.displayNumeri());
		
		// Creo la nuova istanza del nipote e stampo uno dei suoi metodi
		
		Inner.Figlio.Nipote nipote = figlio.setInstanceNipote();
		
		nipote.setNumeroNipote(99);
		
		System.out.println("\nValori del padre, del figlio e del nipote: " + nipote.displayNumeri());

		// Nuova istanza automatica
//		Inner2 inner2 = new Inner2();
//		inner2.setFatherClass("Siamo nella classe padre istanziata automaticamente");
//		inner2.setNumero(3);
//		
//		System.out.println("Classe Inner: " + inner2.getClassePadre() + ", numero: " + inner2.getNumero() + "\n");
//		
//		inner2.f.setNumero2(35);
//		System.out.println("Valore del figlio: " + inner2.f.n.displayNumeri()+ "\n");
//		
//		inner2.f.setNumero3(87);
//		System.out.println("Valore del nipote: " + inner2.f.n.displayNumeriNipote()+ "\n");
		
		return true;
		
	}
	
}
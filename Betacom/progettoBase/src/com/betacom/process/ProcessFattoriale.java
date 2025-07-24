package com.betacom.process;

import java.lang.reflect.Array;
import java.util.List;

public class ProcessFattoriale {

	public boolean execute() {
		
		System.out.println("Inizia ProcessFattoriale\n");
		
		int number = 0, result = 0;
		
		result = fattoriale(number);
		
		System.out.println("Il fattoriale di " + number + " è: " + result);
		
		return true;
		
	}
	
	public int fattoriale(int n) {
		
		if (n != 0) {
			return n = n * fattoriale(n - 1);
		}else {
			return 1;
		}
		
		// return n = n * fattoriale(n - 1); Il valore va in loop -> Errore	
		
	}
	
}
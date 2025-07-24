package com.betacom.singleton;

public class MySingleton {

	// Creo l'istanza statica
	private static MySingleton instance = null;
	
	// La metto private poiché userò il pattern solo per i membri della sua classe
	private MySingleton() {
		super();
	}
	
	private Integer idx = 0;
	
	// Creo la presa dell'istanza
	public static MySingleton getInstance() {
		
		if(instance == null) {
			instance = new MySingleton();
		}
		
		return instance;
		
	}
	
	public Integer computeIndice() {
		return idx++;
	}
	
}

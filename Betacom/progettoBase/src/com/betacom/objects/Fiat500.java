package com.betacom.objects;

public class Fiat500 extends Car{

	@Override
	public void frena() {
		System.out.println("La Fiat500 ha frenato");
	}

	@Override
	public void accelera() {
		System.out.println("La Fiat500 ha accelerato");
	}
	
	

}

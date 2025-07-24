package com.betacom.car.Models;

public class Moto extends Veicolo{

	private String targa; // univoca
	private Integer cc;
	
	public Moto() {
		super();
	}

	public String getTarga() {
		return targa;
	}
	
	public void setTarga(String targa) {
		this.targa = targa;
	}
	
	public Integer getCc() {
		return cc;
	}
	
	public void setCc(Integer cc) {
		this.cc = cc;
	}
	
	@Override
	public String toString() {
	    return "Moto " + super.toString()
	        + " [Targa=" + targa
	        + ", CC=" + cc + "]";
	}

	
	
}

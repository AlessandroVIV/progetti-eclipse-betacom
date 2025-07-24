package com.betacom.car.Models;

public class Macchina extends Veicolo{

	private Integer numeroPorte;
	private String Targa;    // deve essere univoca..
	private Integer cc;
	
	public Macchina() {
		super();
	}

	public Integer getNumeroPorte() {
		return numeroPorte;
	}
	
	public void setNumeroPorte(Integer numeroPorte) {
		this.numeroPorte = numeroPorte;
	}
	
	public String getTarga() {
		return Targa;
	}
	
	public void setTarga(String targa) {
		Targa = targa;
	}
	
	public Integer getCc() {
		return cc;
	}
	
	public void setCc(Integer cc) {
		this.cc = cc;
	}

	@Override
	public String toString() {
	    return "Macchina " + super.toString()
	        + " [Targa=" + Targa
	        + ", Porte=" + numeroPorte
	        + ", CC=" + cc + "]";
	}

	
	
	
}

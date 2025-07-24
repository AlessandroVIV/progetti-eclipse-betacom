package com.betacom.car.Models;

public class Bici extends Veicolo{

	private Integer numeroMarce; // 1 - n
	private String tipoSospensione; // senza, mono, bi, ....,
	private Boolean pieghevole;
	
	public Bici() {
		super();
	}

	public Integer getNumeroMarce() {
		return numeroMarce;
	}

	public void setNumeroMarce(Integer numeroMarche) {
		this.numeroMarce = numeroMarche;
	}

	public String getTipoSospenzione() {
		return tipoSospensione;
	}

	public void setTipoSospenzione(String tipoSospenzione) {
		this.tipoSospensione = tipoSospenzione;
	}

	public Boolean getPiegevole() {
		return pieghevole;
	}

	public void setPiegevole(Boolean piegevole) {
		this.pieghevole = piegevole;
	}
	
	@Override
	public String toString() {
	    return "Bici " + super.toString()
	        + " [Marce=" + numeroMarce
	        + ", Sospensione=" + tipoSospensione
	        + ", Pieghevole=" + pieghevole + "]";
	}

	
}

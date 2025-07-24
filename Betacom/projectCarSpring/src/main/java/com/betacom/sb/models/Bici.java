package com.betacom.sb.models;

public class Bici {

	private Integer id_bici;
	private Integer numeroMarce;
	private Integer id_sospensione;
	private Boolean pieghevole;
	
	public Bici() {
		
	}

	public Bici(Integer id_bici, Integer numeroMarce, Integer id_sospensione, Boolean pieghevole) {
		super();
		this.id_bici = id_bici;
		this.numeroMarce = numeroMarce;
		this.id_sospensione = id_sospensione;
		this.pieghevole = pieghevole;
	}

	public Integer getId_bici() {
		return id_bici;
	}

	public void setId_bici(Integer id_bici) {
		this.id_bici = id_bici;
	}

	public Integer getNumeroMarce() {
		return numeroMarce;
	}

	public void setNumeroMarce(Integer numeroMarce) {
		this.numeroMarce = numeroMarce;
	}

	public Integer getId_sospensione() {
		return id_sospensione;
	}

	public void setId_sospensione(Integer id_sospensione) {
		this.id_sospensione = id_sospensione;
	}

	public Boolean getPieghevole() {
		return pieghevole;
	}

	public void setPieghevole(Boolean pieghevole) {
		this.pieghevole = pieghevole;
	}

	@Override
	public String toString() {
		return "Bici [id_bici=" + id_bici + ", numeroMarce=" + numeroMarce + ", id_sospensione=" + id_sospensione
				+ ", pieghevole=" + pieghevole + "]";
	}
	
}

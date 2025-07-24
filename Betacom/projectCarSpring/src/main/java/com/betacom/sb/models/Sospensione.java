package com.betacom.sb.models;

public class Sospensione {

	private Integer id_sospensione;
	private String tipoSospensione;
	
	public Sospensione() {
		
	}
	
	public Sospensione(Integer id_sospensione, String tipoSospensione) {
		super();
		this.id_sospensione = id_sospensione;
		this.tipoSospensione = tipoSospensione;
	}

	public Integer getId_sospensione() {
		return id_sospensione;
	}

	public void setId_sospensione(Integer id_sospensione) {
		this.id_sospensione = id_sospensione;
	}

	public String getTipoSospensione() {
		return tipoSospensione;
	}

	public void setTipoSospensione(String tipoSospensione) {
		this.tipoSospensione = tipoSospensione;
	}

	@Override
	public String toString() {
		return "Sospensione [id_sospensione=" + id_sospensione + ", tipoSospensione=" + tipoSospensione + "]";
	}
	
}

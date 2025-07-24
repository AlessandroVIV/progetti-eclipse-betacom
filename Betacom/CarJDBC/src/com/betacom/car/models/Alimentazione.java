package com.betacom.car.models;

public class Alimentazione {

	private Integer id_alimentazione;
	private String alimentazione;
	
	public Alimentazione() {
		
	}
	
	public Alimentazione(Integer id_alimentazione, String alimentazione) {
		super();
		this.id_alimentazione = id_alimentazione;
		this.alimentazione = alimentazione;
	}
	
	public Integer getId_alimentazione() {
		return id_alimentazione;
	}
	public void setId_alimentazione(Integer id_alimentazione) {
		this.id_alimentazione = id_alimentazione;
	}
	public String getAlimentazione() {
		return alimentazione;
	}
	public void setAlimentazione(String alimentazione) {
		this.alimentazione = alimentazione;
	}

	@Override
	public String toString() {
		return "Alimentazione [id_alimentazione=" + id_alimentazione + ", alimentazione=" + alimentazione + "]";
	}
	
}

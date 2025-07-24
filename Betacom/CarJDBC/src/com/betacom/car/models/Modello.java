package com.betacom.car.models;

public class Modello {

	private Integer id_modello;
	private String modello;
	
	public Modello() {
		
	}
	
	public Modello(Integer id_modello, String modello) {
		super();
		this.id_modello = id_modello;
		this.modello = modello;
	}
	
	public Integer getId_modello() {
		return id_modello;
	}
	
	public void setId_modello(Integer id_modello) {
		this.id_modello = id_modello;
	}
	
	public String getModello() {
		return modello;
	}
	
	public void setModello(String modello) {
		this.modello = modello;
	}

	@Override
	public String toString() {
		return "Modello [id_modello=" + id_modello + ", modello=" + modello + "]";
	}
	
}

package com.betacom.jdbc.models;

public class Clienti {
	/*
	 * id_cliente
	 * denominazione
	 * p_iva
	 * inidirizzo
	 * telefono
	 */
	
	private Integer idCliente;
	private String nome_cliente;
	private String pIva;
	private String inidirizzo;
	private String telefono;
	
	public Clienti(Integer idCliente, String denominazione, String pIva, String inidirizzo, String telefono) {
		super();
		this.idCliente = idCliente;
		this.nome_cliente = denominazione;
		this.pIva = pIva;
		this.inidirizzo = inidirizzo;
		this.telefono = telefono;
	}

	public Clienti() {
		super();
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getDenominazione() {
		return nome_cliente;
	}

	public void setDenominazione(String denominazione) {
		this.nome_cliente = denominazione;
	}

	public String getpIva() {
		return pIva;
	}

	public void setpIva(String pIva) {
		this.pIva = pIva;
	}

	public String getInidirizzo() {
		return inidirizzo;
	}

	public void setInidirizzo(String inidirizzo) {
		this.inidirizzo = inidirizzo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Clienti [idCliente=" + idCliente + ", denominazione=" + nome_cliente + ", pIva=" + pIva
				+ ", inidirizzo=" + inidirizzo + ", telefono=" + telefono + "]";
	}
}
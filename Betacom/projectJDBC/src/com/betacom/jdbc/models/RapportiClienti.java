package com.betacom.jdbc.models;

public class RapportiClienti {

	/*
	id_rapporto
	descrizione
	id_cliente
	id_dipendenti
	*/
	
	private Integer idRapporto;
	private String descrizione;
	private Integer idCliente;
	private Integer idDipendenti;
	
	public RapportiClienti() {
		
	}

	public RapportiClienti(Integer id_rapporto, String descrizione, Integer id_cliente, Integer id_dipendenti) {
		this.idRapporto = id_rapporto;
		this.descrizione = descrizione;
		this.idCliente = id_cliente;
		this.idDipendenti = id_dipendenti;
	}

	public Integer getIdRapporto() {
		return idRapporto;
	}

	public void setIdRapporto(Integer idRapporto) {
		this.idRapporto = idRapporto;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdDipendenti() {
		return idDipendenti;
	}

	public void setIdDipendenti(Integer idDipendenti) {
		this.idDipendenti = idDipendenti;
	}

	@Override
	public String toString() {
		return "RapportiClienti [idRapporto=" + idRapporto + ", descrizione=" + descrizione + ", idCliente=" + idCliente
				+ ", idDipendenti=" + idDipendenti + "]";
	}

}

package com.betacom.objects;

public class ClientStreamMap {

	private String nomeCompleto;
	private Integer eta;
	private Double stipendio;
	
	public ClientStreamMap() {
		
	}
	
	public ClientStreamMap(String nomeCompleto, Integer eta, Double stipendio) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.eta = eta;
		this.stipendio = stipendio;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Integer getEta() {
		return eta;
	}

	public void setEta(Integer eta) {
		this.eta = eta;
	}

	public Double getStipendio() {
		return stipendio;
	}

	public void setStipendio(Double stipendio) {
		this.stipendio = stipendio;
	}

	@Override
	public String toString() {
		return "ClientStreamMap [nomeCompleto=" + nomeCompleto + ", eta=" + eta + ", stipendio=" + stipendio + "]";
	}
	
}

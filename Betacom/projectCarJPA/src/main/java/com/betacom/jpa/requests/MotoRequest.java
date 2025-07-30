package com.betacom.jpa.requests;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MotoRequest {

	private String alimentazione;
	private String categoria;
	private String marca;
	private String modello;
	private String colore;
	private Integer numeroRuote;
	private String sospensione;
	
	private String targa;
	private Integer cc;
	
	private Integer annoProduzione;
	
}

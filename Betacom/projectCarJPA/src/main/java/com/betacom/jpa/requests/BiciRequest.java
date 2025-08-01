package com.betacom.jpa.requests;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BiciRequest {

	private Integer id_bici;
	private String alimentazione;
	private String categoria;
	private String marca;
	private String modello;
	private String colore;
	private Integer numeroRuote;
	private String sospensione;

	private Integer numeroMarce;
	private Boolean pieghevole;
	
	private Integer annoProduzione; 

}


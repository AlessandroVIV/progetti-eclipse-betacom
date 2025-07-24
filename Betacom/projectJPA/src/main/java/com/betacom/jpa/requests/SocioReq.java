package com.betacom.jpa.requests;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SocioReq {

	private Integer id;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String email;

}

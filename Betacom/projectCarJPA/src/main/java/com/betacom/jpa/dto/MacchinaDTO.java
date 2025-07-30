package com.betacom.jpa.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MacchinaDTO {

	private Integer idMacchina;
	private Integer numeroPorte;
	private String targa;
	private Integer cc;
	
	private VeicoloDTO veicolo;
	
}

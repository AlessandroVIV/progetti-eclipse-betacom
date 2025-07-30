package com.betacom.jpa.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MotoDTO {

	private Integer idMoto;
	private String targa;
	private Integer cc;
	
	private Integer idVeicolo;
	
}

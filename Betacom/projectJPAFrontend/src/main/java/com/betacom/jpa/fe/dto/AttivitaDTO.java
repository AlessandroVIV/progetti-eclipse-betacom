package com.betacom.jpa.fe.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AttivitaDTO {

	private Integer id;
	private String descrizione;
	private BigDecimal prezzo;
	
}

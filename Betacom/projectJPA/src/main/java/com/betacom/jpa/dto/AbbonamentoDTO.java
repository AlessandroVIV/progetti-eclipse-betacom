package com.betacom.jpa.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AbbonamentoDTO {

	private Integer id;
	private LocalDate dataIscrizione;
	
}

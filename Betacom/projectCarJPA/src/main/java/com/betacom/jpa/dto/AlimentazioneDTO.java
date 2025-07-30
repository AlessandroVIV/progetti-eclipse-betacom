package com.betacom.jpa.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AlimentazioneDTO {

	private Integer id;
	private String tipoAlimentazione;
	
}

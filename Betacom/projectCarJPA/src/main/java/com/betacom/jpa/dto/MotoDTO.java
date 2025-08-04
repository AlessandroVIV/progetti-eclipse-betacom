package com.betacom.jpa.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class MotoDTO {

	private Integer idMoto;
	private String targa;
	private Integer cc;
	
	private VeicoloDTO veicoloDTO;
	
}

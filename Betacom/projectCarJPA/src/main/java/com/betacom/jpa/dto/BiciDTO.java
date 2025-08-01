package com.betacom.jpa.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BiciDTO {

	private Integer idBici;
	private Integer numeroMarce;
	private Boolean pieghevole;

	private VeicoloDTO veicoloDTO;
	
}

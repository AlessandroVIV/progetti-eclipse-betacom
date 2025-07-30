package com.betacom.jpa.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class VeicoloDTO {
	
    private Integer idVeicolo;
    private Integer annoProduzione;

    private String alimentazione;
    private String categoria;
    private String marca;
    private String modello;
    private String colore;
    private String sospensione;
    private Integer numeroRuote;
    
}


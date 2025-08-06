package com.betacom.jpa.fe.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RicevutaDTO {
    private String nome;
    private String cognome;
    private List<String> attivita;
    private double totale;
    
}

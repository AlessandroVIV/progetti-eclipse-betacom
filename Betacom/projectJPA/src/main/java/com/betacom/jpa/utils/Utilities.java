package com.betacom.jpa.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.betacom.jpa.dto.AbbonamentoDTO;
import com.betacom.jpa.dto.AttivitaDTO;
import com.betacom.jpa.dto.CertificatoDTO;
import com.betacom.jpa.dto.SocioDTO;
import com.betacom.jpa.models.Abbonamento;
import com.betacom.jpa.models.Attivita;
import com.betacom.jpa.models.Socio;

public class Utilities {

    public static List<AbbonamentoDTO> buildAbbonamentoDTO(List<Abbonamento> ab) {
        return ab.stream()
            .map(a -> AbbonamentoDTO.builder()
                .id(a.getId())
                .dataIscrizione(a.getDataIscrizione())
                .attivita(buildAttivita(a.getAttivita()))
                .build())
            .collect(Collectors.toList());
    }

    public static List<AttivitaDTO> buildAttivita(List<Attivita> at) {
        return at.stream()
            .map(a -> AttivitaDTO.builder()
                .id(a.getId())
                .descrizione(a.getDescrizione())
                .prezzo(a.getPrezzo())
                .build())
            .collect(Collectors.toList());
    }
    
    public static List<SocioDTO> buildListSocioDTO(List<Socio> ls) {
        return ls.stream()
            .map(s -> SocioDTO.builder()
                .codiceFiscale(s.getCodiceFiscale())
                .id(s.getId())
                .cognome(s.getCognome())
                .nome(s.getNome())
                .email(s.getEmail())
                .certificato((s.getCertificato() == null) ? null : CertificatoDTO.builder()
                    .id(s.getCertificato().getId())
                    .tipo(s.getCertificato().getTipo())
                    .dataCertificato(s.getCertificato().getDataCertificato())
                    .build())
                .abbonamento(Utilities.buildAbbonamentoDTO(s.getAbbonamento()))
                .build())
            .collect(Collectors.toList());
    }


    
}

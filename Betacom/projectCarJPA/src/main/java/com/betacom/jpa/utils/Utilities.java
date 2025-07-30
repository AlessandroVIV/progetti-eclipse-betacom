package com.betacom.jpa.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.betacom.jpa.dto.VeicoloDTO;
import com.betacom.jpa.models.Veicolo;

public class Utilities {

	public static List<VeicoloDTO> buildListVeicoloDTO(List<Veicolo> lista) {
	    return lista.stream()
	        .map((Veicolo v) -> VeicoloDTO.builder()
	            .idVeicolo(v.getId_veicolo())
	            .annoProduzione(v.getAnnoProduzione())
	            .alimentazione(v.getAlimentazione() != null ? v.getAlimentazione().getTipoAlimentazione() : null)
	            .categoria(v.getCategoria() != null ? v.getCategoria().getCategoria() : null)
	            .marca(v.getMarca() != null ? v.getMarca().getMarca() : null)
	            .modello(v.getModello() != null ? v.getModello().getModello() : null)
	            .colore(v.getColore() != null ? v.getColore().getColore() : null)
	            .sospensione(v.getSospensione() != null ? v.getSospensione().getTipoSospensione() : null)
	            .numeroRuote(v.getNumeroRuote() != null ? v.getNumeroRuote().getNumeroRuote() : null)
	            .build()
	        )
	        .collect(Collectors.toList());
	}



	
}

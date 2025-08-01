package com.betacom.jpa.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.betacom.jpa.dto.BiciDTO;
import com.betacom.jpa.dto.MacchinaDTO;
import com.betacom.jpa.dto.MotoDTO;
import com.betacom.jpa.dto.VeicoloDTO;
import com.betacom.jpa.models.Bici;
import com.betacom.jpa.models.Macchina;
import com.betacom.jpa.models.Moto;
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

	public static VeicoloDTO buildVeicoloDTO(Veicolo v) {
	    return VeicoloDTO.builder()
	        .idVeicolo(v.getId_veicolo())
	        .annoProduzione(v.getAnnoProduzione())
	        .alimentazione(v.getAlimentazione() != null ? v.getAlimentazione().getTipoAlimentazione() : null)
	        .categoria(v.getCategoria() != null ? v.getCategoria().getCategoria() : null)
	        .marca(v.getMarca() != null ? v.getMarca().getMarca() : null)
	        .modello(v.getModello() != null ? v.getModello().getModello() : null)
	        .colore(v.getColore() != null ? v.getColore().getColore() : null)
	        .sospensione(v.getSospensione() != null ? v.getSospensione().getTipoSospensione() : null)
	        .numeroRuote(v.getNumeroRuote() != null ? v.getNumeroRuote().getNumeroRuote() : null)
	        .build();
	}

	public static List<MacchinaDTO> buildListMacchinaDTO(List<Macchina> lista) {
	    return lista.stream()
	        .map(m -> MacchinaDTO.builder()
	            .idMacchina(m.getId_macchina())
	            .numeroPorte(m.getNumeroPorte())
	            .targa(m.getTarga())
	            .cc(m.getCc())
	            .veicolo(buildVeicoloDTO(m.getVeicolo())) 
	            .build())
	        .collect(Collectors.toList());
	}

	public static List<MotoDTO> buildListMotoDTO(List<Moto> lista) {
	    return lista.stream()
	        .map(m -> MotoDTO.builder()
	            .idMoto(m.getId_moto())
	            .targa(m.getTarga())
	            .cc(m.getCc())
	            .veicoloDTO(buildVeicoloDTO(m.getVeicolo())) 
	            .build())
	        .collect(Collectors.toList());
	}

	public static List<BiciDTO> buildBiciDTO(List<Bici> lista) {
	    return lista.stream()
	        .map(b -> BiciDTO.builder()
	            .idBici(b.getId_bici())
	            .numeroMarce(b.getNumeroMarce())
	            .pieghevole(b.getPieghevole())
	            .veicoloDTO(buildVeicoloDTO(b.getVeicolo())) 
	            .build())
	        .collect(Collectors.toList());
	}

}

package com.betacom.car.process;

import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;

import com.betacom.car.Models.Veicolo;
import com.betacom.car.exception.AcademyException;
import com.betacom.car.singletone.ValidaParametri;

public class VeicoloControl {

	public Veicolo verify(Veicolo vei, String[] params) throws AcademyException{
			
	 	/*	params[0] = tipoVeicolo
			params[1] = numeroRuote
			params[2] = alimentazione
			params[3] = categoria
			params[4] = colore
			params[5] = marca
			params[6] = annoProduzione
			params[7] = modello
		*/
		
		ValidaParametri val = ValidaParametri.getInstance();
		
        // Tipo veicolo
        if (!val.isTipoValido(params[0])) {
            throw new AcademyException("Tipo veicolo non valido");
        }
        vei.setTipoVeicolo(params[0]);

        // Numero ruote
        int ruote;
        
        try {
            ruote = Integer.parseInt(params[1]);
        } catch (Exception e) {
            throw new AcademyException("Numero ruote non numerico");
        }
        if (!val.isRuotaValida(ruote)) {
            throw new AcademyException("Numero ruote non valido");
        }
        vei.setNumeroRuote(ruote);

        // Tipo alimentazione
        if (!val.isAlimentazioneValida(params[2])) {
            throw new AcademyException("Tipo alimentazione non valido");
        }
        vei.setTipoAlimentazione(params[2]);

        // Categoria
        if (!val.isCategoriaValida(params[3])) {
            throw new AcademyException("Categoria non valida");
        }
        vei.setCategoria(params[3]);

        // Colore
        if (!val.isColoreValido(params[4])) {
            throw new AcademyException("Colore non valido");
        }
        vei.setColore(params[4]);

        // Marca
        if (!val.isMarcaValida(params[5])) {
            throw new AcademyException("Marca non valida");
        }
        vei.setMarca(params[5]);

        // Anno produzione
        int anno;
        
        try {
            anno = Integer.parseInt(params[6]);
        } catch (Exception e) {
            throw new AcademyException("Anno di produzione non numerico");
        }
        if (!val.isAnnoValido(anno)) {
            throw new AcademyException("Anno di produzione non valido");
        }
        vei.setAnnoProduzione(anno);

        // Modello
        if (!val.isModelloValido(params[7])) {
            throw new AcademyException("Modello non valido");
        }
        vei.setModello(params[7]);

		return vei;
		
	}
	
	public Veicolo verify(Veicolo vei) throws AcademyException {
		ValidaParametri val = ValidaParametri.getInstance();

		if (!val.isTipoValido(vei.getTipoVeicolo())) {
			throw new AcademyException("Tipo veicolo non valido");
		}
		if (!val.isRuotaValida(vei.getNumeroRuote())) {
			throw new AcademyException("Numero ruote non valido");
		}
		if (!val.isAlimentazioneValida(vei.getTipoAlimentazione())) {
			throw new AcademyException("Tipo alimentazione non valido");
		}
		if (!val.isCategoriaValida(vei.getCategoria())) {
			throw new AcademyException("Categoria non valida");
		}
		if (!val.isColoreValido(vei.getColore())) {
			throw new AcademyException("Colore non valido");
		}
		if (!val.isMarcaValida(vei.getMarca())) {
			throw new AcademyException("Marca non valida");
		}
		if (!val.isAnnoValido(vei.getAnnoProduzione())) {
			throw new AcademyException("Anno produzione non valido");
		}
		if (!val.isModelloValido(vei.getModello())) {
			throw new AcademyException("Modello non valido");
		}

		return vei;
	}

	
}
package com.betacom.jpa.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.models.Alimentazione;
import com.betacom.jpa.repositories.IAlimentazioneRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class AlimentazioneImpl {

    @Autowired
    private IAlimentazioneRepository alimentazioneRepository;

    public Alimentazione insertAlimentazione(String alimentazione) {
    	Alimentazione a = new Alimentazione();
    	a.setTipoAlimentazione(alimentazione);
    	return alimentazioneRepository.save(a);
    }
    
}

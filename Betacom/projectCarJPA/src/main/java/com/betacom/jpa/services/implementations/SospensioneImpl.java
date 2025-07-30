package com.betacom.jpa.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.models.Sospensione;
import com.betacom.jpa.repositories.ISospensioneRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class SospensioneImpl {

	@Autowired
	ISospensioneRepository sospensioneRepository;
	
	public Sospensione insertSospensione(String sospensione) {
		Sospensione s = new Sospensione();
		s.setTipoSospensione(sospensione);
		return sospensioneRepository.save(s);
	}
	
}

package com.betacom.jpa.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.models.NumeroRuote;
import com.betacom.jpa.repositories.INumeroRuoteRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class NumeroRuoteImpl {

	@Autowired
	private INumeroRuoteRepository numeroRuoteRepository;
	
	public NumeroRuote insertNumeroRuote(Integer numeroRuote) {
		NumeroRuote n = new NumeroRuote();
		n.setNumeroRuote(numeroRuote);
		return numeroRuoteRepository.save(n);
	}
	
}

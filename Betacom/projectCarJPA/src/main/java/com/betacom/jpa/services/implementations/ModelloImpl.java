package com.betacom.jpa.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.models.Modello;
import com.betacom.jpa.repositories.IModelloRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ModelloImpl {

	@Autowired
	private IModelloRepository modelloRepository;
	
	public Modello insertModello(String modello) {
		Modello m = new Modello();
		m.setModello(modello);
		return modelloRepository.save(m);
	}
	
}

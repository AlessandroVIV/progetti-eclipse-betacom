package com.betacom.jpa.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.models.Marca;
import com.betacom.jpa.repositories.IMarcaRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class MarcaImpl {

	@Autowired
	private IMarcaRepository marcaRepository;
	
	public Marca insertMarca(String marca) {
		Marca m = new Marca();
		m.setMarca(marca);
		return marcaRepository.save(m);
	}
	
}

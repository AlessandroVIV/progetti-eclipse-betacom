package com.betacom.jpa.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.models.Categoria;
import com.betacom.jpa.repositories.ICategoriaRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CategoriaImpl {

	@Autowired
	private ICategoriaRepository categoriaRepository;
	
    public Categoria insertCategoria(String categoria) {
        Categoria c = new Categoria();
        c.setCategoria(categoria);
        return categoriaRepository.save(c);
    }
	
}

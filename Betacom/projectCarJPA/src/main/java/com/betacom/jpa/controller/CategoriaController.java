package com.betacom.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.models.Categoria;
import com.betacom.jpa.services.implementations.CategoriaImpl;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaImpl categoriaImpl;
	
    @PostMapping
    public ResponseEntity<Categoria> insertColore(@RequestParam String categoria) {
        Categoria c = categoriaImpl.insertCategoria(categoria);
        return ResponseEntity.ok(c);
    }
}

package com.betacom.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.models.Marca;
import com.betacom.jpa.services.implementations.MarcaImpl;

@RestController
@RequestMapping("/marca")
public class MarcaController {

	@Autowired
	MarcaImpl marcaImpl;
	
	@PostMapping
	public ResponseEntity<Marca> insertMarca(@RequestParam String marca){
		Marca m = marcaImpl.insertMarca(marca);
		return ResponseEntity.ok(m);
	}
	
}

package com.betacom.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.models.Sospensione;
import com.betacom.jpa.services.implementations.SospensioneImpl;

@RestController
@RequestMapping("/sospensione")
public class SospensioneController {

	@Autowired
	SospensioneImpl sospensioneImpl;
	
	@PostMapping
	public ResponseEntity<Sospensione> insertSospensione(@RequestParam String sospensione){
		Sospensione s = sospensioneImpl.insertSospensione(sospensione);
		return ResponseEntity.ok(s);
	}
	
}

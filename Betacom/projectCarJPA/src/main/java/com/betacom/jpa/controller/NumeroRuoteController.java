package com.betacom.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.models.NumeroRuote;
import com.betacom.jpa.services.implementations.NumeroRuoteImpl;

@RestController
@RequestMapping("/numeroRuote")
public class NumeroRuoteController {

	@Autowired
	NumeroRuoteImpl numeroRuoteImpl;

	@PostMapping
	public ResponseEntity<NumeroRuote> insertNumeroRuote(@RequestParam Integer numeroRuote){
		NumeroRuote n = numeroRuoteImpl.insertNumeroRuote(numeroRuote);
		return ResponseEntity.ok(n);
	}
	
}

package com.betacom.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.models.Alimentazione;
import com.betacom.jpa.services.implementations.AlimentazioneImpl;

@RestController
@RequestMapping("/alimentazione")
public class AlimentazioneController {

	@Autowired
	private AlimentazioneImpl alimentazioneImpl;
	
	@PostMapping
	public ResponseEntity<Alimentazione> insertAlimentazione(@RequestParam String alimentazione){
		Alimentazione a = alimentazioneImpl.insertAlimentazione(alimentazione);
		return ResponseEntity.ok(a);
		
	}
	
}

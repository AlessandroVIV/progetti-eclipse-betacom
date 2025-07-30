package com.betacom.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.models.Modello;
import com.betacom.jpa.services.implementations.ModelloImpl;

@RestController
@RequestMapping("/modello")
public class ModelloController {

	@Autowired
	private ModelloImpl modelloImpl;
	
	@PostMapping
	public ResponseEntity<Modello> insertModello(@RequestParam String modello){
		Modello m = modelloImpl.insertModello(modello);
		return ResponseEntity.ok(m);
	}
	
}

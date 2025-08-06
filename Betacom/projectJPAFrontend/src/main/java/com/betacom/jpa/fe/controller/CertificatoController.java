package com.betacom.jpa.fe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class CertificatoController {

	@Autowired
	private WebClient clientWeb;
	
	@GetMapping("listCertificato")
	public ModelAndView listCertificato(@RequestParam Integer id) {
		
		log.debug("listCertificato id: " + id);
		
		ModelAndView mav = new ModelAndView("listCertificato");
		
		
		
		return mav;
		
		
		
	}
	
}

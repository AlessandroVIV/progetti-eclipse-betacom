package com.betacom.jpa.fe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.ModelAndView;

import com.betacom.jpa.fe.dto.SocioDTO;
import com.betacom.jpa.fe.response.ResponseObject;

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

	    SocioDTO socio = clientWeb.get()
	        .uri(uriBuilder -> uriBuilder
	            .path("socio/getSocioById")
	            .queryParam("id", id)
	            .build())
	        .retrieve()
	        .bodyToMono(new ParameterizedTypeReference<ResponseObject<SocioDTO>>() {})
	        .block()
	        .getDati();

	    mav.addObject("certificato", socio.getCertificato());
	    
	    return mav;
	    
	}

}

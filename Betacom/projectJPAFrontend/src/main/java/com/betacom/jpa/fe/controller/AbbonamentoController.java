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
public class AbbonamentoController {

	@Autowired
	private WebClient clientWeb;
	
	@GetMapping("listAbbonamenti")
	public ModelAndView listAbbonamenti(@RequestParam Integer id) {
		
		log.debug("listAbbonamenti" + id);
		
		ModelAndView mav = new ModelAndView("listAbbonamenti");
		
		
		
		return mav;
		
	}
	
}

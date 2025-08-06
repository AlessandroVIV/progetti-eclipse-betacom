package com.betacom.jpa.fe.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.ModelAndView;

import com.betacom.jpa.fe.dto.SocioDTO;
import com.betacom.jpa.fe.requests.SocioReq;
import com.betacom.jpa.fe.response.ResponseBase;
import com.betacom.jpa.fe.response.ResponseList;
import com.betacom.jpa.fe.response.ResponseObject;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class SocioController {

	@Autowired
	private WebClient clientWeb;
	
	@GetMapping(value = {"/", "listSocio", "home"})
	public ModelAndView listSocio(
	        @RequestParam(required = false) Integer id, 
	        @RequestParam(required = false) String nome, 
	        @RequestParam(required = false) String cognome, 
	        @RequestParam(required = false) String attivita) {
	    
	    ModelAndView mav = new ModelAndView("listSocio");

	    ResponseList<?> lSoci = clientWeb.get()
	            .uri(UriBuilder -> UriBuilder
	                    .path("/socio/listByFilter")
	                    .queryParamIfPresent("id", Optional.ofNullable(id))
	                    .queryParamIfPresent("nome", Optional.ofNullable(nome))
	                    .queryParamIfPresent("cognome", Optional.ofNullable(cognome))
	                    .queryParamIfPresent("attivita", Optional.ofNullable(attivita))
	                    .build())
	            .retrieve()
	            .bodyToMono(ResponseList.class)
	            .block();
		
		log.debug("Response rc: " + lSoci.getRc());
		
		ResponseList<?> atti = clientWeb.get()
				.uri("/attivita/list")
				.retrieve()
				.bodyToMono(ResponseList.class)
				.block();
		
		log.debug("Response attività rc: " + atti.getRc());
		
		mav.addObject("listAttivita", atti);
		mav.addObject("param", new SocioReq());
		mav.addObject("listSocio", lSoci.getDati());
		
		return mav;
		
	}
	
	@GetMapping("createSocio")
	public ModelAndView createSocio() {
		
		ModelAndView mav = new ModelAndView("createSocio");
		
		SocioReq req = new SocioReq();
		
		req.setErrorMsg(null);
		
		mav.addObject("socio", req);		

		return mav;
		
	}
	
	@GetMapping("updateSocio")
	public ModelAndView updateSocio(@RequestParam(required = true) Integer id) {
	    log.debug("updateSocio: " + id);

	    SocioDTO resp = clientWeb.get()
	        .uri(uriBuilder -> uriBuilder
	            .path("socio/getSocioById")
	            .queryParam("id", id)
	            .build())
	        .retrieve()
	        .bodyToMono(new ParameterizedTypeReference<ResponseObject<SocioDTO>>() {})
	        .block()
	        .getDati();

	    log.debug("Response: " + resp.getCognome() + " " + resp.getNome());
	    
	    SocioReq s = SocioReq.builder()
	    		.id(resp.getId())
	    		.cognome(resp.getCognome())
	    		.nome(resp.getNome())
	    		.codiceFiscale(resp.getCodiceFiscale())
	    		.email(resp.getEmail())
	    		.errorMsg(null)
	    		.build();
	    
	    ModelAndView mav = new ModelAndView("createSocio");
	    
	    mav.addObject("socio", s);	

	    return mav;
	    
	}

	@PostMapping("saveSocio")
	public Object saveSocio(@ModelAttribute("socio") SocioReq req) {
		
		log.debug("saveSocio: " + req);
		
		String operation = (req.getId() == null) ? "create" : "update";
		
		ResponseBase r = null;
		
		String uri = "socio/create";
		
		if("create".equalsIgnoreCase(operation)) {
			
			r = clientWeb.post()
					.uri(uri)
					.contentType(MediaType.APPLICATION_JSON)
					.bodyValue(req)
					.retrieve()
					.bodyToMono(ResponseBase.class)
					.block();
			
		} else {
			
			r = clientWeb.post()
					.uri(uri)
					.contentType(MediaType.APPLICATION_JSON)
					.bodyValue(req)
					.retrieve()
					.bodyToMono(ResponseBase.class)
					.block();
			
		}
		
		log.debug(operation + " " + r.getRc());
		
		if(!r.getRc()) {
			
			ModelAndView mav = new ModelAndView("createSocio");
			
			req.setErrorMsg(r.getMsg());
			
			mav.addObject("socio", req);
			
			return mav;
			
		}
		
		return "redirect:/listSocio";	
		
	}
	
}

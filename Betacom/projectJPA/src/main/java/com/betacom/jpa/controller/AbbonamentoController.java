package com.betacom.jpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.AbbonamentoDTO;
import com.betacom.jpa.requests.AbbonamentoRequest;
import com.betacom.jpa.response.ResponseBase;
import com.betacom.jpa.response.ResponseObject;
import com.betacom.jpa.services.interfaces.IAbbonamentoServices;

@RestController
@RequestMapping("/rest/abbonamento")
public class AbbonamentoController {

	private IAbbonamentoServices abbonamentoServices;
	
	public AbbonamentoController(IAbbonamentoServices abbonamentoServices) {
		this.abbonamentoServices = abbonamentoServices;
	}

	@PostMapping("/create")
	public ResponseBase create(@RequestBody(required = true) AbbonamentoRequest req) {
		ResponseBase responseBase = new ResponseBase();
		try {
			abbonamentoServices.create(req);
			responseBase.setRc(true);
		} catch (Exception e) {
			responseBase.setRc(false);
			responseBase.setMsg(e.getMessage());
		}
		return responseBase;
	}
	
	@GetMapping("/getAbbonamentoById")
	public ResponseObject<AbbonamentoDTO> getAbbonamento(@RequestParam (required = true) Integer id){
		
		ResponseObject<AbbonamentoDTO> r = new ResponseObject<AbbonamentoDTO>();
		
		try {
			r.setDati(abbonamentoServices.getById(id));
			r.setRc(true);
		} catch (Exception e) {
			r.setRc(false);
			r.setMsg(e.getMessage());
		}
		
		return r;
		
	}
	
}

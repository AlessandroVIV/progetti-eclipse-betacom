package com.betacom.jpa.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.AbbonamentoDTO;
import com.betacom.jpa.dto.AttivitaDTO;
import com.betacom.jpa.requests.AttivitaRequest;
import com.betacom.jpa.response.ResponseBase;
import com.betacom.jpa.response.ResponseList;
import com.betacom.jpa.response.ResponseObject;
import com.betacom.jpa.services.interfaces.IAttivitaServices;

@RestController
@RequestMapping("/rest/attivita")
public class AttivitaController {

	private IAttivitaServices attivitaServices;

	public AttivitaController(IAttivitaServices attivitaServices) {
		this.attivitaServices = attivitaServices;
	}
	
	@GetMapping("/list")
	public ResponseList<AttivitaDTO> list() {
	    ResponseList<AttivitaDTO> r = new ResponseList<AttivitaDTO>();
	    try {
	        r.setDati(attivitaServices.list());
	        r.setRc(true);
	    } catch (Exception e) {
	        r.setRc(false);
	        r.setMsg(e.getMessage());
	    }
	    return r;
	}
	
	@PostMapping("/create")
	public ResponseBase create(@RequestBody(required = true) AttivitaRequest req) {
		ResponseBase responseBase = new ResponseBase();
		try {
			attivitaServices.create(req);
			responseBase.setRc(true);
		} catch (Exception e) {
			responseBase.setRc(false);
			responseBase.setMsg(e.getMessage());
		}
		return responseBase;
	}
	
	@PutMapping("/update")
	public ResponseBase update(@RequestBody(required = true) AttivitaRequest req) {
		ResponseBase responseBase = new ResponseBase();
		try {
			attivitaServices.update(req);
			responseBase.setRc(true);
		} catch (Exception e) {
			responseBase.setRc(false);
			responseBase.setMsg(e.getMessage());
		}
		return responseBase;
	}
	
	@DeleteMapping("/delete")
	public ResponseBase delete(@RequestBody(required = true) AttivitaRequest req) {
		ResponseBase responseBase = new ResponseBase();
		try {
			attivitaServices.delete(req);
			responseBase.setRc(true);
		} catch (Exception e) {
			responseBase.setRc(false);
			responseBase.setMsg(e.getMessage());
		}
		return responseBase;
	}

	@PutMapping("/createAttivitaAbbonamento")
	public ResponseBase createAttivitaAbbonamento(@RequestBody(required = true) AttivitaRequest req) {
		ResponseBase responseBase = new ResponseBase();
		try {
			attivitaServices.createAttivitaAbbonamento(req);
			responseBase.setRc(true);
		} catch (Exception e) {
			responseBase.setRc(false);
			responseBase.setMsg(e.getMessage());
		}
		return responseBase;
	}
	
	@DeleteMapping("/deleteAttivitaAbbonamento")
	public ResponseBase deleteAttivitaAbbonamento(@RequestBody(required = true) AttivitaRequest req) {
		
		ResponseObject<AbbonamentoDTO> r = new ResponseObject<AbbonamentoDTO>();
		
		try {
			attivitaServices.removeAttivitaAbbonamento(req);
			r.setRc(true);
		} catch (Exception e) {
			r.setRc(false);
			r.setMsg(e.getMessage());
		}
		
		return r;
	}
	
}

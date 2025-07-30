package com.betacom.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.requests.MotoRequest;
import com.betacom.jpa.response.ResponseBase;
import com.betacom.jpa.services.interfaces.IMotoServices;

@RestController
@RequestMapping("/moto")
public class MotoController {

	@Autowired
	private IMotoServices motoServices;
	
    @PostMapping("/create")
    public ResponseBase create(@RequestBody MotoRequest req) {
    	
        ResponseBase response = new ResponseBase();

        try {
            motoServices.create(req);
            response.setRc(true);
        } catch (AcademyException e) {
            response.setRc(false);
            response.setMsg(e.getMessage());
        } catch (Exception e) {
            response.setRc(false);
            response.setMsg("Errore interno: " + e.getMessage());
        }

        return response;
        
    }
	
}

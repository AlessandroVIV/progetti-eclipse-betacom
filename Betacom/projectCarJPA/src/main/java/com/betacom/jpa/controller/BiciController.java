package com.betacom.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.requests.BiciRequest;
import com.betacom.jpa.response.ResponseBase;
import com.betacom.jpa.services.interfaces.IBiciServices;

@RestController
@RequestMapping("/bici")
public class BiciController {

	@Autowired
	private IBiciServices biciServices;
	
    @PostMapping("/create")
    public ResponseBase create(@RequestBody BiciRequest req) {
    	
        ResponseBase response = new ResponseBase();

        try {
            biciServices.create(req);
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

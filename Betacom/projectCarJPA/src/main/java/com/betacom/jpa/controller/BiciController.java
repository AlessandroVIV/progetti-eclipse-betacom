package com.betacom.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.BiciDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.models.Bici;
import com.betacom.jpa.repositories.IBiciRepository;
import com.betacom.jpa.requests.BiciRequest;
import com.betacom.jpa.response.ResponseBase;
import com.betacom.jpa.services.interfaces.IBiciServices;
import com.betacom.jpa.utils.Utilities;

@RestController
@RequestMapping("/bici")
public class BiciController {

	@Autowired
	private IBiciServices biciServices;
	
	@Autowired
	private IBiciRepository biciRepository;
	
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
	
    @GetMapping("/list")
    public List<BiciDTO> getAllBiciDTO(){
    	List<Bici> bici = biciRepository.findAll();
    	return Utilities.buildBiciDTO(bici);
    }
    
    @DeleteMapping("/deleteById")
    public ResponseBase delete(@RequestParam("id") Integer idBici) {
    	
        ResponseBase response = new ResponseBase();

        try {
            BiciRequest req = new BiciRequest();
            req.setId_bici(idBici);
            biciServices.deleteByBiciId(req);
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

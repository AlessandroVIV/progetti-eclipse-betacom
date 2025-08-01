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

import com.betacom.jpa.dto.MotoDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.models.Moto;
import com.betacom.jpa.repositories.IMotoRepository;
import com.betacom.jpa.requests.MotoRequest;
import com.betacom.jpa.response.ResponseBase;
import com.betacom.jpa.services.interfaces.IMotoServices;
import com.betacom.jpa.utils.Utilities;

@RestController
@RequestMapping("/moto")
public class MotoController {

	@Autowired
	private IMotoServices motoServices;
	
	@Autowired
	private IMotoRepository motoRepository;
	
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
	
    @GetMapping("/list")
    public List<MotoDTO> getAllMotoDTO() {
        List<Moto> moto = motoRepository.findAll();
        return Utilities.buildListMotoDTO(moto);
    }
    
    @DeleteMapping("/deleteById")
    public ResponseBase delete(@RequestParam("id") Integer idMoto) {
    	
        ResponseBase response = new ResponseBase();

        try {
            MotoRequest req = new MotoRequest();
            req.setId_moto(idMoto);
            motoServices.deleteByMotoId(req);
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

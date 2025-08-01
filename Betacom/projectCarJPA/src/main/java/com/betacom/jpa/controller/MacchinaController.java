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

import com.betacom.jpa.dto.MacchinaDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.models.Macchina;
import com.betacom.jpa.repositories.IMacchinaRepository;
import com.betacom.jpa.requests.MacchinaRequest;
import com.betacom.jpa.response.ResponseBase;
import com.betacom.jpa.services.interfaces.IMacchinaServices;
import com.betacom.jpa.utils.Utilities;

@RestController
@RequestMapping("/macchina")
public class MacchinaController {

	@Autowired
	private IMacchinaServices macchinaServices;
	
	@Autowired
	private IMacchinaRepository macchinaRepository;
	
    @PostMapping("/create")
    public ResponseBase create(@RequestBody MacchinaRequest req) {
    	
        ResponseBase response = new ResponseBase();

        try {
            macchinaServices.create(req);
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
    public List<MacchinaDTO> getAllMacchinaDTO() {
        List<Macchina> Macchina = macchinaRepository.findAll();
        return Utilities.buildListMacchinaDTO(Macchina);
    }
	
    @DeleteMapping("/deleteById")
    public ResponseBase delete(@RequestParam("id") Integer idMacchina) {
    	
        ResponseBase response = new ResponseBase();

        try {
            MacchinaRequest req = new MacchinaRequest();
            req.setId_macchina(idMacchina);
            macchinaServices.deleteByMacchinaId(req);
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

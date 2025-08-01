package com.betacom.jpa.controller;

import com.betacom.jpa.dto.VeicoloDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.models.Veicolo;
import com.betacom.jpa.repositories.IVeicoloRepository;
import com.betacom.jpa.response.ResponseBase;
import com.betacom.jpa.services.interfaces.IVeicoloServices;
import com.betacom.jpa.utils.Utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veicolo")
public class VeicoloController {

    @Autowired
    private IVeicoloRepository veicoloRepository;
    
    @Autowired
    private IVeicoloServices veicoloServices;

    @GetMapping("/list")
    public List<VeicoloDTO> getAllVeicoliDTO() {
        List<Veicolo> veicoli = veicoloRepository.findAll();
        return Utilities.buildListVeicoloDTO(veicoli);
    }
    
    @DeleteMapping("/deleteById")
    public ResponseBase delete(@RequestParam("id") Integer idVeicolo) {
    	
        ResponseBase response = new ResponseBase();

        try {
            veicoloServices.deleteByVeicoloId(idVeicolo);
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

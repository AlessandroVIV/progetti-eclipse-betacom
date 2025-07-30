package com.betacom.jpa.controller;

import com.betacom.jpa.dto.VeicoloDTO;
import com.betacom.jpa.models.Veicolo;
import com.betacom.jpa.repositories.IVeicoloRepository;
import com.betacom.jpa.utils.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veicolo")
public class VeicoloController {

    @Autowired
    private IVeicoloRepository veicoloRepository;

    @GetMapping("/list")
    public List<VeicoloDTO> getAllVeicoliDTO() {
        List<Veicolo> veicoli = veicoloRepository.findAll();
        return Utilities.buildListVeicoloDTO(veicoli);
    }
}

package com.betacom.jpa.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.models.Colore;
import com.betacom.jpa.repositories.IColoreRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ColoreImpl {

    @Autowired
    private IColoreRepository coloreRepository;

    public Colore insertColore(String nomeColore) {
        Colore c = new Colore();
        c.setColore(nomeColore);
        return coloreRepository.save(c);
    }

}

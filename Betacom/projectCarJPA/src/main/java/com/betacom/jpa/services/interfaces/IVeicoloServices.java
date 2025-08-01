package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dto.VeicoloDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.models.Veicolo;
import com.betacom.jpa.requests.BiciRequest;
import com.betacom.jpa.requests.MacchinaRequest;
import com.betacom.jpa.requests.MotoRequest;

public interface IVeicoloServices {

	Veicolo createVeicolo(MacchinaRequest req) throws AcademyException;
	
	Veicolo createVeicolo(MotoRequest req) throws AcademyException;
	
	Veicolo createVeicolo(BiciRequest req) throws AcademyException;
	
	List<VeicoloDTO> findAll();

	void deleteByVeicoloId(Integer idVeicolo) throws AcademyException;
	
}

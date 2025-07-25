package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dto.AttivitaDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.requests.AttivitaRequest;

public interface IAttivitaServices {

	void create(AttivitaRequest req) throws AcademyException;
	void update(AttivitaRequest req) throws AcademyException;
	List<AttivitaDTO> list();
	void delete(AttivitaRequest req) throws AcademyException;
	
	// Gestione abbonamenti
	void createAttivitaAbbonamento(AttivitaRequest req) throws AcademyException;
	void removeAttivitaAbbonamento(AttivitaRequest req) throws AcademyException;
	
}

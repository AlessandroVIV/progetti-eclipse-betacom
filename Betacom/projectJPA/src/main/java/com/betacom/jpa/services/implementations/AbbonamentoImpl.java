package com.betacom.jpa.services.implementations;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.dto.AbbonamentoDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.models.Abbonamento;
import com.betacom.jpa.models.Socio;
import com.betacom.jpa.repositories.IAbbonamentoRepository;
import com.betacom.jpa.repositories.ISocioRepository;
import com.betacom.jpa.requests.AbbonamentoRequest;
import com.betacom.jpa.services.interfaces.IAbbonamentoServices;
import com.betacom.jpa.utils.Utilities;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class AbbonamentoImpl extends Utilities implements IAbbonamentoServices{

	private IAbbonamentoRepository abbonamentoRepository;
	private ISocioRepository socioRepository;
	
	public AbbonamentoImpl(IAbbonamentoRepository abbonamentoRepository, ISocioRepository socioRepository) {
		this.abbonamentoRepository = abbonamentoRepository;
		this.socioRepository = socioRepository;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	@Override
	public void create(AbbonamentoRequest req) throws AcademyException {

		log.debug("Abbonamento creato: " + req);
		
		Optional<Socio> s = socioRepository.findById(req.getSocioId());
		
		if(s.isEmpty()) throw new AcademyException("Socio non presente nel database: " + req.getSocioId());
		
		if(req.getDataIscrizione() == null) throw new AcademyException("Data iscrizione non presente: " + req.getSocioId());
		
		Abbonamento abbo = new Abbonamento();
		
		abbo.setDataIscrizione(req.getDataIscrizione());
		abbo.setSocio(s.get());
		
		abbonamentoRepository.save(abbo);
		
	}

	@Override
	public AbbonamentoDTO getById(Integer id) throws AcademyException {

		Optional<Abbonamento> abb = abbonamentoRepository.findById(id);
		
		if(abb.isEmpty()) throw new AcademyException("Abbonamento non presente nel database: " + id);
		
		Abbonamento a = abb.get();
		
		return AbbonamentoDTO.builder()                
				.id(a.getId())
                .dataIscrizione(a.getDataIscrizione())
                .attivita(buildAttivita(a.getAttivita()))
                .build();
		
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void remove(AbbonamentoRequest req) throws AcademyException {
		
	    Optional<Abbonamento> ab = abbonamentoRepository.findById(req.getId());
	    
	    if (ab.isEmpty()) throw new AcademyException("Abbonamento non presente id database: " + req.getId());
	
	    if (!ab.get().getAttivita().isEmpty()) {
	        ab.get().getAttivita().removeAll(ab.get().getAttivita());
	        abbonamentoRepository.save(ab.get());
	    }

	    abbonamentoRepository.delete(ab.get());
	    
	}
	
}

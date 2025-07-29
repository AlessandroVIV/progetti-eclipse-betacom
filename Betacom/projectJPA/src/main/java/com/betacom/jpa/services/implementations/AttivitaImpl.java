package com.betacom.jpa.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.dto.AttivitaDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.models.Abbonamento;
import com.betacom.jpa.models.Attivita;
import com.betacom.jpa.repositories.IAbbonamentoRepository;
import com.betacom.jpa.repositories.IAttivitaRepository;
import com.betacom.jpa.requests.AttivitaRequest;
import com.betacom.jpa.services.interfaces.IAttivitaServices;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class AttivitaImpl implements IAttivitaServices{
	
	@Autowired
	private IAbbonamentoRepository abbonamentoRepository;
	
	@Autowired
	private IAttivitaRepository attivitaRepository;

	@Override
	public void create(AttivitaRequest req) throws AcademyException {
		
	    log.debug("Create: " + req);

	    if (req.getDescrizione() == null) {
	        throw new AcademyException("Descrizione non presente");
	    }

	    Optional<Attivita> a = attivitaRepository.findByDescrizione(
	        req.getDescrizione().trim()
	    );

	    if (a.isPresent()) {
	        throw new AcademyException("Attività già presente in database: " + req.getDescrizione());
	    }

	    Attivita at = new Attivita();
	    at.setDescrizione(req.getDescrizione().trim());

	    if (req.getPrezzo() == null) {
	        throw new AcademyException("Prezzo non presente");
	    }

	    at.setPrezzo(req.getPrezzo());

	    attivitaRepository.save(at);
	}

	@Override
	public void update(AttivitaRequest req) throws AcademyException {
		
	    log.debug("update: " + req);

	    Optional<Attivita> a = attivitaRepository.findById(req.getId());

	    if (a.isEmpty()) {
	        throw new AcademyException("Attività non presente in database: " + req.getId());
	    }

	    if (req.getDescrizione() != null) {
	    	
	        Optional<Attivita> att = attivitaRepository.findByDescrizione(
	            req.getDescrizione().trim()
	        );

	        if (att.isPresent()) {
	            throw new AcademyException("Attività già presente in database: " + req.getDescrizione());
	        }

	        a.get().setDescrizione(req.getDescrizione().trim().toUpperCase());
	    }

	    if (req.getPrezzo() != null) {
	        a.get().setPrezzo(req.getPrezzo());
	    }

	    attivitaRepository.save(a.get());
	}

	@Override
	public void delete(AttivitaRequest req) throws AcademyException {

	    log.debug("delete: " + req);

	    Optional<Attivita> a = attivitaRepository.findById(req.getId());

	    if (a.isEmpty()) {
	        throw new AcademyException("Attività non presente in database: " + req.getId());
	    }

	    attivitaRepository.delete(a.get());
	}

	@Override
	public List<AttivitaDTO> list() {
		
	    List<Attivita> listaAttivita = attivitaRepository.findAll();

	    return listaAttivita.stream()
	        .map(att -> AttivitaDTO.builder()
	            .id(att.getId())
	            .descrizione(att.getDescrizione())
	            .prezzo(att.getPrezzo())
	            .build())
	        .toList(); 
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void createAttivitaAbbonamento(AttivitaRequest req) throws AcademyException {
		
		log.debug("CreateAttivitaAbbonamento " + req);
		
		Optional<Abbonamento> abb = abbonamentoRepository.findById(req.getAbbonamentiId());
		
		if(abb.isEmpty()) throw new AcademyException("Abbonamento non presente nel database: " + req.getAbbonamentiId());
		
		Optional<Attivita> att = attivitaRepository.findById(req.getId());
		
		if(att.isEmpty()) throw new AcademyException("Attività non presente nel database: " + req.getId());
		
		abb.get().getAttivita().add(att.get());
		
		abbonamentoRepository.save(abb.get());
		
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void removeAttivitaAbbonamento(AttivitaRequest req) throws AcademyException {

	    log.debug("remove attivitaAbbonamento " + req);

	    Optional<Abbonamento> abbOpt = abbonamentoRepository.findById(req.getAbbonamentiId());
	    
	    if (abbOpt.isEmpty()) throw new AcademyException("Abbonamento non presente nel database: " + req.getAbbonamentiId());
	    
	    Abbonamento abb = abbOpt.get();

	    Optional<Attivita> attOpt = attivitaRepository.findById(req.getId());
	    
	    if (attOpt.isEmpty()) throw new AcademyException("Attività non presente nel database: " + req.getId());
	    
	    Attivita attivita = attOpt.get();

	    abb.getAttivita().remove(attivita);
	    
	    attivita.getAbbonamento().remove(abb);

	    if (abb.getAttivita().isEmpty()) {
	        log.debug("Nessuna attività rimasta, elimino l'abbonamento con id: " + abb.getId());
	        abbonamentoRepository.delete(abb);
	    } else {
	        abbonamentoRepository.save(abb);
	    }
	    
	}

}

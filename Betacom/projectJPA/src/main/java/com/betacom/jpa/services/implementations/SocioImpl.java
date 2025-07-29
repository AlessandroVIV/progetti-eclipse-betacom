package com.betacom.jpa.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.dto.CertificatoDTO;
import com.betacom.jpa.dto.RicevutaDTO;
import com.betacom.jpa.dto.SocioDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.models.Socio;
import com.betacom.jpa.repositories.ISocioRepository;
import com.betacom.jpa.requests.SocioReq;
import com.betacom.jpa.services.interfaces.IMessaggioServices;
import com.betacom.jpa.services.interfaces.ISocioServices;
import com.betacom.jpa.utils.Utilities;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class SocioImpl extends Utilities implements ISocioServices {

	@Autowired
	private ISocioRepository socioRepository;
	
	@Autowired
	private IMessaggioServices messaggioServices;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer insert(SocioReq req) throws AcademyException {

		log.debug("Insert: " + req);

		System.out.println("Insert: " + req.toString());

		Socio soc = new Socio();

		Optional<Socio> s = socioRepository.findByCodiceFiscale(req.getCodiceFiscale());

		if (s.isPresent()) throw new AcademyException(messaggioServices.getMessaggio("socio-exist"));
		
		soc.setCodiceFiscale(req.getCodiceFiscale());
		
		if(req.getCognome() == null) throw new AcademyException("Cognome obbligatorio!");
		if(req.getNome() == null) throw new AcademyException("Nome obbligatorio!");

		soc.setCognome(req.getCognome());
		soc.setEmail(req.getEmail());
		soc.setNome(req.getNome());

		return socioRepository.save(soc).getId();

	}
	
	@Override
	public void update(SocioReq req) throws AcademyException {
		log.debug("Update: " + req);
		
		Optional<Socio> s = socioRepository.findById(req.getId());
		
		if(s.isEmpty()) throw new AcademyException("Socio non trovato nel database: " + req.getId());
		
		Socio socio = s.get();
		
		if(req.getNome() != null) {
			socio.setNome(req.getNome());
		}
		
		if(req.getCognome() != null) {
			socio.setCognome(req.getCognome());
		}
		
		if(req.getEmail() != null) {
			socio.setEmail(req.getEmail());
		}
		
		if(req.getCodiceFiscale() != null) {
			
			Optional<Socio> sCF = socioRepository.findByCodiceFiscale(req.getCodiceFiscale());
			
			if(sCF.isPresent()) throw new AcademyException("Codice fiscale presente nel database!");
			
			socio.setCodiceFiscale(req.getCodiceFiscale());
			
		}
		
		socioRepository.save(socio); // Eseguo l'update
		
	}

	@Override
	public void delete(SocioReq req) throws AcademyException {

		log.debug("delete :" + req);

		Optional<Socio> s = socioRepository.findById(req.getId());

		if (s.isEmpty()) throw new AcademyException("Socio non trovatoin database");

		socioRepository.delete(s.get());

	}

	@Override
	public List<SocioDTO> listAll() {
		
	    List<Socio> ls = socioRepository.findAll();
	    return buildListSocioDTO(ls);
	}

	@Override
	public SocioDTO getSocioById(Integer id) throws AcademyException {
	    log.debug("getSocio: " + id);

	    Optional<Socio> soc = socioRepository.findById(id);

	    if (soc.isEmpty()) {
	        throw new AcademyException("Socio non trovato in database: " + id);
	    }

	    Socio s = soc.get();

	    return SocioDTO.builder()
	        .codiceFiscale(s.getCodiceFiscale())
	        .id(s.getId())
	        .cognome(s.getCognome())
	        .nome(s.getNome())
	        .email(s.getEmail())
	        .certificato(
	            (s.getCertificato() == null) ? null :
	                CertificatoDTO.builder()
	                    .id(s.getCertificato().getId())
	                    .tipo(s.getCertificato().getTipo())
	                    .dataCertificato(s.getCertificato().getDataCertificato())
	                    .build()
	        )
	        .abbonamento(buildAbbonamentoDTO(s.getAbbonamento()))
	        .build();
	}

	@Override
	public List<SocioDTO> listByAttivita(String attivita) {
		
		log.debug("ListByAttività:" + attivita);

		List<Socio> lS = socioRepository.searchByAttivita(attivita);
		
		return buildListSocioDTO(lS);
		
	}

	@Override
	public List<SocioDTO> listByFilter(Integer id, String nome, String cognome, String attivita) {

		log.debug("ListByFilter: " + id, nome, cognome, attivita);
		
		List<Socio> soci = socioRepository.searchByFilter(id, nome, cognome, attivita);

		return buildListSocioDTO(soci);
		
	}
	
	@Override
	public List<RicevutaDTO> generaRicevute(Integer idAbbonamento) {
		
	    List<Socio> soci = socioRepository.findSociByIdAbbonamento(idAbbonamento);

	    return soci.stream().map(s -> {
	        List<String> descrizioni = s.getAbbonamento().stream()
	            .filter(abb -> idAbbonamento == null || abb.getId().equals(idAbbonamento))
	            .flatMap(abb -> abb.getAttivita().stream())
	            .map(att -> att.getDescrizione())
	            .toList();

	        double totale = s.getAbbonamento().stream()
	            .filter(abb -> idAbbonamento == null || abb.getId().equals(idAbbonamento))
	            .flatMap(abb -> abb.getAttivita().stream())
	            .mapToDouble(att -> att.getPrezzo().doubleValue())
	            .sum();

	        return RicevutaDTO.builder()
	            .nome(s.getNome())
	            .cognome(s.getCognome())
	            .attivita(descrizioni)
	            .totale(totale)
	            .build();
	    }).toList();
	}


}

package com.betacom.jpa.services.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.models.Macchina;
import com.betacom.jpa.models.Veicolo;
import com.betacom.jpa.repositories.IMacchinaRepository;
import com.betacom.jpa.requests.MacchinaRequest;
import com.betacom.jpa.services.interfaces.IMacchinaServices;
import com.betacom.jpa.services.interfaces.IVeicoloServices;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class MacchinaImpl implements IMacchinaServices{
	
	@Autowired
	private IVeicoloServices veicoloServices;

    @Autowired
    private IMacchinaRepository macchinaRepository;
    
    @Transactional(rollbackFor = Exception.class)
	@Override
	public void create(MacchinaRequest req) throws AcademyException {
    	
        if (req.getCc() == null || req.getCc() < 0) throw new AcademyException("Cilindrata non valida");
       
        if (req.getNumeroPorte() == null || req.getNumeroPorte() <= 0) throw new AcademyException("Numero porte non valido");

        if (req.getTarga() == null || req.getTarga().isBlank()) throw new AcademyException("Targa obbligatoria");
        
        Macchina macchina = new Macchina();

        macchina.setCc(req.getCc());
        macchina.setNumeroPorte(req.getNumeroPorte());
        macchina.setTarga(req.getTarga());

        Veicolo veicoloCreato = veicoloServices.createVeicolo(req);
        
        macchina.setVeicolo(veicoloCreato);

        macchinaRepository.save(macchina);
		
	}
    
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteByMacchinaId(MacchinaRequest req) throws AcademyException {

        if (req.getId_macchina() == null) throw new AcademyException("ID Macchina mancante");
  
        Optional<Macchina> macchinaOpt = macchinaRepository.findById(req.getId_macchina());
        
        if (macchinaOpt.isEmpty()) throw new AcademyException("Macchina con ID " + req.getId_macchina() + " non trovata");

        macchinaRepository.delete(macchinaOpt.get());
        
    }

}

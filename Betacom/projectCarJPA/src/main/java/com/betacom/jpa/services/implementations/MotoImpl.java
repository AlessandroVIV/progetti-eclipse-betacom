package com.betacom.jpa.services.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.models.Moto;
import com.betacom.jpa.models.Veicolo;
import com.betacom.jpa.repositories.IMotoRepository;
import com.betacom.jpa.requests.MotoRequest;
import com.betacom.jpa.services.interfaces.IMotoServices;
import com.betacom.jpa.services.interfaces.IVeicoloServices;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class MotoImpl implements IMotoServices{
	
	@Autowired
	private IVeicoloServices veicoloServices;

    @Autowired
    private IMotoRepository motoRepository;
    
    @Transactional(rollbackFor = Exception.class)
	@Override
	public void create(MotoRequest req) throws AcademyException {
    	
        if (req.getCc() == null || req.getCc() < 0) throw new AcademyException("Cilindrata non valida");

        if (req.getTarga() == null || req.getTarga().isBlank()) throw new AcademyException("Targa obbligatoria");
        
        Moto moto = new Moto();
        
        moto.setCc(req.getCc());
        moto.setTarga(req.getTarga());

        Veicolo veicoloCreato = veicoloServices.createVeicolo(req);
        
        moto.setVeicolo(veicoloCreato);

        motoRepository.save(moto);
		
	}

    @Transactional(rollbackFor = Exception.class)
	@Override
	public void deleteByMotoId(MotoRequest req) throws AcademyException {
		
        if (req.getId_moto() == null) throw new AcademyException("ID Moto mancante");
        
        Optional<Moto> motoOpt = motoRepository.findById(req.getId_moto());
        
        if (motoOpt.isEmpty()) throw new AcademyException("Moto con ID " + req.getId_moto() + " non trovata");

        motoRepository.delete(motoOpt.get());
		
	}

}

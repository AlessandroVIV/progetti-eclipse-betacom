package com.betacom.jpa.services.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.models.Bici;
import com.betacom.jpa.models.Veicolo;
import com.betacom.jpa.repositories.IBiciRepository;
import com.betacom.jpa.requests.BiciRequest;
import com.betacom.jpa.services.interfaces.IBiciServices;
import com.betacom.jpa.services.interfaces.IVeicoloServices;

@Service
public class BiciImpl implements IBiciServices{

	@Autowired
	private IVeicoloServices veicoloServices;

    @Autowired
    private IBiciRepository biciRepository;
    
    @Transactional(rollbackFor = Exception.class)
	@Override
	public void create(BiciRequest req) throws AcademyException {
    	
        if (req.getNumeroMarce() == null || req.getNumeroMarce() < 0) throw new AcademyException("NumeroMarce non valido");

        if (req.getPieghevole() == null) throw new AcademyException("Pieghevole obbligatorio");
        
        Bici bici = new Bici();
        
        bici.setNumeroMarce(req.getNumeroMarce());
        bici.setPieghevole(req.getPieghevole());
        
        Veicolo veicoloCreato = veicoloServices.createVeicolo(req);
        
        bici.setSospensione(veicoloCreato.getSospensione());
        
        bici.setVeicolo(veicoloCreato);

        biciRepository.save(bici);
		
	}

    @Transactional(rollbackFor = Exception.class)
	@Override
	public void deleteByBiciId(BiciRequest req) throws AcademyException {
		
        if (req.getId_bici() == null) throw new AcademyException("ID Bici mancante");
        
        Optional<Bici> BiciOpt = biciRepository.findById(req.getId_bici());
        
        if (BiciOpt.isEmpty()) throw new AcademyException("Macchina con ID " + req.getId_bici() + " non trovata");

        biciRepository.delete(BiciOpt.get());
		
	}

}

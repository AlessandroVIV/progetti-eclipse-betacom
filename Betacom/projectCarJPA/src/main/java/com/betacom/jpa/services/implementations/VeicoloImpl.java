package com.betacom.jpa.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.dto.VeicoloDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.models.Alimentazione;
import com.betacom.jpa.models.Categoria;
import com.betacom.jpa.models.Colore;
import com.betacom.jpa.models.Marca;
import com.betacom.jpa.models.Modello;
import com.betacom.jpa.models.NumeroRuote;
import com.betacom.jpa.models.Sospensione;
import com.betacom.jpa.models.Veicolo;
import com.betacom.jpa.repositories.IAlimentazioneRepository;
import com.betacom.jpa.repositories.IBiciRepository;
import com.betacom.jpa.repositories.ICategoriaRepository;
import com.betacom.jpa.repositories.IColoreRepository;
import com.betacom.jpa.repositories.IMacchinaRepository;
import com.betacom.jpa.repositories.IMarcaRepository;
import com.betacom.jpa.repositories.IModelloRepository;
import com.betacom.jpa.repositories.IMotoRepository;
import com.betacom.jpa.repositories.INumeroRuoteRepository;
import com.betacom.jpa.repositories.ISospensioneRepository;
import com.betacom.jpa.repositories.IVeicoloRepository;
import com.betacom.jpa.requests.BiciRequest;
import com.betacom.jpa.requests.MacchinaRequest;
import com.betacom.jpa.requests.MotoRequest;
import com.betacom.jpa.services.interfaces.IVeicoloServices;
import com.betacom.jpa.utils.Utilities;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class VeicoloImpl implements IVeicoloServices{

	@Autowired
	IVeicoloRepository veicoloRepository;

	@Autowired
	IMotoRepository motoRepository;
	
	@Autowired
	IMacchinaRepository macchinaRepository;
	
	@Autowired
	IBiciRepository biciRepository;
	
    @Autowired
    private IAlimentazioneRepository alimentazioneRepository;
    
    @Autowired
    private ICategoriaRepository categoriaRepository;
    
    @Autowired
    private IMarcaRepository marcaRepository;
    
    @Autowired
    private IModelloRepository modelloRepository;
    
    @Autowired
    private INumeroRuoteRepository numeroRuoteRepository;
    
    @Autowired
    private IColoreRepository coloreRepository;
    
    @Autowired
    private ISospensioneRepository sospensioneRepository;
	
    @Transactional(rollbackFor = Exception.class)
    public Veicolo createVeicolo(MacchinaRequest req) throws AcademyException {

        Veicolo v = new Veicolo();

        v.setAnnoProduzione(req.getAnnoProduzione());

        Optional<Modello> modelloOpt = modelloRepository.findByModello(req.getModello());
        
        if (!modelloOpt.isPresent()) {
            throw new AcademyException("Modello non trovato");
        }
        
        v.setModello(modelloOpt.get());

        Optional<Marca> marcaOpt = marcaRepository.findByMarca(req.getMarca());
        
        if (!marcaOpt.isPresent()) {
            throw new AcademyException("Marca non trovata");
        }
        
        v.setMarca(marcaOpt.get());

        Optional<Categoria> categoriaOpt = categoriaRepository.findByCategoria(req.getCategoria());
        
        if (!categoriaOpt.isPresent()) {
            throw new AcademyException("Categoria non trovata");
        }
        
        v.setCategoria(categoriaOpt.get());

        Optional<Alimentazione> alimentazioneOpt = alimentazioneRepository.findByTipoAlimentazione(req.getAlimentazione());
        
        if (!alimentazioneOpt.isPresent()) {
            throw new AcademyException("Alimentazione non trovata");
        }
        
        v.setAlimentazione(alimentazioneOpt.get());

        Optional<NumeroRuote> ruoteOpt = numeroRuoteRepository.findByNumeroRuote(req.getNumeroRuote());
        
        if (!ruoteOpt.isPresent()) {
            throw new AcademyException("Numero ruote non trovato");
        }
        
        v.setNumeroRuote(ruoteOpt.get());

        Optional<Colore> coloreOpt = coloreRepository.findByColore(req.getColore());
        
        if (!coloreOpt.isPresent()) {
            throw new AcademyException("Colore non trovato");
        }
        
        v.setColore(coloreOpt.get());
        
        Optional<Sospensione> sospensioneOpt = sospensioneRepository.findByTipoSospensione(req.getSospensione());

        if (!sospensioneOpt.isPresent()) {
            throw new AcademyException("Sospensione non trovata");
        }

        v.setSospensione(sospensioneOpt.get());

        return veicoloRepository.save(v);
        
    }

    @Transactional(rollbackFor = Exception.class)
	@Override
	public Veicolo createVeicolo(MotoRequest req) throws AcademyException {
		
        Veicolo v = new Veicolo();

        v.setAnnoProduzione(req.getAnnoProduzione());

        Optional<Modello> modelloOpt = modelloRepository.findByModello(req.getModello());
        
        if (!modelloOpt.isPresent()) {
            throw new AcademyException("Modello non trovato");
        }
        
        v.setModello(modelloOpt.get());

        Optional<Marca> marcaOpt = marcaRepository.findByMarca(req.getMarca());
        
        if (!marcaOpt.isPresent()) {
            throw new AcademyException("Marca non trovata");
        }
        
        v.setMarca(marcaOpt.get());

        Optional<Categoria> categoriaOpt = categoriaRepository.findByCategoria(req.getCategoria());
        
        if (!categoriaOpt.isPresent()) {
            throw new AcademyException("Categoria non trovata");
        }
        
        v.setCategoria(categoriaOpt.get());

        Optional<Alimentazione> alimentazioneOpt = alimentazioneRepository.findByTipoAlimentazione(req.getAlimentazione());
        
        if (!alimentazioneOpt.isPresent()) {
            throw new AcademyException("Alimentazione non trovata");
        }
        
        v.setAlimentazione(alimentazioneOpt.get());

        Optional<NumeroRuote> ruoteOpt = numeroRuoteRepository.findByNumeroRuote(req.getNumeroRuote());
        
        if (!ruoteOpt.isPresent()) {
            throw new AcademyException("Numero ruote non trovato");
        }
        
        v.setNumeroRuote(ruoteOpt.get());

        Optional<Colore> coloreOpt = coloreRepository.findByColore(req.getColore());
        
        if (!coloreOpt.isPresent()) {
            throw new AcademyException("Colore non trovato");
        }
        
        v.setColore(coloreOpt.get());
        
        Optional<Sospensione> sospensioneOpt = sospensioneRepository.findByTipoSospensione(req.getSospensione());

        if (!sospensioneOpt.isPresent()) {
            throw new AcademyException("Sospensione non trovata");
        }

        v.setSospensione(sospensioneOpt.get());

        return veicoloRepository.save(v);
        
	}

    @Transactional(rollbackFor = Exception.class)
	@Override
	public Veicolo createVeicolo(BiciRequest req) throws AcademyException {
		
        Veicolo v = new Veicolo();

        v.setAnnoProduzione(req.getAnnoProduzione());

        Optional<Modello> modelloOpt = modelloRepository.findByModello(req.getModello());
        
        if (!modelloOpt.isPresent()) {
            throw new AcademyException("Modello non trovato");
        }
        
        v.setModello(modelloOpt.get());

        Optional<Marca> marcaOpt = marcaRepository.findByMarca(req.getMarca());
        
        if (!marcaOpt.isPresent()) {
            throw new AcademyException("Marca non trovata");
        }
        
        v.setMarca(marcaOpt.get());

        Optional<Categoria> categoriaOpt = categoriaRepository.findByCategoria(req.getCategoria());
        
        if (!categoriaOpt.isPresent()) {
            throw new AcademyException("Categoria non trovata");
        }
        
        v.setCategoria(categoriaOpt.get());

        Optional<Alimentazione> alimentazioneOpt = alimentazioneRepository.findByTipoAlimentazione(req.getAlimentazione());
        
        if (!alimentazioneOpt.isPresent()) {
            throw new AcademyException("Alimentazione non trovata");
        }
        
        v.setAlimentazione(alimentazioneOpt.get());

        Optional<NumeroRuote> ruoteOpt = numeroRuoteRepository.findByNumeroRuote(req.getNumeroRuote());
        
        if (!ruoteOpt.isPresent()) {
            throw new AcademyException("Numero ruote non trovato");
        }
        
        v.setNumeroRuote(ruoteOpt.get());

        Optional<Colore> coloreOpt = coloreRepository.findByColore(req.getColore());
        
        if (!coloreOpt.isPresent()) {
            throw new AcademyException("Colore non trovato");
        }
        
        v.setColore(coloreOpt.get());
        
        Optional<Sospensione> sospensioneOpt = sospensioneRepository.findByTipoSospensione(req.getSospensione());

        if (!sospensioneOpt.isPresent()) {
            throw new AcademyException("Sospensione non trovata");
        }

        v.setSospensione(sospensioneOpt.get());

        return veicoloRepository.save(v);
        
	}

	@Override
	public List<VeicoloDTO> findAll() {
	    List<Veicolo> ls = veicoloRepository.findAll();
	    return Utilities.buildListVeicoloDTO(ls);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void deleteByVeicoloId(Integer idVeicolo) throws AcademyException {
		
	    Optional<Veicolo> veicoloOpt = veicoloRepository.findById(idVeicolo);

	    if (veicoloOpt.isEmpty()) throw new AcademyException("Veicolo con ID " + idVeicolo + " non trovato");

	    Veicolo veicolo = veicoloOpt.get();

	    if (veicolo.getMacchina() != null) macchinaRepository.delete(veicolo.getMacchina());
	    
	    if (veicolo.getMoto() != null) motoRepository.delete(veicolo.getMoto());
	    
	    if (veicolo.getBici() != null) biciRepository.delete(veicolo.getBici());
	    
	    veicoloRepository.delete(veicolo);
	    
	}

}

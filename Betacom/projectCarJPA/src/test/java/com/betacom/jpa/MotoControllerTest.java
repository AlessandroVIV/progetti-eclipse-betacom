package com.betacom.jpa;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.betacom.jpa.controller.MotoController;
import com.betacom.jpa.dto.MotoDTO;
import com.betacom.jpa.models.Alimentazione;
import com.betacom.jpa.models.Categoria;
import com.betacom.jpa.models.Colore;
import com.betacom.jpa.models.Marca;
import com.betacom.jpa.models.Modello;
import com.betacom.jpa.models.NumeroRuote;
import com.betacom.jpa.models.Sospensione;
import com.betacom.jpa.repositories.IAlimentazioneRepository;
import com.betacom.jpa.repositories.ICategoriaRepository;
import com.betacom.jpa.repositories.IColoreRepository;
import com.betacom.jpa.repositories.IMarcaRepository;
import com.betacom.jpa.repositories.IModelloRepository;
import com.betacom.jpa.repositories.INumeroRuoteRepository;
import com.betacom.jpa.repositories.ISospensioneRepository;
import com.betacom.jpa.requests.MotoRequest;
import com.betacom.jpa.response.ResponseBase;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MotoControllerTest {

	@Autowired
	private MotoController motoController;
	
    @Autowired
    private IAlimentazioneRepository alimentazioneRepository;
    
    @Autowired
    private ICategoriaRepository categoriaRepository;
    
    @Autowired
    private IMarcaRepository marcaRepository;
    
    @Autowired
    private IModelloRepository modelloRepository;
    
    @Autowired
    private IColoreRepository coloreRepository;
    
    @Autowired
    private INumeroRuoteRepository numeroRuoteRepository;
    
    @Autowired
    private ISospensioneRepository sospensioneRepository;
	
	@BeforeEach
	public void setupMoto() {
		
	    Alimentazione a = new Alimentazione();
	    a.setTipoAlimentazione("benzina");
	    alimentazioneRepository.save(a);

	    Categoria c = new Categoria();
	    c.setCategoria("Fuoristrada");
	    categoriaRepository.save(c);

	    Marca m = new Marca();
	    m.setMarca("Yamaha");
	    marcaRepository.save(m);

	    Modello mo = new Modello();
	    mo.setModello("StreetRider 500");
	    modelloRepository.save(mo);

	    Colore co = new Colore();
	    co.setColore("Nero");
	    coloreRepository.save(co);

	    NumeroRuote nr = new NumeroRuote();
	    nr.setNumeroRuote(2);
	    numeroRuoteRepository.save(nr);

	    Sospensione s = new Sospensione();
	    s.setTipoSospensione("bi");
	    sospensioneRepository.save(s);
	    
	}

	@Test
	@Commit
	@Order(1)
	public void createMotoTest() {

	    log.debug("Test creazione moto");

	    MotoRequest req = new MotoRequest();
	    req.setAlimentazione("benzina");
	    req.setCategoria("Fuoristrada");
	    req.setMarca("Yamaha");
	    req.setModello("StreetRider 500");
	    req.setColore("Nero");
	    req.setNumeroRuote(2);
	    req.setSospensione("bi");
	    req.setTarga("YAM123MO");
	    req.setCc(500);
	    req.setAnnoProduzione(2020);

	    ResponseBase r = motoController.create(req);
	    Assertions.assertThat(r.getRc()).isEqualTo(true);
	    
	}

	
	@Test
	@Commit
	@Order(2)
	public void listMotoTest() {

	    log.debug("Test recupero lista moto");

	    List<MotoDTO> lista = motoController.getAllMotoDTO();

	    Assertions.assertThat(lista).isNotNull();
	    Assertions.assertThat(lista.size()).isGreaterThan(0);

	    log.debug("Moto trovate: " + lista.size());
	    lista.forEach(m -> log.debug(m.toString()));
	    
	}
	
	
}

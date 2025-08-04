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

import com.betacom.jpa.controller.MacchinaController;
import com.betacom.jpa.dto.MacchinaDTO;
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
import com.betacom.jpa.requests.MacchinaRequest;
import com.betacom.jpa.response.ResponseBase;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MacchinaControllerTest {

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

    @Autowired
    private MacchinaController macchinaController;
	
    @BeforeEach
    public void setup() {
    	
        Alimentazione a = new Alimentazione();
        a.setTipoAlimentazione("benzina");
        alimentazioneRepository.save(a);

        Categoria c = new Categoria();
        c.setCategoria("Strada");
        categoriaRepository.save(c);

        Marca m = new Marca();
        m.setMarca("Fiat");
        marcaRepository.save(m);

        Modello mo = new Modello();
        mo.setModello("Panda");
        modelloRepository.save(mo);

        Colore co = new Colore();
        co.setColore("Rosso");
        coloreRepository.save(co);

        NumeroRuote nr = new NumeroRuote();
        nr.setNumeroRuote(4);
        numeroRuoteRepository.save(nr);

        Sospensione s = new Sospensione();
        s.setTipoSospensione("senza");
        sospensioneRepository.save(s);
        
    }

	@Test
	@Commit
	@Order(1)
	public void createMacchinaTest() {

	    log.debug("Test creazione macchina");

	    MacchinaRequest req = new MacchinaRequest();
	    req.setAlimentazione("benzina");
	    req.setCategoria("Strada");
	    req.setMarca("Fiat");
	    req.setModello("Panda");
	    req.setColore("Rosso");
	    req.setNumeroRuote(4);
	    req.setSospensione("senza");
	    req.setCc(1200);
	    req.setNumeroPorte(5);
	    req.setTarga("ABC123ZZ");
	    req.setAnnoProduzione(2021);

	    ResponseBase r = macchinaController.create(req);
	    Assertions.assertThat(r.getRc()).isEqualTo(true);
	    
	}
	
	@Test
	@Commit
	@Order(2)
	public void listMacchineTest() {

	    log.debug("Test recupero lista macchine");

	    List<MacchinaDTO> lista = macchinaController.getAllMacchinaDTO();

	    Assertions.assertThat(lista).isNotNull();
	    Assertions.assertThat(lista.size()).isGreaterThan(0);

	    log.debug("Macchine trovate: " + lista.size());
	    lista.forEach(m -> log.debug(m.toString()));
	    
	}


	
}

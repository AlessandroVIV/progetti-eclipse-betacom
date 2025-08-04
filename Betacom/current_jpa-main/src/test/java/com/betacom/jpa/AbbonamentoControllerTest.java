package com.betacom.jpa;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.betacom.jpa.controller.AbbonamentoController;
import com.betacom.jpa.controller.AttivitaController;
import com.betacom.jpa.requests.AbbonamentoReq;
import com.betacom.jpa.requests.AttivitaReq;
import com.betacom.jpa.response.ResponseBase;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AbbonamentoControllerTest {

	@Autowired
	private AbbonamentoController abbonamentoController;
	
	@Autowired
	private AttivitaController attivitaController;
	
	@Test
	@Order(1)
	public void createAbbonamentoTest() {
		
		log.debug("Create Abbonamento Test");

		AbbonamentoReq req = new AbbonamentoReq();
		req.setDataIscrizione(LocalDate.now());
		req.setSocioId(1);
		
		ResponseBase r = abbonamentoController.create(req);
		Assertions.assertThat(r.getRc()).isEqualTo(true);
		
		req = new AbbonamentoReq();
		req.setDataIscrizione(LocalDate.now());
		req.setSocioId(2);		
		
		r = abbonamentoController.create(req);
		
	}
	
	@Test
	@Order(2)
	public void createAttivitaAbbonamentoTest() {
		
	    log.debug("Test create attività per un abbonamento");
	    
	    AttivitaReq req = new AttivitaReq();
	    req.setAbbonamentiId(1);
	    req.setId(2); 

	    ResponseBase r = attivitaController.createAttivitaAbbonamento(req);   
	    Assertions.assertThat(r.getRc()).isEqualTo(true);

	    req = new AttivitaReq();
	    req.setAbbonamentiId(2);
	    req.setId(1); 

	    r = attivitaController.createAttivitaAbbonamento(req);
	    Assertions.assertThat(r.getRc()).isEqualTo(true);
	    
	}

	@Test
	@Order(3)
	public void deleteAttivitaAbbonamentoTest() {
		
	    log.debug("Test delete attività per un abbonamento");
	    
	    AttivitaReq req = new AttivitaReq();
	    req.setAbbonamentiId(1);
	    req.setId(2); 

	    ResponseBase r = attivitaController.removeAttivitaAbbonamento(req);
	    Assertions.assertThat(r.getRc()).isEqualTo(true);
	    
	}

	@Test
	@Order(4)
	public void deleteAbbonamentoTest() {
		
		log.debug("Test delete attività per un abbonamento");
		
		AbbonamentoReq req = new AbbonamentoReq();
		req.setId(1);
		
		ResponseBase r = abbonamentoController.delete(req);
	    Assertions.assertThat(r.getRc()).isEqualTo(true);
		
	}
	
}

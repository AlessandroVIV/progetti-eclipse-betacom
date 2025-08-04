package com.betacom.jpa;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.betacom.jpa.controller.AttivitaController;
import com.betacom.jpa.dto.AttivitaDTO;
import com.betacom.jpa.requests.AttivitaReq;
import com.betacom.jpa.response.ResponseBase;
import com.betacom.jpa.response.ResponseList;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AttivitaControllerTest {

	@Autowired
	private AttivitaController attivitaController;
	
	@Test
	@Order(1)
	public void createAttivitaTest() {
		
		log.debug("Test Create Attivita");
		
		AttivitaReq req = new AttivitaReq();
		
		req.setDescrizione("Yoga");
		req.setPrezzo(new BigDecimal(10));
		ResponseBase r = attivitaController.create(req);
		
		Assertions.assertThat(r.getRc()).isEqualTo(true);
		
		req = new AttivitaReq();
		req.setDescrizione("Pilates");
		req.setPrezzo(new BigDecimal(12));
		r = attivitaController.create(req);
		
		Assertions.assertThat(r.getRc()).isEqualTo(true);
		
		req = new AttivitaReq();
		req.setDescrizione("Posturale");
		req.setPrezzo(new BigDecimal(15));
		r = attivitaController.create(req);
		
		Assertions.assertThat(r.getRc()).isEqualTo(true);
		
	}
	
	@Test
	@Order(2)
	public void listAttivitaTest() {
		
		log.debug("Test List Attività");
		
		ResponseList<AttivitaDTO> r = attivitaController.list();
		
		Assertions.assertThat(r.getRc()).isEqualTo(true);
		Assertions.assertThat(r.getDati().size()).isEqualTo(3);
		
	}
	
}

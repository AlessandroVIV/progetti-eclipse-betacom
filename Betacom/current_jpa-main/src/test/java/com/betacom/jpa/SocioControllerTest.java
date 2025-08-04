package com.betacom.jpa;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.betacom.jpa.controller.SocioController;
import com.betacom.jpa.dto.SocioDTO;
import com.betacom.jpa.requests.SocioReq;
import com.betacom.jpa.response.ResponseBase;
import com.betacom.jpa.response.ResponseList;
import com.betacom.jpa.response.ResponseObject;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SocioControllerTest {

	@Autowired
	private SocioController socioController;
	
	@Test
	@Order(1)
	public void listTest() {
		
		log.debug("Test List Socio");
		
		ResponseList<SocioDTO> r = socioController.list(null, "Simone", null, null);
		
		Assertions.assertThat(r.getRc()).isEqualTo(true);
		Assertions.assertThat(r.getDati().get(0).getCognome()).isEqualTo("Linati");
		
	}
	
	@Test
	@Order(2)
	public void getSocioTest() {
		
		log.debug("Test Get Socio");
		
		ResponseObject<SocioDTO> r = socioController.getSocio(1);
		
		Assertions.assertThat(r.getRc()).isEqualTo(true);
		
		Assertions.assertThat(r.getDati().getCognome()).isEqualTo("Linati");
		
	}
	
	@Test
	@Order(3)
	public void getSocioTestError() {
		
		log.debug("Test Get Socio Errore");
		
		ResponseObject<SocioDTO> r = socioController.getSocio(99);
		
		Assertions.assertThat(r.getRc()).isEqualTo(false);
		Assertions.assertThat(r.getMsg()).isEqualTo("socio-not-exist");
		
	}
	
	@Test
	@Order(4)
	public void updateSocioTestError() {
		
		log.debug("Test Update Socio");
		
		SocioReq req = new SocioReq();
		req.setId(2);
		req.setNome("Gabriele");
		req.setCodiceFiscale("123456789");
		
		ResponseBase r = socioController.update(req);
		
		Assertions.assertThat(r.getRc()).isEqualTo(true);
		
		ResponseObject<SocioDTO> s = socioController.getSocio(2);
		Assertions.assertThat(r.getRc()).isEqualTo(true);
		Assertions.assertThat(s.getDati().getNome()).isEqualTo("Gabriele");
		Assertions.assertThat(s.getDati().getCodiceFiscale()).isEqualTo("123456789");
		
	}
	
	@Test
	@Order(5)
	public void createSocioTest() throws Exception {
		
		log.debug("Test Create Socio");
		
		SocioReq req = new SocioReq();
		req.setCodiceFiscale("10987654321");
		req.setCognome("Viola");
		req.setNome("Anna");
		req.setEmail("a.viola@gmail.com");
		
		ResponseBase r = socioController.create(req);
		
		Assertions.assertThat(r.getRc()).isEqualTo(true);
		
	}
	
}

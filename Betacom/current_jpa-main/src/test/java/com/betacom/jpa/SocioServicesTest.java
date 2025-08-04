package com.betacom.jpa;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.betacom.jpa.dto.SocioDTO;
import com.betacom.jpa.requests.SocioReq;
import com.betacom.jpa.services.interfaces.ISocioServices;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SocioServicesTest {

	@Autowired
	private ISocioServices socioServices;
	
	@Test
	@Order(1)
	public void createSocioTest() throws Exception {
		
		log.debug("Create socio test");
		
		SocioReq req = new SocioReq();
		req.setCodiceFiscale("AND341J4N2LKM129");
		req.setCognome("Linati");
		req.setNome("Simone");
		req.setEmail("s.linati@gmail.com");
		
		socioServices.insert(req);
		
		List<SocioDTO> lS = socioServices.list(null, null, null, null);
		
		SocioDTO createSocio = lS.stream()
				.filter(s -> "AND341J4N2LKM129".equals(s.getCodiceFiscale()))
				.findFirst()
				.orElseThrow(() -> new AssertionError("Socio non trovato"));
		
		Assertions.assertThat(createSocio.getCognome()).isEqualTo("Linati");
		
		req = new SocioReq();
		req.setCodiceFiscale("CUM28398H2M3N4J1");
		req.setCognome("Bianchi");
		req.setNome("Andrea");
		req.setEmail("a.bianchi@gmail.com");
		
		socioServices.insert(req);
		
		lS = socioServices.list(null, null, null, null);
		
		lS.forEach(s -> log.debug(s.toString()));
		
	}
	
	@Test
	@Order(2)
	public void createSocioErrorTest() throws Exception {
		
		SocioReq req = new SocioReq();
		req.setCodiceFiscale("AND341J4N2LKM109");
		req.setCognome("Linati");
		req.setNome("Simone");
		req.setEmail("s.linati@gmail.com");
		
		assertThrows(Exception.class, () -> {
			socioServices.insert(req);
		});
		
	}
	
}

package com.betacom.jpa;

import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@Suite
@SelectClasses({
	MacchinaControllerTest.class,
	MotoControllerTest.class
})

@SpringBootTest
class ProjectCarJpaApplicationTests {

	@Test
	void contextLoads() {
	}

}

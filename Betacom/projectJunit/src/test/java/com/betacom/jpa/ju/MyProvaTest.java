package com.betacom.jpa.ju;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyProvaTest {

	@Test
	public void calcoloTest(){
		
		MyTest t = new MyTest();
		
		Assertions.assertThat(t.calcolo(5, 3)).isEqualTo(8);
		
	}
	
}

package com.betacom.jpa.ju;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeRepositoryTest {

	@Autowired
	private IEmployeeRepository employeeRepository;
	
	@Test
	@Order(1)
	public void saveEmployeeTest() {
		
		Employee e = new Employee();
		
		e.setCognome("Verdi");
		e.setNome("Paolo");
		e.setEmail("p.verdi@gmail.com");
		
		Integer id = employeeRepository.save(e).getId();
		
		System.out.println("Key: " + id);
		
		Assertions.assertThat(id).isEqualTo(1);

	}
	
	@Test
	@Order(2)
	public void saveEmployee2Test() {
		
		Employee e = new Employee();
		
		e.setCognome("Bianco");
		e.setNome("Niglio");
		e.setEmail("b.niglio@gmail.com");
		
		Integer id = employeeRepository.save(e).getId();
		
		System.out.println("Key: " + id);
		
		Assertions.assertThat(id).isEqualTo(2);

	}
	
	@Test
	@Order(3)
	public void getEmployeeTest() {
		Employee e = employeeRepository.findById(1).get();
		Assertions.assertThat(e.getId()).isEqualTo(1);
	}
	
}

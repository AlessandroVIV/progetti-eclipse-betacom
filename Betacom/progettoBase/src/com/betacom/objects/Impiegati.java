package com.betacom.objects;

public class Impiegati extends User{

	private Long salary;
	

	public Impiegati() {
		super();
	}

	public Impiegati(String nome, String cognome, Boolean sesso, Long salary) {
		super(nome, cognome, sesso);
		super.setNome(nome);
		super.setCognome(cognome);
		super.setSesso(sesso);
		this.salary = salary;
	}
	
	public String getMySesso() {
		return (getSesso()) ? "Maschio" : "Femmina";
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Impiegato: [salary= " + salary + ", Nome= " + getNome() + ", Cognome= " + getCognome()
				+ ", Sesso= " + getMySesso() + "]";
	}

	

	
	
	
	
	
}

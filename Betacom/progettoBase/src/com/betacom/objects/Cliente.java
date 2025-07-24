package com.betacom.objects;

public class Cliente {

	private String nome;
	private String congome;
	private DataNascita dataNascita;
	
	public Cliente(String nome, String congome, DataNascita dataNascita) {
		super();
		this.nome = nome;
		this.congome = congome;
		this.dataNascita = dataNascita;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCongome() {
		return congome;
	}

	public void setCongome(String congome) {
		this.congome = congome;
	}

	public DataNascita getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(DataNascita dataNascita) {
		this.dataNascita = dataNascita;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", congome=" + congome + ", dataNascita=" + dataNascita + "]";
	}
	
}
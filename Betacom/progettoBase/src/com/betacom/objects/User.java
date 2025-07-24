package com.betacom.objects;

import java.time.LocalDate;

public class User {
	
	//private String nome;
	//public String nome;
	
	// Protected lo rende visibile solo al suo stesso package
	//protected String nome;
	
	 private String nome;
	 private String cognome;
	 private Boolean sesso;
	 private LocalDate nascita;
	 private LocalDate certificatoMedico;
	 private Integer mesiDiValidita;
	 private LocalDate dataScadenza;
	 
	 public User() {
	}
	 
	 public User(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
		//setNome(nome);
		//setCognome(cognome);
	}
	 
	 public User(String nome, String cognome, Boolean sesso) {
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
	 }
	 
	 public User(String nome, String cognome, Boolean sesso, LocalDate nascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.nascita = nascita;
	 }
	 
	 public User(String nome, String cognome, Boolean sesso, LocalDate nascita, LocalDate certificatoMedico, Integer mesiDiValidita, LocalDate dataScadenza) {
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.nascita = nascita;
		this.certificatoMedico = certificatoMedico;
		this.mesiDiValidita = mesiDiValidita;
		this.dataScadenza = dataScadenza;
	 }
	 
	 public User(String nome, String cognome, Boolean sesso, int anno, int mese, int giorno) {
		this(nome, cognome, sesso, LocalDate.of(anno, mese, giorno)); // Fa riferimento al costruttore sopra
	 }
	 
	 public User(String nome, String cognome, Boolean sesso, int anno, int mese, int giorno, LocalDate certificatoMedico, int mesiValidita) {
		    this.nome = nome;
		    this.cognome = cognome;
		    this.sesso = sesso;
		    this.nascita = LocalDate.of(anno, mese, giorno);
		    this.certificatoMedico = certificatoMedico;
		    this.mesiDiValidita = mesiValidita;
	 }

	 public String getNome() {
		 return nome;
	 }
	 
	 public void setNome(String nome) {
		 this.nome = nome;
	 }
	 
	 public String getCognome() {
		 return cognome;
	 }
	 
	 public void setCognome(String cognome) {
		 this.cognome = cognome;
	 }
	 
	 public Boolean getSesso() {
		 return sesso;
	 }

	 public void setSesso(Boolean sesso) {
		 this.sesso = sesso;
	 }
	 
	 public LocalDate getNascita() {
		 return nascita;
	 }

	 public void setNascita(LocalDate nascita) {
		 this.nascita = nascita;
	 }
	 
	 public LocalDate getCertificatoMedico() {
		 return certificatoMedico;
	 }

	 public void setCertificatoMedico(LocalDate certificatoMedico) {
		 this.certificatoMedico = certificatoMedico;
	 }

	 public Integer getMesiDiValidita() {
		 return mesiDiValidita;
	 }

	 public void setMesiDiValidita(Integer mesiDiValidita) {
		 this.mesiDiValidita = mesiDiValidita;
	 }
	 
	public LocalDate getDataScadenza() {
		return dataScadenza;
	}

	 public void setDataScadenza(LocalDate dataScadenza) {
		 this.dataScadenza = dataScadenza;
	 }

	 // Genero automaticamente il metodo "toString()" tramite Eclipse con "source"
	 @Override
	 public String toString() {
		 
		 String resp = "User: [nome= " + nome + ", cognome= " + cognome;
		 
		 if(sesso != null){
			 resp = resp +  ", sesso= " + sesso;
		}
		 
		 if(nascita != null){
			 resp = resp +  ", nascita= " + nascita;
		}
		 
		if(certificatoMedico != null){
		     resp += ", certificatoMedico= " + certificatoMedico;
		}

		if(mesiDiValidita != null){
		    resp += ", mesiDiValidita= " + mesiDiValidita;
		}
		
		if(dataScadenza != null){
		    resp += ", dataScadenza= " + dataScadenza;
		}
		 
		resp = resp + "]";
		 
		return resp;

	 }

}

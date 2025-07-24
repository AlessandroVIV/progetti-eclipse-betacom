package com.betacom.objects;

public class Inner {

	private String classePadre;
	private int numero;
	
	private Figlio figlio; // Istanza del figlio
	
	public class Figlio{
		
		private int numeroFiglio;
		
		private Nipote nipote; // Istanza del nipote
		
		public class Nipote{
			
			private int numeroNipote;

			public int getNumeroNipote() {
				return numeroNipote;
			}

			public void setNumeroNipote(int numeroNipote) {
				this.numeroNipote = numeroNipote;
			}
			
			public String displayNumeri() {
			    return ">> Padre: " + numero + ", Figlio: " + numeroFiglio + ", Nipote: " + numeroNipote + " <<";
			}

		}

		public int getNumeroFiglio() {
			return numeroFiglio;
		}

		public void setNumeroFiglio(int numeroFiglio) {
			this.numeroFiglio = numeroFiglio;
		}
		
		public String displayNumeri() {
			return ">> Padre: " + numero + ", Figlio: " + numeroFiglio + " <<";
		}

		public Nipote getNipote() {
			return nipote;
		}

		public Nipote setInstanceNipote() {
			nipote = new Nipote();
			return nipote;
		}
		
	}
	
	public String getClassePadre() {
		return classePadre;
	}
	
	public void setClassePadre(String classePadre) {
		this.classePadre = classePadre;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public Figlio setInstanceFiglio() {
		figlio = new Figlio();
		return figlio;
	}
		
}
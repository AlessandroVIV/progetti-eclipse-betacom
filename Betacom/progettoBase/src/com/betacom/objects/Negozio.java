package com.betacom.objects;

public class Negozio {

	private int codice;
	private String proprietario;
	private String indirizzo;
	private boolean inCentroCommerciale;
	
	public Negozio() {
		super();
	}
	
	public static class Builder{
		private int codice;
		private String proprietario;
		private String indirizzo;
		private boolean inCentroCommerciale;
		
		public Builder() {
		}
		
		public Negozio build() {
			Negozio negozio = new Negozio();
			negozio.codice = this.codice;
			negozio.proprietario = this.proprietario;
			negozio.indirizzo = this.indirizzo;
			negozio.inCentroCommerciale = this.inCentroCommerciale;
			return negozio;
		}
		
		public Builder codice(int codice) {
			this.codice = codice;
			return this;
		}
		
		public Builder proprietario(String proprietario) {
			this.proprietario = proprietario;
			return this;
		}
		
		public Builder indirizzo(String indirizzo) {
			this.indirizzo = indirizzo;
			return this;
		}
		
		public Builder inCentroCommerciale(boolean inCentroCommerciale) {
			this.inCentroCommerciale = inCentroCommerciale;
			return this;
		}
		
	}
	
	public int getCodice() {
		return codice;
	}
	
	public void setCodice(int codice) {
		this.codice = codice;
	}
	
	public String getProprietario() {
		return proprietario;
	}
	
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public boolean isInCentroCommerciale() {
		return inCentroCommerciale;
	}
	
	public void setInCentroCommerciale(boolean inCentroCommerciale) {
		this.inCentroCommerciale = inCentroCommerciale;
	}
	
	@Override
	public String toString() {
		return "Negozio [codice=" + codice + ", proprietario=" + proprietario + ", indirizzo=" + indirizzo
				+ ", inCentroCommerciale=" + inCentroCommerciale + "]";
	}
	
}

package com.betacom.jpa.models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "veicolo")
public class Veicolo {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id_veicolo;
	
		@Column(name = "anno_produzione")
		private Integer annoProduzione;
		
	    @ManyToOne
	    @JoinColumn(name = "id_numeroRuote")
	    private NumeroRuote numeroRuote;

	    @ManyToOne
	    @JoinColumn(name = "id_alimentazione")
	    private Alimentazione alimentazione;

	    @ManyToOne
	    @JoinColumn(name = "id_categoria")
	    private Categoria categoria;

	    @ManyToOne
	    @JoinColumn(name = "id_colore")
	    private Colore colore;

	    @ManyToOne
	    @JoinColumn(name = "id_marca")
	    private Marca marca;

	    @ManyToOne
	    @JoinColumn(name = "id_modello")
	    private Modello modello;
	    
	    @ManyToOne
	    @JoinColumn(name = "id_sospensione") 
	    private Sospensione sospensione;
		
	    @OneToOne(mappedBy = "veicolo", cascade = CascadeType.ALL)
	    private Macchina macchina;
	    
	    @OneToOne(mappedBy = "veicolo", cascade = CascadeType.ALL)
	    private Moto moto;
	    
	    @OneToOne(mappedBy = "veicolo", cascade = CascadeType.ALL)
	    private Bici bici;
	    
}


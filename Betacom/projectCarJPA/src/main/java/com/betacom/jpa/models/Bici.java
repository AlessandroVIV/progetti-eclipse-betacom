package com.betacom.jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "bici")
public class Bici {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_bici;
	
	@Column(name = "numero_marce")
	private Integer numeroMarce;
	
	@ManyToOne
	@JoinColumn(name = "id_sospensione")
	private Sospensione sospensione;
	
	@Column(name = "pieghevole")
	private Boolean pieghevole;
	
    @ManyToOne
    @JoinColumn(name = "id_veicolo")
    private Veicolo veicolo;
	
}

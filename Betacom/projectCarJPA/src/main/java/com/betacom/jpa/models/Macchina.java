package com.betacom.jpa.models;

import jakarta.persistence.CascadeType;
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
@Table(name = "macchina")
public class Macchina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_macchina;
	
	@Column(name = "numero_porte")
	private Integer numeroPorte;
	
	@Column(name = "targa")
	private String targa;
	
	@Column(name = "cc")
	private Integer cc;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_veicolo")
	private Veicolo veicolo;

    
}

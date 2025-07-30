package com.betacom.jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "sospensione")
public class Sospensione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_sospensione;
	
	@Column(name = "tipo_sospensione")
	private String tipoSospensione;	
	
}

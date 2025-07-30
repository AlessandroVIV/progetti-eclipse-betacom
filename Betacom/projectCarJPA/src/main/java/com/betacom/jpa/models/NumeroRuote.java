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
@Table(name = "numero_ruote")
public class NumeroRuote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_numeroRuote;
	
	@Column(name = "numero_ruote")
	private Integer numeroRuote;
	
}

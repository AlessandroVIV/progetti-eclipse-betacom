package com.betacom.jpa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.jpa.models.NumeroRuote;

public interface INumeroRuoteRepository extends JpaRepository<NumeroRuote, Integer>{

	Optional<NumeroRuote> findByNumeroRuote(Integer numeroRuote);

}

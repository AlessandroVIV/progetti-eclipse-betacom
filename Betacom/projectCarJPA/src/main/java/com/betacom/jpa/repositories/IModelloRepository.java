package com.betacom.jpa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.jpa.models.Modello;

public interface IModelloRepository extends JpaRepository<Modello, Integer>{

	Optional<Modello> findByModello(String modello);
	
}

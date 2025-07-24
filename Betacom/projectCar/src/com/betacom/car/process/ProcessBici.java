package com.betacom.car.process;

import com.betacom.car.Models.Bici;
import com.betacom.car.singletone.ListManager;
import com.betacom.car.exception.AcademyException;

public class ProcessBici {

	// Controllo dei parametri specifici
	// I parametri di "Veicolo" devono essere uguali per tutti

	public void execute(String[] params) throws AcademyException{
		
		Bici bici = new Bici();
		
	    int id = ListManager.getInstance().getNextId();
	    bici.setId(id);
		
		bici = (Bici) new VeicoloControl().verify(bici, params);
		
		try {
			
			bici.setNumeroMarce(Integer.parseInt(params[8]));
			bici.setTipoSospenzione(params[9]);
			bici.setPiegevole(Boolean.valueOf(params[10]));
			
			ListManager.getInstance().addVeicolo(bici);	
			
			System.out.println("\nBici validata\n");
			
		} catch (Exception e) {
			throw new AcademyException("Errore nei parametri specifici della Bici: " + e.getMessage());
		}

	}
	
}

package com.betacom.car.process;

import com.betacom.car.Models.Moto;
import com.betacom.car.singletone.ListManager;
import com.betacom.car.exception.AcademyException;

public class ProcessMoto {

	// Controllo dei parametri specifici
	// I parametri di "Veicolo" devono essere uguali per tutti

	public void execute(String[] params) throws AcademyException{
		
		Moto moto = new Moto();
		
	    int id = ListManager.getInstance().getNextId();
	    moto.setId(id);
		
		moto = (Moto) new VeicoloControl().verify(moto, params);
		
		try {
			
			// Controllo targa
			String targa = params[8].toUpperCase().trim(); 
			if (!targa.matches("^[A-Z]{2}[0-9]{3}[A-Z]{2}$")) {
			    throw new AcademyException("Targa non valida. Deve essere nel formato AA123BB");
			}
			moto.setTarga(params[9]);
			moto.setCc(Integer.parseInt(params[9]));
			
			ListManager.getInstance().addVeicolo(moto);	
			
			System.out.println("\nMoto validata\n");
			
		} catch (Exception e) {
			throw new AcademyException("Errore nei parametri specifici della Moto: " + e.getMessage());
		}

	}
	
}

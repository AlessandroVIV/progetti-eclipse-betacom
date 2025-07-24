package com.betacom.car.process;

import com.betacom.car.Models.Macchina;
import com.betacom.car.singletone.ListManager;
import com.betacom.car.exception.AcademyException;

public class ProcessMacchina {

	// Controllo dei parametri specifici
	// I parametri di "Veicolo" devono essere uguali per tutti

	public void execute(String[] params) throws AcademyException{
		
		Macchina mac = new Macchina();
		
	    int id = ListManager.getInstance().getNextId();
	    mac.setId(id);
		
		mac = (Macchina) new VeicoloControl().verify(mac, params);
		
		//System.out.println("After control");
		
		try {
			 
			mac.setNumeroPorte(Integer.parseInt(params[8]));
			
			// Controllo targa
			String targa = params[9].toUpperCase().trim(); 
			if (!targa.matches("^[A-Z]{2}[0-9]{3}[A-Z]{2}$")) {
			    throw new AcademyException("Targa non valida. Deve essere nel formato AA123BB");
			}
			mac.setTarga(params[9]);
			
			mac.setCc(Integer.parseInt(params[10]));
			
			ListManager.getInstance().addVeicolo(mac);	
			
			
			
			System.out.println("\nMacchina validata\n");
			
		} catch (Exception e) {
			throw new AcademyException("Errore nei parametri specifici della Macchina: " + e.getMessage());
		}

	}
	
}
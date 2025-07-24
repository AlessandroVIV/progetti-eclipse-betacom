package com.betacom.car.process;

import java.util.List;

import com.betacom.car.singletone.ListManager;
import com.betacom.car.exception.AcademyException;

public class StartCar {

	// Gestione dei parametri "params"
	// Dispatch delle classi dei veicoli

	private ProcessMacchina mac = new ProcessMacchina();
	private ProcessMoto moto = new ProcessMoto();
	private ProcessBici bici = new ProcessBici();
	
	public boolean execute(List<String> params) {

    System.out.println("\nInizia StartCar\n");

    ListManager lm = ListManager.getInstance();

    for (String p : params) {

        if (p.startsWith("export:")) {
        	
        	String[] parti = p.split("export:", 2);
        	
        	String exportPath = parti[1].trim();
        	
        	lm.esportaJson(exportPath);

            continue;
            
        }

        if (p.startsWith("add:")) {
        	
            String[] stringhe = p.substring("add:".length()).split(",");
            
            System.out.println(p);

            try {
           	                  
                String tipoVeicolo = stringhe[0];

                switch (tipoVeicolo.toLowerCase()) {
                case "macchina" -> mac.execute(stringhe);
                case "moto"     -> moto.execute(stringhe);
                case "bici"     -> bici.execute(stringhe);
                default         -> System.out.println("Tipo veicolo non riconosciuto");
                
            }

            } catch (AcademyException e) {
                System.out.println("Errore: " + e.getMessage());
            }
            
        }
        
    }

    return true;
}

}
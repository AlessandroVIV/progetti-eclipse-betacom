package com.betacom.car.singletone;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.betacom.car.Models.Bici;
import com.betacom.car.Models.Macchina;
import com.betacom.car.Models.Moto;
import com.betacom.car.Models.Veicolo;
import com.betacom.car.exception.AcademyException;
import com.betacom.car.process.VeicoloControl;
import com.google.gson.*;

/*
 * gestione dell'ID veicolo
 * gestione della targa (univoca)
 * gestrion della lista veicolo (inserimento)
 * display della lista4
 */

public class ListManager {

	// Dichiaro l'istanza
	private static ListManager instance = null;
	
	// Dichiaro la lista finale con dentro tutti i veicoli creati
	private List<Veicolo> listaV = new ArrayList<Veicolo>();
	
	// Metodo per l'esportazione dei dati in json
	public void esportaJson(String path) {
		
		try (FileWriter writer = new FileWriter(path)){
			
			String json = new Gson().toJson(listaV);
			
			writer.write(json);
			
			System.out.println("Lista veicoli salvata in: " + path);
			
			
		} catch (IOException e) {
			System.out.println("Errore nel salvataggio: " + e.getMessage());
		}
		
	}

	public void importaJsonVeicoli(String path) {
		
	    try (FileReader reader = new FileReader(path)) {

	        Gson gson = new Gson();
	        
	        JsonArray array = JsonParser.parseReader(reader).getAsJsonArray();

	        for (JsonElement element : array) {
	        	
	            try {
	            	
	                JsonObject obj = element.getAsJsonObject();
	                
	                String tipo = obj.get("tipoVeicolo").getAsString();

	                Veicolo oggettoFinale = null;

	                if ("Macchina".equalsIgnoreCase(tipo)) {
	                    oggettoFinale = gson.fromJson(obj, Macchina.class);
	                } else if ("Moto".equalsIgnoreCase(tipo)) {
	                    oggettoFinale = gson.fromJson(obj, Moto.class);
	                } else if ("Bici".equalsIgnoreCase(tipo)) {
	                    oggettoFinale = gson.fromJson(obj, Bici.class);
	                }

	                if (oggettoFinale != null) {
	                	
	                    oggettoFinale.setId(getNextId());	          
	                    new VeicoloControl().verify(oggettoFinale);	 
	                    
	                    addVeicolo(oggettoFinale);
	                }

	            } catch (AcademyException e) {
	                System.out.println("Veicolo scartato per errore: " + e.getMessage() + "\n");
	            } catch (Exception e) {
	                System.out.println("Errore durante l'importazione di un veicolo: " + e.getMessage());
	            }
	        }

	        System.out.println("JSON importato correttamente da: " + path);

	    } catch (IOException e) {
	        System.out.println("Errore durante la lettura del file JSON: " + e.getMessage());
	    }
	    
	}

	public ListManager() {
		super();
	};

	// Creo poi la presa dell'istanza
	public static ListManager getInstance() {
		
		if(instance == null) {
			instance = new ListManager();
		}
		
		return instance;
		
	}
	
	// Dichiaro il contatore
	private Integer idx = 0;
	
	// Dichiaro la funzione che lo fa aumentare
	public Integer getNextId() {
		idx++;
		return idx;
	}
	
	// Aggiunta del veicolo alla lista
	public void addVeicolo(Veicolo v) {
		listaV.add(v);
	}
	
	// Lista intera dei veicoli inseriti
	public List<Veicolo> getLista() {
	    return listaV;
	}

}
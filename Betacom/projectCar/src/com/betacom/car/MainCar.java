package com.betacom.car;

import java.util.ArrayList;
import java.util.List;

import com.betacom.car.Models.Veicolo;
import com.betacom.car.singletone.ListManager;
import com.betacom.car.process.StartCar;

public class MainCar {

	public static void main(String[] args) {
	
		List<String> params = new ArrayList<String>();
		
		//params.add("Macchina,4,benzina,strada,giallo,Fiat,1990,Panda,3,EL123GX,1200");
		//params.add("Moto,2,benzina,strada,rosso,Yamaha,2010,StreetRider 500,EL222BB,900");
		//params.add("Bici,2,manuale,ciclabile,blu,B1,1990,CityCruiser,4,senza,false");
		
		// Macchina(tipoVeicolo, numeroRuote, tipoAlimentazione, categoria, colore, marca, annoProduzione, modello, portiere, targa, cilindrata)
		// Moto(tipoVeicolo, numeroRuote, tipoAlimentazione, categoria, colore, marca, annoProduzione, modello, targa, cilindrata)
		// Bici(tipoVeicolo, numeroRuote, manuale, ciclabile, colore, marca, annoProduzione, modello, numeroMarce, tipoSospesione, piegevole)
		
		System.out.println("Veicoli trovati nel file: \n");
		
//		ProcessSequential lettura = new ProcessSequential();
//
//		List<String> righeDati = lettura.leggiFile();
//
//		params.addAll(righeDati);
		
		String jsonPath = "C:\\Users\\Ho\\eclipse-workspace\\Betacom\\projectCar\\src\\veicoli.json";
		
		ListManager.getInstance().importaJsonVeicoli(jsonPath);

		if (new StartCar().execute(params)) {
			
			System.out.println("\nLista aggiornata dei veicoli: ");
			
			for (Veicolo v : ListManager.getInstance().getLista()) {
			    System.out.println("\n" + v); 
			}
			
			System.out.println("\nFine normale del programma");
			
		} else {
			System.out.println("Errore nel programma");
		}
		
	}

}
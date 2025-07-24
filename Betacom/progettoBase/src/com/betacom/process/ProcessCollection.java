package com.betacom.process;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.betacom.objects.Impiegati;

public class ProcessCollection {

	public boolean execute() {
		
		executeList();

		executeMap();
		
		mapTest();
		
		return true;
		
	}
	
	private void executeList() {
		
		System.out.println("Inizia ProcessCollection\n");
		
		// Inizio le liste
		// Passo come oggetto "Impiegati" dentro ai simboli "<>". Creerò una lista di impiegati con "ArrayList".
		List<Impiegati> lI = new ArrayList<Impiegati>(); // Ho inizializzato la lista
		
		// Ora sfrutto i metodi per aggiungere elementi
		lI.add(new Impiegati("Antonio", "Vivaldi", true, 1800L));
		lI.add(new Impiegati("Simone", "Gialli", true, 1200L));
		lI.add(new Impiegati("Gabriele", "Tazzari", true, 1300L));
		lI.add(new Impiegati("Valerio", "Lucarini", true, 1100L));
		lI.add(new Impiegati("Francesca", "Vona", false, 1600L));
		lI.add(new Impiegati("Federica", "Vivaldi", false, 1500L));
		lI.add(new Impiegati("Angelo", "Liburdi", true, 2000L));
		lI.add(new Impiegati("Arianna", "Piccolini", true, 2500L));
		
		// Ciclo mostrando tutti gli Impiegati richiamando la funzione sotto
		listImpiegati(lI);

		Impiegati save = removeFromImpiegati("Gialli", lI);
		System.out.println("\nDopo la rimozione");
		listImpiegati(lI);
		
		if(save != null) {
			lI.add(save);
		}

		System.out.println("\nRiaggiunto l'impiegato: ");
		listImpiegati(lI);
		
		lI.add(save);
		System.out.println("\nLista aggiornata dopo aggiunta: ");
		listImpiegati(lI);
		
		save = removeFromImpiegati("Gialli", lI);
		System.out.println("\nRimozione dopo il primo save:");
		listImpiegati(lI);
		
		// Il metodo ".sort()". Una classe anonima già implementata
		lI.sort(new Comparator<Impiegati>() {
			
			// Confronto i due salari e metterà in ordine la tabella a seconda del risultato
			@Override
			public int compare(Impiegati o1, Impiegati o2) {
				return Double.compare(o1.getSalary(), o2.getSalary());
			}
			
		});
		
		System.out.println("\nDopo la comparazione dei salari: ");
		listImpiegati(lI);
	}
	
	// Sfrutto le mappe chiave-valore
	private void executeMap() {
		
		// Definisco la mappa con valori "key-value"
		Map<String, String> map = new HashMap<String, String>();
		
		// Sfrutto l'oggetto "map" creato
		map.put("k1", "v1");
		map.put("k2", "v2");
		map.put("k3", "v3");
		map.put("k4", "v4");
		map.put("k5", "v5");
		map.put("k6", "v6");
		map.put("k7", "v7");
		map.put("k8", "v8");
		map.put("k9", "v9");
		map.put("k10", "v10");
		
		// Ne stampo la grandezza
		System.out.println("\nLa grandezza della map è di: " + map.size() + " elementi");
		
		// Controllo se c'è qualcuno che corrisponde alla chiave (key)
		String keySearch = "k6";
		
		if(map.containsKey(keySearch)) {
			System.out.println("\nKey " + keySearch + " trovata!");
		}else {
			System.out.println("\nChiave " + keySearch + " non trovata...");
		}
		
		// Controllo se c'è qualcuno che corrisponde al valore (value)
		String valueSearch = "v8";
		
		if(map.containsValue(valueSearch)) {
			System.out.println("\nValore " + valueSearch + " trovato!");
		}else {
			System.out.println("\nValore " + valueSearch + " non trovato...");
		}
		
		// Vado a prendermi il value dando la chiave -> k10 to v10
		String value = null;
		value = map.get("k10");
		
		System.out.println("\nValore estratto: " + value + "\n");
		
		// Provo ad aggiungere un chiave-valore già esistente
		map.put("k10", "BlaBla");
		System.out.println("Valore successivo di k10: " + value + "\n"); // Il valore di value sarà "BlaBla"
		
		// Creo e riassegno
		map.put("k99", "Nuovo valore");
		System.out.println("Numero elementi dentro map: " + map.size() + ", valore di K99: " + map.get("k99") + "\n");
		
		// Ciclo sulla map per vederle tutte
		// Specifico l'entrySet per avere un set completo 
		for(Entry<String, String> it: map.entrySet()) {
			System.out.println("Chiave " + it.getKey() + ", valore: " + it.getValue());
		}
		
	}
	
	private void mapTest() {
		
	    String param = "p1=aaa, p2=25, p3=Paolo";
	    
	    Map<String, String> mapTest = new HashMap<String, String>();

	    String[] stringhe = param.split(",");

	    for (String stringa : stringhe) {
	      
	        String[] keyValue = stringa.split("=");
	        
	        if (keyValue.length == 2) {
	            mapTest.put(keyValue[0], keyValue[1]);
	        }
	        
	    }

	    System.out.println("\nLe chiavi-valore sono: " + mapTest);
	    
	}

	
	// Conservo la funzione di eliminazione
	public Impiegati removeFromImpiegati(String cerca, List<Impiegati> lI) {
		
		int pos = 0;
		
		Impiegati rc = null;
		
		for (Impiegati it : lI) {
			
			if (it.getCognome().equalsIgnoreCase(cerca)) {
				rc = it;  
				break;   
			}
			
			pos++;
			
		}
		
		if(rc != null) {
			lI.remove(pos);
		}
		
		return rc;
		
	}
	
	// Per velocizzare, metto da parte la lista degli impiegati per poterla richiamare
	private void listImpiegati(List<Impiegati> lI) {
		
		int pos = 0;
		
		for(Impiegati it: lI) {
			System.out.println(pos + " " + it);
			pos++;
		}
		
	}
	
}

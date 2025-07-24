package com.betacom.car.dao;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.betacom.car.models.Veicolo;
import com.betacom.car.singletone.SQLConfiguration;
import com.betacom.car.utilities.SQLManager;

public class VeicoloDAO {

	private SQLManager db = new SQLManager();
	
	// Funzione per trovare tutti gli elementi dentro "veicolo"
	public List<Veicolo> findAll() throws Exception{
		
		String qry = SQLConfiguration.getInstance().getQuery("veicoli");
		
		System.out.println("Query findAll dei veicoli: " + qry + "\n");
		
		List<Map<String, Object>> lD = db.list(qry);
	
		return lD.stream()
			    .map(row -> new Veicolo(
			        (Integer) row.get("id_veicolo"),
			        (Integer) row.get("annoProduzione"),
			        (Integer) row.get("id_numeroRuote"),
			        (Integer) row.get("id_alimentazione"),
			        (Integer) row.get("id_categoria"),
			        (Integer) row.get("id_colore"),
			        (Integer) row.get("id_marca"),
			        (Integer) row.get("id_modello"),
			        (Integer) row.get("id_macchina"),
			        (Integer) row.get("id_moto"),
			        (Integer) row.get("id_bici")
			    ))
			    .collect(Collectors.toList());

	}
	
	// Funzione per trovare i veicoli con un colore specificato tramite una find generica
	public List<Veicolo> findGeneric(String qryName,Object[] params) throws Exception{
		
		String qry = SQLConfiguration.getInstance().getQuery(qryName);
		System.out.println("\nQuery generica: " + qry);
		
		List<Map<String, Object>> lD = db.list(qry, params);
	
		return lD.stream()
			    .map(row -> new Veicolo(
				        (Integer) row.get("id_veicolo"),
				        (Integer) row.get("annoProduzione"),
				        (Integer) row.get("id_numeroRuote"),
				        (Integer) row.get("id_alimentazione"),
				        (Integer) row.get("id_categoria"),
				        (Integer) row.get("id_colore"),
				        (Integer) row.get("id_marca"),
				        (Integer) row.get("id_modello"),
				        (Integer) row.get("id_macchina"),
				        (Integer) row.get("id_moto"),
				        (Integer) row.get("id_bici")
				    )). collect(Collectors.toList());
		
	}
	
	// Funzione di INSERT di un veicolo
	public int insert(String qryName, Object[] params) throws Exception{
		
		int numero = 0;
		
		String qry = SQLConfiguration.getInstance().getQuery(qryName);
		System.out.println("\nQuery di insert per veicolo: " + qry);
		
		numero = db.update(qry, params, true); // Aggiungo la visualizzazione della primary key generata
		
		return numero;
	}
	
	// Funzione di UPDATE di un veicolo
	public int update(String qryName, Object[] params) throws Exception {
		
	    int numero = 0;
	    
	    String qry = SQLConfiguration.getInstance().getQuery(qryName);
	    System.out.println("\nQuery di update per veicolo: " + qry);
	    
	    numero = db.update(qry, params); 
	    
	    return numero;
	}

	// Funzione di DELETE di un veicolo
	public int delete(String qryName, Object[] params) throws Exception{
		
		int numero = 0;
		
		String qry = SQLConfiguration.getInstance().getQuery(qryName);
		System.out.println("\nQuery di delete per veicolo: " + qry);
		
		numero = db.update(qry, params); 
		
		return numero;
		
	}
	
}

package com.betacom.car.dao;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.betacom.car.models.Macchina;
import com.betacom.car.singletone.SQLConfiguration;
import com.betacom.car.utilities.SQLManager;

public class MacchinaDAO {

	private SQLManager db = new SQLManager();
	
	// Funzione per trovare tutti gli elementi dentro "Macchina"
	public List<Macchina> findAll() throws Exception{
		
		String qry = SQLConfiguration.getInstance().getQuery("macchina");
		
		System.out.println("\nQuery findAll delle macchine: " + qry + "\n");
		
		List<Map<String, Object>> lD = db.list(qry);
	
		return lD.stream()
			    .map(row -> new Macchina(
			        (Integer) row.get("id_macchina"),
			        (Integer) row.get("numeroPorte"),
			        (String) row.get("targa"),
			        (Integer) row.get("cc")
			    ))
			    .collect(Collectors.toList());

	}
	
	// Funzione di INSERT di una macchina
	public int insert(String qryName, Object[] params) throws Exception{
		
		int numero = 0;
		
		String qry = SQLConfiguration.getInstance().getQuery(qryName);
		System.out.println("\nQuery di insert per una macchina: " + qry);
		
		numero = db.update(qry, params, true); // Aggiungo la visualizzazione della primary key generata
		
		return numero;
	}
	
	// Funzione di UPDATE di una macchina
	public int update(String qryName, Object[] params) throws Exception {
		
	    int numero = 0;
	    
	    String qry = SQLConfiguration.getInstance().getQuery(qryName);
	    System.out.println("\nQuery di update per macchina: " + qry);
	    
	    numero = db.update(qry, params); 
	    
	    return numero;
	}
	
	// Funzione di DELETE di una macchina
	public int delete(String qryName, Object[] params) throws Exception{
		
		int numero = 0;
		
		String qry = SQLConfiguration.getInstance().getQuery(qryName);
		System.out.println("\nQuery di delete per macchina: " + qry);
		
		numero = db.update(qry, params); 
		
		return numero;
		
	}
	
}

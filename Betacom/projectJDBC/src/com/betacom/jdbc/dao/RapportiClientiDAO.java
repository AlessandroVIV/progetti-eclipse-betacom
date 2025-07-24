package com.betacom.jdbc.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.betacom.jdbc.models.Clienti;
import com.betacom.jdbc.models.RapportiClienti;
import com.betacom.jdbc.singleton.SQLConfiguration;
import com.betacom.jdbc.utilities.SQLManager;

public class RapportiClientiDAO {
	
	private SQLManager db = new SQLManager();

	public int insert(String qryName, Object[] params) throws Exception{
		
		int numero = 0;
		
		String qry = SQLConfiguration.getInstance().getQuery(qryName);
		System.out.println("Query:" + qry);

		numero = db.update(qry, params, true); 
		
		return numero;
		
	}
	
	public int delete(String qryName, Object[] params) throws Exception{
		
		int numero = 0;
		
		String qry = SQLConfiguration.getInstance().getQuery(qryName);
		System.out.println("Query:" + qry);

		numero = db.update(qry, params); 
		
		return numero;
		
	}
	
	public List<RapportiClienti> findAll() throws Exception {
	    String qry = SQLConfiguration.getInstance().getQuery("rapporto_clienti");
	    System.out.println("Query: " + qry);

	    List<Map<String, Object>> lR = db.list(qry);

	    return lR.stream()
	            .map(row -> new RapportiClienti(
	                    (Integer) row.get("id_rapporto"),
	                    (String) row.get("descrizione"),
	                    (Integer) row.get("id_clienti"), 
	                    (Integer) row.get("id_dipendenti")
	            ))
	            .collect(Collectors.toList()); 
	}
	
	public Optional<RapportiClienti> findById(Object[] parameters) throws Exception {
	    String qry = SQLConfiguration.getInstance().getQuery("rapporti-clienti.byId");
	    System.out.println("Query: " + qry);

	    Map<String, Object> row = db.get(qry, parameters);

	    if (row == null) {
	        return Optional.empty();
	    } else {
	        return Optional.ofNullable(new RapportiClienti(
	            (Integer) row.get("id_rapporto"),
	            (String) row.get("descrizione"),
	            (Integer) row.get("id_clienti"),
	            (Integer) row.get("id_dipendenti")
	        ));
	    }
	}
	
}
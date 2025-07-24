package com.betacom.jdbc.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.betacom.jdbc.models.Clienti;
import com.betacom.jdbc.singleton.SQLConfiguration;
import com.betacom.jdbc.utilities.SQLManager;

public class ClientiDAO {
	
	private SQLManager db = new SQLManager();
	
	/*
	 * id_cliente
	 * nome_cliente
	 * partita_iva
	 * indirizzo
	 * telefono
	 */
	
	public int insert(String qryName, Object[] params) throws Exception{
		int numero = 0;
		
		String qry = SQLConfiguration.getInstance().getQuery(qryName);
		System.out.println("Query:" + qry);
		
		// numero = db.update(qry, params);
		
		numero = db.update(qry, params, true); // Aggiungo la visualizzazione della primary key generata
		
		return numero;
	}
	
	public int update(String qryName, Object[] params) throws Exception{
		
		int numero = 0;
		
		String qry = SQLConfiguration.getInstance().getQuery(qryName);
		System.out.println("Query:" + qry);

		numero = db.update(qry, params); 
		
		return numero;
	}
	
	public int delete(String qryName, Object[] params) throws Exception{
		
		int numero = 0;
		
		String qry = SQLConfiguration.getInstance().getQuery(qryName);
		System.out.println("Query:" + qry);
		
		numero = db.update(qry, params); 
		
		return numero;
		
	}
	
	public List<Clienti> findAll() throws Exception{
		
		String qry = SQLConfiguration.getInstance().getQuery("clienti");
		System.out.println("Query:" + qry);
		
		List<Map<String, Object>> lD = db.list(qry);
	
		return lD.stream()
				.map(row -> new Clienti(
						(Integer)row.get("id_clienti"), 
						(String)row.get("nome_cliente"), 
						(String)row.get("partita_iva"), 
						(String)row.get("indirizzo"), 
						(String)row.get("telefono"))).collect(Collectors.toList());
	}
	
	public List<Clienti> findGeneric(String queryName, Object[] params) throws Exception{
		
		String qry = SQLConfiguration.getInstance().getQuery(queryName);
		System.out.println("Query:" + qry);
		
		List<Map<String, Object>> lD = db.list(qry);
	
		return lD.stream()
				.map(row -> new Clienti(
						(Integer)row.get("id_clienti"), 
						(String)row.get("nome_cliente"), 
						(String)row.get("partita_iva"), 
						(String)row.get("indirizzo"), 
						(String)row.get("telefono"))).collect(Collectors.toList());
	}

	
	public Optional<Clienti> findById(Object[] parameters) throws Exception {
	    String qry = SQLConfiguration.getInstance().getQuery("clienti.byId");
	    System.out.println("Query: " + qry);

	    Map<String, Object> row = db.get(qry, parameters);

	    if (row == null) {
	        return Optional.empty();
	    } else {
	        return Optional.ofNullable(new Clienti(
	            (Integer) row.get("id_cliente"),
	            (String) row.get("nome_cliente"),
	            (String) row.get("partita_iva"),
	            (String) row.get("indirizzo"),
	            (String) row.get("telefono")
	        ));
	    }
	}

}
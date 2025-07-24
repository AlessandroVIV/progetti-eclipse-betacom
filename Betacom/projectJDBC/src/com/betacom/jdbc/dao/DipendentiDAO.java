package com.betacom.jdbc.dao;

import static com.betacom.jdbc.utilities.Utils.dateToLocalDate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.betacom.jdbc.models.Dipendenti;
import com.betacom.jdbc.singleton.SQLConfiguration;
import com.betacom.jdbc.utilities.SQLManager;

public class DipendentiDAO {
	
	private SQLManager db = new SQLManager();

	/* nomi sulla tabella
	 * 
	 * 	id_dipendenti
	 *  nome
	 *  cognome
	 * 	data_assunzione
	 * 	telefono
	 * 	manzione
	 * 	stipendio
	 * 	id_ufficio
	 * 	comune_nascita
	 */
		
	public List<Dipendenti> findAll() throws Exception{
		
		String qry = SQLConfiguration.getInstance().getQuery("dipendenti");
		System.out.println("Query:" + qry);
		
		List<Map<String, Object>> lD = db.list(qry);
	
		return lD.stream()
				.map(row -> new Dipendenti(
						(Integer)row.get("id_dipendenti"), 
						(String)row.get("nome"), 
						(String)row.get("cognome"), 
						dateToLocalDate(row.get("data_assunzione")), 
						(String)row.get("telefono"), 
						(String)row.get("manzione"), 
						((BigDecimal)row.get("stipendio")).doubleValue(), 
						(Integer)row.get("id_ufficio"), 
						(String)row.get("comune_nascita"))).collect(Collectors.toList());
		
	}
	
	public List<Dipendenti> findGeneric(String qryName,Object[] params) throws Exception{
		
		String qry = SQLConfiguration.getInstance().getQuery(qryName);
		System.out.println("Query:" + qry);
		
		List<Map<String, Object>> lD = db.list(qry, params);
	
		return lD.stream()
				.map(row -> new Dipendenti(
						(Integer)row.get("id_dipendenti"), 
						(String)row.get("nome"), 
						(String)row.get("cognome"), 
						dateToLocalDate(row.get("data_assunzione")), 
						(String)row.get("telefono"), 
						(String)row.get("mansione"), 
						((BigDecimal)row.get("stipendio")).doubleValue(), 
						(Integer)row.get("id_ufficio"), 
						(String)row.get("comune_nascita"))).collect(Collectors.toList());
		
	}

	
	public Optional<Dipendenti> findById(Object[] parameters) throws Exception{
		
		String qry = SQLConfiguration.getInstance().getQuery("dipendenti.byId");
		System.out.println("Query:" + qry);
		
		Map<String, Object> row = db.get(qry, parameters);
		if (row == null)
			return Optional.empty();
		else {
		return  Optional.ofNullable(new Dipendenti(         
				
						(Integer)row.get("id_dipendenti"), 
						(String)row.get("nome"), 
						(String)row.get("cognome"), 
						dateToLocalDate(row.get("data_assunzione")), 
						(String)row.get("telefono"), 
						(String)row.get("manzione"), 
						((BigDecimal)row.get("stipendio")).doubleValue(), 
						(Integer)row.get("id_ufficio"), 
						(String)row.get("comune_nascita")));
		}
	}


	public Long count(String qryName,Object[] parameters) throws Exception{
		
		String qry = SQLConfiguration.getInstance().getQuery(qryName);
		System.out.println("Query:" + qry);
		
		return db.count(qry, parameters);
	
	}
}
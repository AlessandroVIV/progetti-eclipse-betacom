package com.betacom.sb.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class NumeroRuoteDAO {

	private final NamedParameterJdbcTemplate jdbcTemplate;
	
	public NumeroRuoteDAO(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	} 
	
	public Integer getIdByNumeroRuote(int numeroRuote) {
		
	    String sql = "SELECT id_numeroRuote FROM numeroruote WHERE numeroRuote = :numero";
	    SqlParameterSource param = new MapSqlParameterSource("numero", numeroRuote);
	    
	    return jdbcTemplate.queryForObject(sql, param, Integer.class);
	    
	}

	
}

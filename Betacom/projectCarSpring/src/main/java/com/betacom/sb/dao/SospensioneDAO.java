package com.betacom.sb.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class SospensioneDAO {

	private final NamedParameterJdbcTemplate jdbcTemplate;
	
	public SospensioneDAO(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	} 
	
	public Integer getIdBySospensione(String tipoSospensione) {
		
	    String sql = "select id_sospensione from sospensione where sospensione = :sospensione";
	    SqlParameterSource param = new MapSqlParameterSource("sospensione", tipoSospensione);
	    
	    return jdbcTemplate.queryForObject(sql, param, Integer.class);
	    
	}
	
}

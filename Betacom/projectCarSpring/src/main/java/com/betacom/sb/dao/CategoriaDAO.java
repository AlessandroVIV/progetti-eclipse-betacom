package com.betacom.sb.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriaDAO {

	private final NamedParameterJdbcTemplate jdbcTemplate;
	
	public CategoriaDAO(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	} 
	
	public Integer getIdByCategoria(String nomeCategoria) {
		
	    String sql = "select id_categoria from categoria where categoria = :categoria";
	    SqlParameterSource param = new MapSqlParameterSource("categoria", nomeCategoria);
	    
	    return jdbcTemplate.queryForObject(sql, param, Integer.class);
	    
	}
	
}

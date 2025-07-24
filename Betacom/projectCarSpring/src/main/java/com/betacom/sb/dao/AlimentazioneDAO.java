package com.betacom.sb.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;


@Repository
public class AlimentazioneDAO {

	private final NamedParameterJdbcTemplate jdbcTemplate;
	
	public AlimentazioneDAO(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public Integer getIdByAlimentazione(String tipoAlimentazione) {
		
	    String sql = "SELECT id_alimentazione FROM alimentazione WHERE alimentazione = :alimentazione";
	    SqlParameterSource param = new MapSqlParameterSource("alimentazione", tipoAlimentazione);
	    
	    return jdbcTemplate.queryForObject(sql, param, Integer.class);
	    
	}

}

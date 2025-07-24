package com.betacom.sb.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.sb.models.Moto;

@Repository
public class MotoDAO {

	private final NamedParameterJdbcTemplate jdbcTemplate;
	
	public MotoDAO(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	} 
	
	@Transactional (rollbackFor = Exception.class)
	public List<Moto> findAllMoto(){
		return jdbcTemplate.query("select * from moto", BeanPropertyRowMapper.newInstance(Moto.class));
	}
	
	@Transactional (rollbackFor = Exception.class)
	public List<Moto> getMotoById(Integer id){
		
		SqlParameterSource param = new MapSqlParameterSource("id", id);
		
		String sql = "select * from moto where id_moto = :id";
		
		return jdbcTemplate.query(sql, param, BeanPropertyRowMapper.newInstance(Moto.class));
		
	}
	
}

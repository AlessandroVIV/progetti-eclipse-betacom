package com.betacom.sb.dao;

import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.sb.models.Macchina;

@Repository
public class MacchinaDAO {

	private final NamedParameterJdbcTemplate jdbcTemplate;
	
	public MacchinaDAO(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Transactional (rollbackFor = Exception.class)
	public List<Macchina> findAllMacchina(){
		return jdbcTemplate.query("select * from macchina", BeanPropertyRowMapper.newInstance(Macchina.class));
	}
	
	@Transactional (rollbackFor = Exception.class)
	public List<Macchina> getMacchinaById(Integer id){
		
		SqlParameterSource param = new MapSqlParameterSource("id", id);
		
		String sql = "select * from macchina where id_macchina = :id";
		
		return jdbcTemplate.query(sql, param, BeanPropertyRowMapper.newInstance(Macchina.class));
		
	}
	
	@Transactional(rollbackFor = Exception.class)
	public int insertMacchina(int numeroPorte, String targa, int cilindrata, int idVeicolo) {
		
	    String sql = """
	        INSERT INTO macchina (numeroPorte, targa, cc, id_veicolo)
	        VALUES (:porte, :targa, :cc, :idVeicolo)
	    """;

	    MapSqlParameterSource params = new MapSqlParameterSource()
	        .addValue("porte", numeroPorte)
	        .addValue("targa", targa)
	        .addValue("cc", cilindrata)
	        .addValue("idVeicolo", idVeicolo);

	    return jdbcTemplate.update(sql, params);
	}

	
}

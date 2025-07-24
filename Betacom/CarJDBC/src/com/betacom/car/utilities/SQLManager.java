package com.betacom.car.utilities;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.betacom.car.exception.AcademyException;
import com.betacom.car.singletone.SQLConfiguration;


public class SQLManager {

	public Connection getConnection() throws AcademyException{
		
		Connection con = null;
		
		try {
			
			Class.forName(SQLConfiguration.getInstance().getProperty("driver")); 
			
			con = DriverManager.getConnection(
					SQLConfiguration.getInstance().getProperty("url"),
					SQLConfiguration.getInstance().getProperty("user"),
					SQLConfiguration.getInstance().getProperty("pwd")
					);
			
			
			return con;
			
		} catch (Exception e) {
			throw new AcademyException(e.getMessage());
		}
	}
	
	// Funzione di commit delle query
	public void commit() throws AcademyException{
		try {
			SQLConfiguration.getInstance().getConnection().commit();
		} catch (SQLException e) {
			throw new AcademyException(e.getMessage());
		}
	}
	
	// Funzione di rollback in caso di errore
	public void rollback() throws AcademyException{
		try {
			SQLConfiguration.getInstance().getConnection().rollback();  
		} catch (SQLException e) {
			throw new AcademyException(e.getMessage());
		}
	}
	
	// Funzione che ritorna le tabelle del database
	public List<String> listOfTable(String dbName) throws AcademyException {
		
		List<String> lT = new ArrayList<String>();
		
		try {
			
			DatabaseMetaData dbMD = SQLConfiguration.getInstance().getConnection().getMetaData(); 
			
			ResultSet res = dbMD.getTables(dbName, null, null, null); 
			
			while (res.next()) {
				lT.add(res.getString("TABLE_NAME"));   
			}
			
		} catch (SQLException e) {
			throw new AcademyException(e.getMessage());
		}
		
		return lT;
		
	}
	
	// Funzione di creazione di una select senza parametri
	public List<Map<String, Object>> list(String qry) throws AcademyException{
		
		try {
			
			PreparedStatement cmd = SQLConfiguration.getInstance().getConnection().prepareStatement(qry);  
			
			ResultSet res = cmd.executeQuery();
			
			return resultsetToList(res);
			
		} catch (Exception e) {
			throw new AcademyException(e.getMessage());
		}
		
	}

	// Funzione di creazione di una select con parametri
	public List<Map<String, Object>> list(String qry, Object[] params) throws AcademyException{
		
		try {
			
			PreparedStatement cmd = SQLConfiguration.getInstance().getConnection().prepareStatement(qry);
			
			cmd = createSet(cmd, params);
			
			ResultSet res = cmd.executeQuery();
			
			return resultsetToList(res);
			
		} catch (Exception e) {
			throw new AcademyException(e.getMessage());
		}
		
	}

	// Funzione di count per quante righe vengono restituite dalla select
	public Long count(String qry, Object[] params) throws AcademyException{
		
		try {
			
			String qryCount = "select count(*) as numero from ( " + qry + " ) as numero";
			
			PreparedStatement cmd = SQLConfiguration.getInstance().getConnection().prepareStatement(qryCount);  
			
			cmd = createSet(cmd, params);
			
			ResultSet res = cmd.executeQuery();
			res.next();
			
			return (Long) res.getObject("numero");
			
		} catch (Exception e) {
			throw new AcademyException(e.getMessage());
		}
		
	}
	
	// Funzione di select che ritorna una sola riga (usata per le ricerce "byId")
	public Map<String, Object> get(String qry, Object[] params) throws AcademyException{
		try {
			PreparedStatement cmd = SQLConfiguration.getInstance().getConnection().prepareStatement(qry);  // statement compilation
			
			cmd = createSet(cmd, params);
			
			ResultSet res = cmd.executeQuery();
			
			return resultsetToMap(res);
			
		} catch (Exception e) {
			throw new AcademyException(e.getMessage());
		}
	}
	
	// Funzione di update senza PK
	public int update(String qry, Object[] params) throws AcademyException{
		return update(qry, params, false);
	}
	
	// Funzione di update con PK
	public int update(String qry, Object[] params, boolean viewPK) throws AcademyException{
		
		int rc = 0;  
		
		try {
			
			PreparedStatement cmd = null;
			
			if (viewPK)
				cmd = SQLConfiguration.getInstance().getConnection().prepareStatement(qry,Statement.RETURN_GENERATED_KEYS);     
			else
				cmd = SQLConfiguration.getInstance().getConnection().prepareStatement(qry);  // statement compilation
			
			cmd = createSet(cmd, params);  
			
			rc = cmd.executeUpdate();  
									   	
			if (viewPK) {
				
				try(ResultSet generatedKeys = cmd.getGeneratedKeys()){   
					
					if (generatedKeys.next()) {                        
						rc = generatedKeys.getInt(1);
					} else {
						throw new SQLException("Problem with generated key, no iD obtained");
					}
					
				}
				
			}
			
		} catch (Exception e) {
			throw new AcademyException(e.getMessage());
		}
		
		return rc;
		
	}
	
	// Funzione di inserimento dei parametri "createSet"
	private PreparedStatement createSet(PreparedStatement cmd, Object[] params) {
		
		int pIdx = 1;
		
		for (Object o:params) {
			
			try {
				cmd.setObject(pIdx++, o);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return cmd;
	}

	// Funzione di trasformazione da Lista a Mappa chiave-valore
	private List<Map<String, Object>> resultsetToList(ResultSet rs) throws SQLException{
		
		ResultSetMetaData md = rs.getMetaData();
		
		int columns = md.getColumnCount();         
		
		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>(); 
		
		while(rs.next()) {
			
			Map<String, Object> row = new HashMap<String, Object>(); 
			
			for (int i=1;i <= columns; ++i) {
				row.put(md.getColumnName(i), rs.getObject(i)); 
															   
			}
			
			rows.add(row);
		}
		
		return rows;
		
	}
	
	// Funzione di trasformazione da Lista a Mappa chiave-valore a riga singola
	private Map<String, Object> resultsetToMap(ResultSet rs) throws SQLException{
		
		ResultSetMetaData md = rs.getMetaData();  
		
		int columns = md.getColumnCount();       
		
		if (!rs.next()) return null;
		
		Map<String, Object> row = new HashMap<String, Object>(); 

		for (int i=1;i <= columns; ++i) {
			row.put(md.getColumnName(i), rs.getObject(i)); 
														 
		}
	
		return row;
		
	}
	
}

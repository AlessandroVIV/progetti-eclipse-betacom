package com.betacom.jdbc.utilities;

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

import com.betacom.jdbc.exceptions.AcademyException;
import com.betacom.jdbc.singleton.SQLConfiguration;

public class SQLManager {

	public Connection getConnection() throws AcademyException{
		
		Connection con = null;
		
		try {
			
			Class.forName(SQLConfiguration.getInstance().getProperty("driver")); // Load driver with reflection

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
	
	// Qua avviene lo statement del commit SQL
	public void commit() throws AcademyException{
		
		try {
			
			SQLConfiguration.getInstance().getConnection().commit();
			
		} catch (SQLException e) {
			throw new AcademyException(e.getMessage());
		}
		
	}
	
	// Funzione inversa di quella sopra (rollback)
	public void rollback() throws AcademyException{
		
		try {
			
			SQLConfiguration.getInstance().getConnection().rollback();
			
		} catch (SQLException e) {
			throw new AcademyException(e.getMessage());
		}
		
	}
	
	/*
	 * Table list
	 */
	public List<String> listOfTable(String dbName) throws AcademyException {
		List<String> lT = new ArrayList<String>();
		try {
			DatabaseMetaData dbMD = SQLConfiguration.getInstance().getConnection().getMetaData(); // retrieve metadata from database
			
			ResultSet res = dbMD.getTables(dbName, null, null, null); // load result into resultset
			
			/*
			 * build result
			 */
			while (res.next()) {
				lT.add(res.getString("TABLE_NAME"));   // res.get.... legge parametri della riga
			}
			
			
		} catch (SQLException e) {
			throw new AcademyException(e.getMessage());
		}
		return lT;
	}
	
	/*
	 * execute select with JDBC without parameters
	 */
	public List<Map<String, Object>> list(String qry) throws AcademyException{
		try {
			PreparedStatement cmd = SQLConfiguration.getInstance().getConnection().prepareStatement(qry);  // statement compilation
			
			
			ResultSet res = cmd.executeQuery();
			
			return resultsetToList(res);
			
		} catch (Exception e) {
			throw new AcademyException(e.getMessage());
		}
		
		
	}

	public List<Map<String, Object>> list(String qry, Object[] params) throws AcademyException{
		try {
			PreparedStatement cmd = SQLConfiguration.getInstance().getConnection().prepareStatement(qry);  // statement compilation
			
			cmd = createSet(cmd, params);
			
			ResultSet res = cmd.executeQuery();
			
			return resultsetToList(res);
			
		} catch (Exception e) {
			throw new AcademyException(e.getMessage());
		}
	}

	/*
	 * execute count with JDBC with parameters
	 */
	public Long count(String qry, Object[] params) throws AcademyException{
		try {
			String qryCount = "select count(*) as numero from ( " + qry + " ) as numero";
			
			PreparedStatement cmd = SQLConfiguration.getInstance().getConnection().prepareStatement(qryCount);  // statement compilation
			
			cmd = createSet(cmd, params);
			
			ResultSet res = cmd.executeQuery();
			res.next();
			
			return (Long) res.getObject("numero");
			
		} catch (Exception e) {
			throw new AcademyException(e.getMessage());
		}
	}
	
	/*
	 * execute select with result single row .
	 */
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
	
	/*
	 * update function
	 * this function is used for insert
	 * 							 update
	 *                           delete
	 */
	
	public int update(String qry, Object[] params) throws AcademyException{
	
		return update(qry, params, false); // Cambio la logica passando semplicemente "false". Così esegue la seconda opzione dell'else qua sotto
		
	}
	
	// Update con return della primary key inserita
	public int update(String qry, Object[] params, boolean viewPK) throws AcademyException {

		int rc = 0;

		try {
			
			PreparedStatement cmd;

			// Prepara lo statement correttamente in base a viewPK
			if (viewPK) {
				cmd = SQLConfiguration.getInstance().getConnection().prepareStatement(qry, Statement.RETURN_GENERATED_KEYS);
			} else {
				cmd = SQLConfiguration.getInstance().getConnection().prepareStatement(qry);
			}

			cmd = createSet(cmd, params);
			rc = cmd.executeUpdate();

			if (viewPK) {
				try (ResultSet generatedKeys = cmd.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						rc = generatedKeys.getInt(1);
					} else {
						throw new SQLException("Creazione fallita! Nessun ID ottenuto");
					}
				}
			}

		} catch (Exception e) {
			throw new AcademyException(e.getMessage());
		}

		return rc;
	}

	
	/*
	 * insert parameters in PreparedStatement
	 */
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

	
	
	/*
	 * transform resultset in list<map>
	 * 		map: key -> column name
	 * 		     value -> column value
	 */
	private List<Map<String, Object>> resultsetToList(ResultSet rs) throws SQLException{
		ResultSetMetaData md = rs.getMetaData();   // retrieve metadata resulset
		int columns = md.getColumnCount();         // retrieve query column number
		
		
		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>(); // init result
		
		
		while(rs.next()) {
			Map<String, Object> row = new HashMap<String, Object>(); // init row
			for (int i=1;i <= columns; ++i) {
				row.put(md.getColumnName(i), rs.getObject(i)); // load map with key = query metadata 
															   //               value = reultset value
			}
			rows.add(row);
		}
		
		return rows;
		
	}
	/*
	 * transform resultset in MAP (single row)
	 */
	private Map<String, Object> resultsetToMap(ResultSet rs) throws SQLException{
		ResultSetMetaData md = rs.getMetaData();   // retrieve metadata resulset
		int columns = md.getColumnCount();         // retrieve query column number
		
		if (!rs.next())
			return null;
		
		Map<String, Object> row = new HashMap<String, Object>(); // init row
		for (int i=1;i <= columns; ++i) {
			row.put(md.getColumnName(i), rs.getObject(i)); // load map with key = query metadata 
														   //               value = reultset value
		}
	
		return row;
		
	}
	
	
	
}
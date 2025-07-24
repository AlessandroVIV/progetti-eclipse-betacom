package com.betacom.jdbc.process;

import com.betacom.jdbc.exceptions.AcademyException;
import com.betacom.jdbc.process.implementations.ProcessQuery;
import com.betacom.jdbc.process.implementations.ProcessTransaction;
import com.betacom.jdbc.process.implementations.ProcessUpdate;
import com.betacom.jdbc.process.interfaces.SQLProcess;
import com.betacom.jdbc.singleton.SQLConfiguration;

public class ProcessJDBC {

	public boolean execute() {
		
		System.out.println("Begin ProcessJDBC");
		
		SQLProcess pro = null;
		
		try {
			SQLConfiguration.getInstance().getConnection();
			System.out.println("Connection with db ok");

			System.out.println("Processo QUERY ---");
			pro = new ProcessQuery();		
			pro.execute();
			
			System.out.println("Process UPDATE ---");
			pro = new ProcessUpdate();
			pro.execute();
			
			System.out.println("Process TRANSACTION ---");
			pro = new ProcessTransaction();
			pro.execute();
			
			// Chiamo la chiusura della connessione al termine delle attività svolte
			SQLConfiguration.getInstance().closeConnection();
			System.out.println("\nConnessione chiusa!");
			
		} catch (AcademyException e) {
			e.printStackTrace();
			return false;
		}
				
		return true;
	}
	
}
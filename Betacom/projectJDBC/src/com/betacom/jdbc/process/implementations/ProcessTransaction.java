package com.betacom.jdbc.process.implementations;

import java.util.List;
import java.util.Optional;
import com.betacom.jdbc.dao.ClientiDAO;
import com.betacom.jdbc.dao.DipendentiDAO;
import com.betacom.jdbc.dao.RapportiClientiDAO;
import com.betacom.jdbc.exceptions.AcademyException;
import com.betacom.jdbc.models.Dipendenti;
import com.betacom.jdbc.models.RapportiClienti;
import com.betacom.jdbc.process.interfaces.SQLProcess;
import com.betacom.jdbc.singleton.SQLConfiguration;
import com.betacom.jdbc.utilities.SQLManager;

public class ProcessTransaction implements SQLProcess{

	private SQLManager db = new SQLManager();
	
	@Override
	public boolean execute() {
		
		boolean rc = true;
		
		ClientiDAO daoC = new ClientiDAO();
		
		DipendentiDAO daoD = new DipendentiDAO();
		
		RapportiClientiDAO daoR = new RapportiClientiDAO();
		
		try {
			
			SQLConfiguration.getInstance().setTransaction();
			
			// Creo un cliente
			Object[] params = new Object[] {
					"Stanlio Ollio",
					"12345678901LBC2",
					"Corso Francia, 8 Roma",
					"3345593286"
			};
			
			int idCliente = daoC.insert("clienti.insert", params);
			
			System.out.println("PK del cliente inserito: " + idCliente);
			
			Optional<Dipendenti> dip = daoD.findById(new Object[] {5});
			
			if(dip.isEmpty()) {		
				db.rollback();
				throw new AcademyException("Dipendente non trovato, rollback effettuato!");
			}
			
			params = new Object[] {
					"Rapporto dinamico",
					idCliente,
					dip.get().getIdDipenti()
			};
			
			int idRapporto = daoR.insert("rapporti-clienti.insert", params);
			
			System.out.println("Rapporto cliente inserito. pKey: " + idRapporto);
			
			Optional<RapportiClienti> rap = daoR.findById(new Object[]{idRapporto});

			if(rap.isEmpty()) {
				db.rollback();
				throw new AcademyException("Dipendente non trovato, rollback effettuato!");
			} 

			System.out.println("Rapporto: " + rap.get());
			
			int numero = daoR.delete("rapporti-clienti.delete", new Object[] {idRapporto});
			System.out.println("Rapporti cancellati: " + numero);
			
			numero = daoC.delete("clienti.delete", new Object[] {idCliente});
			System.out.println("Numero di righe cancellate:" + numero);
			
			System.out.println("\nCommit effettuato con successo!");
			db.commit();
			
		} catch (Exception e) {
			
			System.out.println("Errore nel programma: " + e.getMessage());
			
			try {
				
				System.out.println("\nRollback effettuato con successo!");
				
				rc = false;
				
				db.rollback();
				
			} catch (AcademyException e1) {
				System.out.println("Errore nel rollback: " + e1.getMessage());
			}

		}
		
		return rc;
		
	}
	
}

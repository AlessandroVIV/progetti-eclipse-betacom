package com.betacom.jdbc.process.implementations;

import java.util.List;
import java.util.Optional;

import com.betacom.jdbc.dao.ClientiDAO;
import com.betacom.jdbc.models.Clienti;
import com.betacom.jdbc.process.interfaces.SQLProcess;
import com.betacom.jdbc.singleton.SQLConfiguration;

public class ProcessUpdate implements SQLProcess{

	@Override
	public boolean execute() {
		
		boolean rc = true;
	
		ClientiDAO daoC = new ClientiDAO();
		
		try {
			
			SQLConfiguration.getInstance().setAutoCommit();   // autocommit settato

			Object[] params = new Object[] {
					"Inserito da Java",
					"9999999999999999",
					"Via delle Rose, 22 Gallipoli",
					"3345593286"
			};
			
			int id = daoC.insert("clienti.insert", params);
			
			System.out.println("PK del cliente inserito: " + id);
			
			List<Clienti> lC = daoC.findAll();
			lC.forEach(c -> System.out.println(c));
			
			params = new Object[] {
					"Luca Gentile",
					"Via Le dita dal naso, 33 Roma",
					id
			};
			
			int numero = daoC.update("clienti.update", params);
			
			Optional<Clienti> cli = daoC.findById(new Object[] {id});
			
			if (cli.isEmpty()) {
				System.out.println("Cliente " + cli + " non trovato!");
			}else {
				System.out.println(cli.get());
			}
			
			id = daoC.delete("clienti.delete", new Object[] {id});
			System.out.println("Numero di righe cancellate: " + id);
			
			} catch (Exception e) {
				System.out.println("Error :" + e.getMessage());
				rc = false;
			}
			
		return rc;
	}

}
package com.betacom.process;

import java.util.ArrayList;
import java.util.List;

import com.betacom.objects.Cliente;
import com.betacom.objects.DataNascita;
import com.google.gson.Gson;

public class ProcessJson {

	public boolean execute() {
		
		System.out.println("Inizia ProcessJson\n");
		
		// Passo da Classe a JSON
		Cliente p = new Cliente("Paolo", "Verdi", new DataNascita(1, 10, 1999));
		
		Gson gson = new Gson();
		
		String jsonString = gson.toJson(p);
		System.out.println("Oggetto json: " + jsonString);
		
		// Passo da JSON a Classe
		Cliente newCliente = gson.fromJson(jsonString, Cliente.class);
		System.out.println("Classe generata: " + newCliente);

		// Gestisco ora una lista in JSON
		List<Cliente> listaClienti = new ArrayList<Cliente>();
		
		listaClienti.add(new Cliente("Paolo", "Verdi", new DataNascita(1, 10, 1999)));
		listaClienti.add(new Cliente("Laura", "Bianchi", new DataNascita(15, 3, 1987)));
		listaClienti.add(new Cliente("Marco", "Rossi", new DataNascita(22, 11, 1995)));
		listaClienti.add(new Cliente("Giulia", "Neri", new DataNascita(5, 7, 2001)));
		listaClienti.add(new Cliente("Luca", "Esposito", new DataNascita(30, 9, 1980)));
		
		jsonString = gson.toJson(listaClienti);

		System.out.println("La lista dei clienti in JSON è: " + jsonString);
		
		// Da una lista JSON ad una lista di Oggetti
		List<Cliente> res = gson.fromJson(jsonString, List.class);
		System.out.println("Lista generata: " + res);
		
		return true;
		
	} 
	
}
package com.betacom.process;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.betacom.objects.Cliente;
import com.betacom.objects.ClienteStream;
import com.betacom.objects.DataNascita;
import com.betacom.objects.Generica;

public class ProcessGenerics {

	public boolean execute() {
		
		System.out.println("Inizia ProcessGenerics\n");
		
		List<ClienteStream> lc = Stream.of(
				new ClienteStream("Paolo", "Rossi", 30, 1800.00),
				new ClienteStream("Laura", "Bianchi", 25, 1500.00),
				new ClienteStream("Marco", "Verdi", 40, 2200.50),
				new ClienteStream("Giulia", "Esposito", 33, 1980.75),
				new ClienteStream("Luca", "Neri", 28, 1750.20),
				new ClienteStream("Francesca", "Russo", 45, 2500.00),
				new ClienteStream("Davide", "Conti", 22, 1300.00)
				).collect(Collectors.toList());
		
		lc.forEach(c -> System.out.println(c));
		
		Generica<ClienteStream> lg = new Generica<ClienteStream>();
		
		lg.setRc(true);
		lg.setDati(lc);
		
		System.out.println("\n" + lg);
		
		List<Cliente> lclienti = Stream.of(
			    new Cliente("Paolo", "Verdi", new DataNascita(1, 10, 1999)),
			    new Cliente("Anna", "Rossi", new DataNascita(15, 5, 2000)),
			    new Cliente("Luca", "Bianchi", new DataNascita(23, 12, 1995)),
			    new Cliente("Giulia", "Neri", new DataNascita(7, 3, 2002))
			).collect(Collectors.toList());

		Generica<Cliente> listaClientiGenerica = new Generica<Cliente>();
		
		listaClientiGenerica.setRc(true);
		listaClientiGenerica.setDati(lclienti);
		
		System.out.println(listaClientiGenerica);
		
		return true;
		
	}
	
}
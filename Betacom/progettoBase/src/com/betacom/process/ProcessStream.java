package com.betacom.process;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.betacom.objects.ClientStreamMap;
import com.betacom.objects.ClienteStream;

public class ProcessStream {

	public boolean execute() {
		
		System.out.println("Inzia ProcessStream\n");
		
		// Creazione dell'oggetto stream
//		Stream<ClienteStream> sc = Stream.of(
//				new ClienteStream("Paolo", "Rossi", 30, 1800.00),
//				new ClienteStream("Laura", "Bianchi", 25, 1500.00),
//				new ClienteStream("Marco", "Verdi", 40, 2200.50),
//				new ClienteStream("Giulia", "Esposito", 33, 1980.75),
//				new ClienteStream("Luca", "Neri", 28, 1750.20),
//				new ClienteStream("Francesca", "Russo", 45, 2500.00),
//				new ClienteStream("Davide", "Conti", 22, 1300.30)
//				);
		
		List<ClienteStream> lc = Stream.of(
				new ClienteStream("Paolo", "Rossi", 30, 1800.00),
				new ClienteStream("Laura", "Bianchi", 25, 1500.00),
				new ClienteStream("Marco", "Verdi", 40, 2200.50),
				new ClienteStream("Giulia", "Esposito", 33, 1980.75),
				new ClienteStream("Luca", "Neri", 28, 1750.20),
				new ClienteStream("Francesca", "Russo", 45, 2500.00),
				new ClienteStream("Davide", "Conti", 22, 1300.30)
				).collect(Collectors.toList());
		
		lc.forEach(c -> System.out.println(c + "\n"));
		
		// Creazione tramite Builder
		Stream<String> streamBuilder = Stream.<String> builder()
				.add("Lunedì")
				.add("Martedì")
				.add("Mercoledì")
				.add("Giovedì")
				.add("Venerdì")
				.add("Sabato")
				.add("Domenica")
				.build();
		
		// Trasformo in array di stringhe
		String [] giorni = streamBuilder.toArray(size -> new String[size]);
		
		System.out.println("Lunghezza dei giorni: " + giorni.toString() + "giorni[4]" + giorni[4]);
		
		// Creazione random
		Random rand = new Random();
		
		Stream<Integer> lg = Stream.generate(() -> rand.nextInt()).limit(5);
		lg.forEach(it -> System.out.println(it));
		
		// Generazione dati primitivi
		System.out.println("\nGenerazione interi con range:");
		IntStream intStream = IntStream.range(0, 11);
		intStream.forEach(it -> System.out.println(it));

		// Filtro usando "stream"
		lc.stream()
			.filter(c -> c.getEta() > 32)
			.filter(c -> c.getStipendio() > 1600)
			.filter(c -> c.getCognome().startsWith("E"))
			.forEach(c -> System.out.println("\nFiltro per età maggiore di 44 e con stipendio maggiore di 1600: " + c));
		
		
		// Mapping 
		System.out.println("\nTrasformazione di ClienteStream in ClienteStreamMap\n");
		
		List<ClientStreamMap> csp = lc.stream()
			    .map(c -> new ClientStreamMap(
			        c.getNome() + " " + c.getCognome(),
			        c.getEta(),
			        c.getStipendio()
			    ))
			    .collect(Collectors.toList());
		csp.forEach(c -> System.out.println(c));
			
			// Funzione di count
			long count = csp.stream()
					.filter(c -> c.getEta() >= 40)
					.count();
			
			System.out.println("\nNumero di client con età maggiore uguale a 40: " + count);
		
			// Match
			boolean rc = lc.stream()
					.anyMatch(c -> c.getCognome().startsWith("B"));
			
			System.out.println("\nRisultato del match: " + rc);
			
			// Sort
//			lc.sort(new Comparator<ClienteStream>() {
//
//				@Override
//				public int compare(ClienteStream o1, ClienteStream o2) {
//					return o1.getEta() - o2.getEta();
//				}
//				
//			});
			
			// Versione semplificata
			lc.sort((ClienteStream o1, ClienteStream o2) -> o1.getEta() - o2.getEta());
			
			lc.forEach(c -> System.out.println("\nIl risultato della comparazione è: " + c));
		
		return true;
		
	}
	
}
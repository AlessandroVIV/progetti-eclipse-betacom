package com.betacom;

import java.util.StringTokenizer;

public class MainString {

	public static void main(String[] args) {
		
		// Il metodo "StringBuilder"
		// Costruisco una stringa utilizzando "append"

		StringBuilder sb = new StringBuilder();
		
		sb.append("Buongiorno");
		sb.append(", ");
		sb.append("sono");
		sb.append(" ");
		sb.append("Alessandro");
		
		String rS = sb.toString();
		
		System.out.println(sb);
		
		// Costruisco ora una stringa utilizzando lo "String format"
		
		String n = "Alessandro";
		String f = "alto";
		
		// Le diciture "%s" sono i parametri che vado a specificare dopo
		String r = String.format("Il mio nome è: %s, sono %s ", n, f);
				
		System.out.println(r); // Output: "Il mio nome è: Alessandro, sono alto"
		
		// Se mettessi solo ".equals" non conterebbe le maiuscole
		if(n.equalsIgnoreCase("Alessandro")){
			System.out.println("Found");
		}
		else {
			System.out.println("Not found");
		}
		
		// Altra condizione, ma con la funzione ".contains" per sequenza di caratteri
		if(rS.contains(",")) {
			System.out.println("Found comma");
		}
		else {
			System.out.println("Comma not found");
		}
		
		// Comparazione delle stringhe
		String p1 = "Samsung";
		String p2 = "Samsung";
		
		int result = p1.compareTo(p2);
		
		System.out.println(result); // Output -> 0 (Nessun carattere di troppo)
		
		// Trasformare un integer in una stringa
		int numero = 20;
		
		String numeroStr = String.valueOf(numero);
		System.out.println(numeroStr); // Il numero diventa stringa
		
		// Trasformare una stringa in un array
		String parametri = "token1, token2, token3, token4, token5, token6, token7";
		
		String[] tokens = parametri.split(",");
		
		// Stampo le string dell'array
		for(String t: tokens) {
			System.out.println(t.trim());
		}
		
		// Trasformare la stringa in token
		System.out.println("\n****StringTokenizer****");
		StringTokenizer st = new StringTokenizer(parametri,",");
		
		while(st.hasMoreTokens()) {
			String tst = st.nextToken();
			System.out.println("Token trovato: " + tst.trim());
		}
		
		
		
	}

}
